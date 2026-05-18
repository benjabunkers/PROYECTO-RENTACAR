package cl.duoc.arriendo.reservas.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservas")
public class Reserva {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private String codigoReserva;

  @Column(nullable = false)
  private Integer clienteId;

  @Column(nullable = false)
  private Integer vehiculoId;

  @Column(nullable = false)
  private LocalDate fechaInicio;

  @Column(nullable = false)
  private LocalDate fechaFin;

  @Column(nullable = false)
  private Integer dias;

  @Column(nullable = false, precision = 12, scale = 2)
  private BigDecimal total;

  @Column(nullable = false)
  private Boolean activa = true;

  @Column(nullable = false)
  private LocalDate fechaCreacion;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "estado_reserva_id", nullable = false)
  private EstadoReserva estadoReserva;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCodigoReserva() {
    return codigoReserva;
  }

  public void setCodigoReserva(String codigoReserva) {
    this.codigoReserva = codigoReserva;
  }

  public Integer getClienteId() {
    return clienteId;
  }

  public void setClienteId(Integer clienteId) {
    this.clienteId = clienteId;
  }

  public Integer getVehiculoId() {
    return vehiculoId;
  }

  public void setVehiculoId(Integer vehiculoId) {
    this.vehiculoId = vehiculoId;
  }

  public LocalDate getFechaInicio() {
    return fechaInicio;
  }

  public void setFechaInicio(LocalDate fechaInicio) {
    this.fechaInicio = fechaInicio;
  }

  public LocalDate getFechaFin() {
    return fechaFin;
  }

  public void setFechaFin(LocalDate fechaFin) {
    this.fechaFin = fechaFin;
  }

  public Integer getDias() {
    return dias;
  }

  public void setDias(Integer dias) {
    this.dias = dias;
  }

  public BigDecimal getTotal() {
    return total;
  }

  public void setTotal(BigDecimal total) {
    this.total = total;
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

  public EstadoReserva getEstadoReserva() {
    return estadoReserva;
  }

  public void setEstadoReserva(EstadoReserva estadoReserva) {
    this.estadoReserva = estadoReserva;
  }
}
