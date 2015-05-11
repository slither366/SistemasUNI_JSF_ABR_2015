/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.egcc.ventasjpa.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Gustavo Coronel
 */
@Entity
@Table(name = "VENTA")
@NamedQueries({
  @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v"),
  @NamedQuery(name = "Venta.findByIdventa", query = "SELECT v FROM Venta v WHERE v.idventa = :idventa"),
  @NamedQuery(name = "Venta.findByCliente", query = "SELECT v FROM Venta v WHERE v.cliente = :cliente"),
  @NamedQuery(name = "Venta.findByFecha", query = "SELECT v FROM Venta v WHERE v.fecha = :fecha"),
  @NamedQuery(name = "Venta.findByImporte", query = "SELECT v FROM Venta v WHERE v.importe = :importe")})
public class Venta implements Serializable {
  private static final long serialVersionUID = 1L;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Id
  @Basic(optional = false)
  @Column(name = "IDVENTA")
  private BigDecimal idventa;
  @Basic(optional = false)
  @Column(name = "CLIENTE")
  private String cliente;
  @Basic(optional = false)
  @Column(name = "FECHA")
  @Temporal(TemporalType.TIMESTAMP)
  private Date fecha;
  @Basic(optional = false)
  @Column(name = "IMPORTE")
  private BigDecimal importe;
  @JoinColumn(name = "IDEMP", referencedColumnName = "IDEMP")
  @ManyToOne(fetch = FetchType.LAZY)
  private Empleado idemp;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idventa", fetch = FetchType.LAZY)
  private List<Detalle> detalleList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idventa", fetch = FetchType.LAZY)
  private List<Pago> pagoList;

  public Venta() {
  }

  public Venta(BigDecimal idventa) {
    this.idventa = idventa;
  }

  public Venta(BigDecimal idventa, String cliente, Date fecha, BigDecimal importe) {
    this.idventa = idventa;
    this.cliente = cliente;
    this.fecha = fecha;
    this.importe = importe;
  }

  public BigDecimal getIdventa() {
    return idventa;
  }

  public void setIdventa(BigDecimal idventa) {
    this.idventa = idventa;
  }

  public String getCliente() {
    return cliente;
  }

  public void setCliente(String cliente) {
    this.cliente = cliente;
  }

  public Date getFecha() {
    return fecha;
  }

  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  public BigDecimal getImporte() {
    return importe;
  }

  public void setImporte(BigDecimal importe) {
    this.importe = importe;
  }

  public Empleado getIdemp() {
    return idemp;
  }

  public void setIdemp(Empleado idemp) {
    this.idemp = idemp;
  }

  public List<Detalle> getDetalleList() {
    return detalleList;
  }

  public void setDetalleList(List<Detalle> detalleList) {
    this.detalleList = detalleList;
  }

  public List<Pago> getPagoList() {
    return pagoList;
  }

  public void setPagoList(List<Pago> pagoList) {
    this.pagoList = pagoList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idventa != null ? idventa.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Venta)) {
      return false;
    }
    Venta other = (Venta) object;
    if ((this.idventa == null && other.idventa != null) || (this.idventa != null && !this.idventa.equals(other.idventa))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "pe.egcc.ventasjpa.domain.Venta[ idventa=" + idventa + " ]";
  }
  
}
