/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author brsbr
 */
@Entity
@Table(name = "detalle_ventas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleVentas.findAll", query = "SELECT d FROM DetalleVentas d")
    , @NamedQuery(name = "DetalleVentas.findByIdDetalleVentas", query = "SELECT d FROM DetalleVentas d WHERE d.idDetalleVentas = :idDetalleVentas")
    , @NamedQuery(name = "DetalleVentas.findByCantidad", query = "SELECT d FROM DetalleVentas d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "DetalleVentas.findByPrecioVenta", query = "SELECT d FROM DetalleVentas d WHERE d.precioVenta = :precioVenta")})
public class DetalleVentas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDetalleVentas")
    private Integer idDetalleVentas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PrecioVenta")
    private double precioVenta;
    @JoinColumn(name = "idProductos", referencedColumnName = "idProductos")
    @ManyToOne(optional = false)
    private Producto idProductos;
    @JoinColumn(name = "idVentas", referencedColumnName = "idVenta")
    @ManyToOne(optional = false)
    private Venta idVentas;

    public DetalleVentas() {
    }

    public DetalleVentas(Integer idDetalleVentas) {
        this.idDetalleVentas = idDetalleVentas;
    }

    public DetalleVentas(Integer idDetalleVentas, int cantidad, double precioVenta) {
        this.idDetalleVentas = idDetalleVentas;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
    }

    public Integer getIdDetalleVentas() {
        return idDetalleVentas;
    }

    public void setIdDetalleVentas(Integer idDetalleVentas) {
        this.idDetalleVentas = idDetalleVentas;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Producto getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(Producto idProductos) {
        this.idProductos = idProductos;
    }

    public Venta getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(Venta idVentas) {
        this.idVentas = idVentas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleVentas != null ? idDetalleVentas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleVentas)) {
            return false;
        }
        DetalleVentas other = (DetalleVentas) object;
        if ((this.idDetalleVentas == null && other.idDetalleVentas != null) || (this.idDetalleVentas != null && !this.idDetalleVentas.equals(other.idDetalleVentas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.DetalleVentas[ idDetalleVentas=" + idDetalleVentas + " ]";
    }
    
}
