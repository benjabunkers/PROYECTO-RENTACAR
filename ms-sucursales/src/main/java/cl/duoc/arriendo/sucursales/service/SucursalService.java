package cl.duoc.arriendo.sucursales.service;

import cl.duoc.arriendo.sucursales.dto.*;
import cl.duoc.arriendo.sucursales.exception.ResourceNotFoundException;
import cl.duoc.arriendo.sucursales.mapper.SucursalMapper;
import cl.duoc.arriendo.sucursales.model.Region;
import cl.duoc.arriendo.sucursales.model.Sucursal;
import cl.duoc.arriendo.sucursales.repository.RegionRepository;
import cl.duoc.arriendo.sucursales.repository.SucursalRepository;
import java.util.List;
import org.slf4j.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SucursalService {
  private static final Logger log = LoggerFactory.getLogger(SucursalService.class);
  private final SucursalRepository repository;
  private final RegionRepository regionRepository;

  public SucursalService(SucursalRepository repository, RegionRepository regionRepository) {
    this.repository = repository;
    this.regionRepository = regionRepository;
  }

  @Transactional(readOnly = true)
  public List<SucursalDTO> findAll() {
    log.info("Listando sucursals");
    return repository.findAll().stream().map(SucursalMapper::toDTO).toList();
  }

  @Transactional(readOnly = true)
  public SucursalDTO findById(Integer id) {
    log.info("Buscando Sucursal {}", id);
    return repository
        .findById(id)
        .map(SucursalMapper::toDTO)
        .orElseThrow(() -> new ResourceNotFoundException("Sucursal no encontrado con id " + id));
  }

  public SucursalDTO save(SucursalRequestDTO d) {
    try {
      log.info("Guardando Sucursal");
      Sucursal x = SucursalMapper.toEntity(d);
      asignarRegion(x, d.regionId());
      return SucursalMapper.toDTO(repository.save(x));
    } catch (RuntimeException ex) {
      log.error("Error al guardar Sucursal", ex);
      throw ex;
    }
  }

  public SucursalDTO update(Integer id, SucursalRequestDTO d) {
    Sucursal x =
        repository
            .findById(id)
            .orElseThrow(
                () -> new ResourceNotFoundException("Sucursal no encontrado con id " + id));
    SucursalMapper.updateEntity(x, d);
    asignarRegion(x, d.regionId());
    return SucursalMapper.toDTO(repository.save(x));
  }

  public void delete(Integer id) {
    if (!repository.existsById(id))
      throw new ResourceNotFoundException("Sucursal no encontrado con id " + id);
    repository.deleteById(id);
  }

  public List<SucursalDTO> listarOperativasOrdenadas() {
    return repository.listarOperativasOrdenadas().stream().map(SucursalMapper::toDTO).toList();
  }

  private void asignarRegion(Sucursal x, Integer id) {
    Region p =
        regionRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Region no encontrado con id " + id));
    x.setRegion(p);
  }
}
