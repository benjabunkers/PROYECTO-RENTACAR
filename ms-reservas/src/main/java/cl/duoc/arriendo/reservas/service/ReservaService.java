package cl.duoc.arriendo.reservas.service;

import cl.duoc.arriendo.reservas.dto.*;
import cl.duoc.arriendo.reservas.exception.ResourceNotFoundException;
import cl.duoc.arriendo.reservas.mapper.ReservaMapper;
import cl.duoc.arriendo.reservas.model.EstadoReserva;
import cl.duoc.arriendo.reservas.model.Reserva;
import cl.duoc.arriendo.reservas.repository.EstadoReservaRepository;
import cl.duoc.arriendo.reservas.repository.ReservaRepository;
import java.time.LocalDate;
import java.util.List;
import org.slf4j.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReservaService {
  private static final Logger log = LoggerFactory.getLogger(ReservaService.class);
  private final ReservaRepository repository;
  private final EstadoReservaRepository estadoReservaRepository;
  private final cl.duoc.arriendo.reservas.client.ClienteClient clienteClient;
  private final cl.duoc.arriendo.reservas.client.VehiculoClient vehiculoClient;

  public ReservaService(
      ReservaRepository repository,
      EstadoReservaRepository estadoReservaRepository,
      cl.duoc.arriendo.reservas.client.ClienteClient clienteClient,
      cl.duoc.arriendo.reservas.client.VehiculoClient vehiculoClient) {
    this.repository = repository;
    this.estadoReservaRepository = estadoReservaRepository;
    this.clienteClient = clienteClient;
    this.vehiculoClient = vehiculoClient;
  }

  @Transactional(readOnly = true)
  public List<ReservaDTO> findAll() {
    log.info("Listando reservas");
    return repository.findAll().stream().map(ReservaMapper::toDTO).toList();
  }

  @Transactional(readOnly = true)
  public ReservaDTO findById(Integer id) {
    log.info("Buscando Reserva {}", id);
    return repository
        .findById(id)
        .map(ReservaMapper::toDTO)
        .orElseThrow(() -> new ResourceNotFoundException("Reserva no encontrado con id " + id));
  }

  public ReservaDTO save(ReservaRequestDTO d) {
    try {
      log.info("Guardando Reserva");
      clienteClient.obtenerPorId(d.clienteId());
      var v = vehiculoClient.obtenerPorId(d.vehiculoId());
      if (!Boolean.TRUE.equals(v.disponible()))
        throw new IllegalArgumentException("El vehiculo no se encuentra disponible");
      Reserva x = ReservaMapper.toEntity(d);
      asignarEstadoReserva(x, d.estadoReservaId());
      return ReservaMapper.toDTO(repository.save(x));
    } catch (RuntimeException ex) {
      log.error("Error al guardar Reserva", ex);
      throw ex;
    }
  }

  public ReservaDTO update(Integer id, ReservaRequestDTO d) {
    Reserva x =
        repository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Reserva no encontrado con id " + id));
    ReservaMapper.updateEntity(x, d);
    asignarEstadoReserva(x, d.estadoReservaId());
    return ReservaMapper.toDTO(repository.save(x));
  }

  public void delete(Integer id) {
    if (!repository.existsById(id))
      throw new ResourceNotFoundException("Reserva no encontrado con id " + id);
    repository.deleteById(id);
  }

  public List<ReservaDTO> buscarDesdeFecha(LocalDate fecha) {
    return repository.buscarDesdeFecha(fecha).stream().map(ReservaMapper::toDTO).toList();
  }

  private void asignarEstadoReserva(Reserva x, Integer id) {
    EstadoReserva p =
        estadoReservaRepository
            .findById(id)
            .orElseThrow(
                () -> new ResourceNotFoundException("EstadoReserva no encontrado con id " + id));
    x.setEstadoReserva(p);
  }
}
