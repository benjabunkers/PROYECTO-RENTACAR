package cl.duoc.arriendo.reservas.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "estados_reserva")
public class EstadoReserva {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private String nombre;

  @Column(nullable = false)
  private String descripcion;

  @Column(nullable = false)
  private Integer ordenFlujo;

  @Column(nullable = false)
  private Boolean requierePago = true;

  @Column(nullable = false)
  private Boolean activo = true;

  @Column(nullable = false)
  private LocalDate fechaCreacion;

  @OneToMany(mappedBy = "estadoReserva", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Reserva> reservas = new ArrayList<>();

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

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public Integer getOrdenFlujo() {
    return ordenFlujo;
  }

  public void setOrdenFlujo(Integer ordenFlujo) {
    this.ordenFlujo = ordenFlujo;
  }

  public Boolean getRequierePago() {
    return requierePago;
  }

  public void setRequierePago(Boolean requierePago) {
    this.requierePago = requierePago;
  }

  public Boolean getActivo() {
    return activo;
  }

  public void setActivo(Boolean activo) {
    this.activo = activo;
  }

  public LocalDate getFechaCreacion() {
    return fechaCreacion;
  }

  public void setFechaCreacion(LocalDate fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
  }

  public List<Reserva> getReservas() {
    return reservas;
  }

  public void setReservas(List<Reserva> reservas) {
    this.reservas = reservas;
  }
}
