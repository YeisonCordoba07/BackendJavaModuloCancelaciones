/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author YEISON
 */
@Entity
@Table(name = "ESTADO_SOLICITUD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoSolicitud.findAll", query = "SELECT e FROM EstadoSolicitud e")
    , @NamedQuery(name = "EstadoSolicitud.findByIdEstadoSolicitud", query = "SELECT e FROM EstadoSolicitud e WHERE e.idEstadoSolicitud = :idEstadoSolicitud")
    , @NamedQuery(name = "EstadoSolicitud.findByEstadoSolicitud", query = "SELECT e FROM EstadoSolicitud e WHERE e.estadoSolicitud = :estadoSolicitud")})
public class EstadoSolicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ESTADO_SOLICITUD")
    private Integer idEstadoSolicitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ESTADO_SOLICITUD")
    private String estadoSolicitud;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoSolicitud")
    private Collection<SolicitudCancelacion> solicitudCancelacionCollection;

    public EstadoSolicitud() {
    }

    public EstadoSolicitud(Integer idEstadoSolicitud) {
        this.idEstadoSolicitud = idEstadoSolicitud;
    }

    public EstadoSolicitud(Integer idEstadoSolicitud, String estadoSolicitud) {
        this.idEstadoSolicitud = idEstadoSolicitud;
        this.estadoSolicitud = estadoSolicitud;
    }

    public Integer getIdEstadoSolicitud() {
        return idEstadoSolicitud;
    }

    public void setIdEstadoSolicitud(Integer idEstadoSolicitud) {
        this.idEstadoSolicitud = idEstadoSolicitud;
    }

    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(String estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    @XmlTransient
    public Collection<SolicitudCancelacion> getSolicitudCancelacionCollection() {
        return solicitudCancelacionCollection;
    }

    public void setSolicitudCancelacionCollection(Collection<SolicitudCancelacion> solicitudCancelacionCollection) {
        this.solicitudCancelacionCollection = solicitudCancelacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoSolicitud != null ? idEstadoSolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoSolicitud)) {
            return false;
        }
        EstadoSolicitud other = (EstadoSolicitud) object;
        if ((this.idEstadoSolicitud == null && other.idEstadoSolicitud != null) || (this.idEstadoSolicitud != null && !this.idEstadoSolicitud.equals(other.idEstadoSolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.modelo.EstadoSolicitud[ idEstadoSolicitud=" + idEstadoSolicitud + " ]";
    }
    
}
