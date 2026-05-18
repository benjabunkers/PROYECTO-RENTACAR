package cl.duoc.arriendo.sucursales.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sucursals")
public class Sucursal {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private String nombre;

  @Column(nullable = false)
  private String direccion;

  @Column(nullable = false)
  private String telefono;

  @Column(nullable = false)
  private String codigoSucursal;

  @Column(nullable = false)
  private Integer capacidadVehiculos;

  @Column(nullable = false)
  private Boolean operativa = true;

  @Column(nullable = false)
  private LocalDate fechaApertura;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "region_id", nullable = false)
  private Region region;

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

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getCodigoSucursal() {
    return codigoSucursal;
  }

  public void setCodigoSucursal(String codigoSucursal) {
    this.codigoSucursal = codigoSucursal;
  }

  public Integer getCapacidadVehiculos() {
    return capacidadVehiculos;
  }

  public void setCapacidadVehiculos(Integer capacidadVehiculos) {
    this.capacidadVehiculos = capacidadVehiculos;
  }

  public Boolean getOperativa() {
    return operativa;
  }

  public void setOperativa(Boolean operativa) {
    this.operativa = operativa;
  }

  public LocalDate getFechaApertura() {
    return fechaApertura;
  }

  public void setFechaApertura(LocalDate fechaApertura) {
    this.fechaApertura = fechaApertura;
  }

  public Region getRegion() {
    return region;
  }

  public void setRegion(Region region) {
    this.region = region;
  }
}
