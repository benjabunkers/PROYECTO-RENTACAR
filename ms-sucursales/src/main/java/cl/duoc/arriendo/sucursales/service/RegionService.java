package cl.duoc.arriendo.sucursales.service;

import cl.duoc.arriendo.sucursales.dto.*;
import cl.duoc.arriendo.sucursales.exception.ResourceNotFoundException;
import cl.duoc.arriendo.sucursales.mapper.RegionMapper;
import cl.duoc.arriendo.sucursales.model.Region;
import cl.duoc.arriendo.sucursales.repository.RegionRepository;
import java.util.List;
import org.slf4j.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegionService {
  private static final Logger log = LoggerFactory.getLogger(RegionService.class);
  private final RegionRepository repository;

  public RegionService(RegionRepository repository) {
    this.repository = repository;
  }

  @Transactional(readOnly = true)
  public List<RegionDTO> findAll() {
    log.info("Listando regiones");
    return repository.findAll().stream().map(RegionMapper::toDTO).toList();
  }

  @Transactional(readOnly = true)
  public RegionDTO findById(Integer id) {
    log.info("Buscando Region {}", id);
    return repository
        .findById(id)
        .map(RegionMapper::toDTO)
        .orElseThrow(() -> new ResourceNotFoundException("Region no encontrado con id " + id));
  }

  public RegionDTO save(RegionRequestDTO d) {
    try {
      log.info("Guardando Region");
      Region x = RegionMapper.toEntity(d);
      return RegionMapper.toDTO(repository.save(x));
    } catch (RuntimeException ex) {
      log.error("Error al guardar Region", ex);
      throw ex;
    }
  }

  public RegionDTO update(Integer id, RegionRequestDTO d) {
    Region x =
        repository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Region no encontrado con id " + id));
    RegionMapper.updateEntity(x, d);
    return RegionMapper.toDTO(repository.save(x));
  }

  public void delete(Integer id) {
    if (!repository.existsById(id))
      throw new ResourceNotFoundException("Region no encontrado con id " + id);
    repository.deleteById(id);
  }
}
