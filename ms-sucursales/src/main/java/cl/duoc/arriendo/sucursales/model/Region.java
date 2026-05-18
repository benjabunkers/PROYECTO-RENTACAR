package cl.duoc.arriendo.sucursales.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "regiones")
public class Region {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private String nombre;

  @Column(nullable = false)
  private String codigo;

  @Column(nullable = false)
  private Integer numeroRegion;

  @Column(nullable = false, precision = 12, scale = 2)
  private BigDecimal superficieKm2;

  @Column(nullable = false)
  private Boolean activa = true;

  @Column(nullable = false)
  private LocalDate fechaCreacion;

  @OneToMany(mappedBy = "region", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Sucursal> sucursales = new ArrayList<>();

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public Integer getNumeroRegion() {
    return numeroRegion;
  }

  public void setNumeroRegion(Integer numeroRegion) {
    this.numeroRegion = numeroRegion;
  }

  public BigDecimal getSuperficieKm2() {
    return superficieKm2;
  }

  public void setSuperficieKm2(BigDecimal superficieKm2) {
    this.superficieKm2 = superficieKm2;
  }

  public Boolean getActiva() {
    return activa;
  }

  public void setActiva(Boolean activa) {
    this.activa = activa;
  }

  public LocalDate getFechaCreacion() {
    return fechaCreacion;
  }

  public void setFechaCreacion(LocalDate fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
  }

  public List<Sucursal> getSucursales() {
    return sucursales;
  }

  public void setSucursales(List<Sucursal> sucursales) {
    this.sucursales = sucursales;
  }
}
