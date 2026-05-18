package cl.duoc.arriendo.reservas.service;

import cl.duoc.arriendo.reservas.dto.*;
import cl.duoc.arriendo.reservas.exception.ResourceNotFoundException;
import cl.duoc.arriendo.reservas.mapper.EstadoReservaMapper;
import cl.duoc.arriendo.reservas.model.EstadoReserva;
import cl.duoc.arriendo.reservas.repository.EstadoReservaRepository;
import java.util.List;
import org.slf4j.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EstadoReservaService {
  private static final Logger log = LoggerFactory.getLogger(EstadoReservaService.class);
  private final EstadoReservaRepository repository;

  public EstadoReservaService(EstadoReservaRepository repository) {
    this.repository = repository;
  }

  @Transactional(readOnly = true)
  public List<EstadoReservaDTO> findAll() {
    log.info("Listando estados_reserva");
    return repository.findAll().stream().map(EstadoReservaMapper::toDTO).toList();
  }

  @Transactional(readOnly = true)
  public EstadoReservaDTO findById(Integer id) {
    log.info("Buscando EstadoReserva {}", id);
    return repository
        .findById(id)
        .map(EstadoReservaMapper::toDTO)
        .orElseThrow(
            () -> new ResourceNotFoundException("EstadoReserva no encontrado con id " + id));
  }

  public EstadoReservaDTO save(EstadoReservaRequestDTO d) {
    try {
      log.info("Guardando EstadoReserva");
      EstadoReserva x = EstadoReservaMapper.toEntity(d);
      return EstadoReservaMapper.toDTO(repository.save(x));
    } catch (RuntimeException ex) {
      log.error("Error al guardar EstadoReserva", ex);
      throw ex;
    }
  }

  public EstadoReservaDTO update(Integer id, EstadoReservaRequestDTO d) {
    EstadoReserva x =
        repository
            .findById(id)
            .orElseThrow(
                () -> new ResourceNotFoundException("EstadoReserva no encontrado con id " + id));
    EstadoReservaMapper.updateEntity(x, d);
    return EstadoReservaMapper.toDTO(repository.save(x));
  }

  public void delete(Integer id) {
    if (!repository.existsById(id))
      throw new ResourceNotFoundException("EstadoReserva no encontrado con id " + id);
    repository.deleteById(id);
  }
}
