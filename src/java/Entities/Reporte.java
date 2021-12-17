/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author brsbr
 */
@Entity
@Table(name = "reporte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reporte.findAll", query = "SELECT r FROM Reporte r")
    , @NamedQuery(name = "Reporte.findByIdReporte", query = "SELECT r FROM Reporte r WHERE r.idReporte = :idReporte")
    , @NamedQuery(name = "Reporte.findByDesde", query = "SELECT r FROM Reporte r WHERE r.desde = :desde")
    , @NamedQuery(name = "Reporte.findByHasta", query = "SELECT r FROM Reporte r WHERE r.hasta = :hasta")})
public class Reporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idReporte")
    private Integer idReporte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Desde")
    @Temporal(TemporalType.DATE)
    private Date desde;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Hasta")
    @Temporal(TemporalType.DATE)
    private Date hasta;
    @JoinColumn(name = "idProductos", referencedColumnName = "idProductos")
    @ManyToOne(optional = false)
    private Producto idProductos;
    @JoinColumn(name = "idVenta", referencedColumnName = "idVenta")
    @ManyToOne(optional = false)
    private Venta idVenta;

    public Reporte() {
    }

    public Reporte(Integer idReporte) {
        this.idReporte = idReporte;
    }

    public Reporte(Integer idReporte, Date desde, Date hasta) {
        this.idReporte = idReporte;
        this.desde = desde;
        this.hasta = hasta;
    }

    public Integer getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(Integer idReporte) {
        this.idReporte = idReporte;
    }

    public Date getDesde() {
        return desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public Date getHasta() {
        return hasta;
    }

    public void setHasta(Date hasta) {
        this.hasta = hasta;
    }

    public Producto getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(Producto idProductos) {
        this.idProductos = idProductos;
    }

    public Venta getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Venta idVenta) {
        this.idVenta = idVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReporte != null ? idReporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reporte)) {
            return false;
        }
        Reporte other = (Reporte) object;
        if ((this.idReporte == null && other.idReporte != null) || (this.idReporte != null && !this.idReporte.equals(other.idReporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Reporte[ idReporte=" + idReporte + " ]";
    }
    
}
