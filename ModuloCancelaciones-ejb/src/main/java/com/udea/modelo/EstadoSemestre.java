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
@Table(name = "ESTADO_SEMESTRE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoSemestre.findAll", query = "SELECT e FROM EstadoSemestre e")
    , @NamedQuery(name = "EstadoSemestre.findByIdEstadoSemestre", query = "SELECT e FROM EstadoSemestre e WHERE e.idEstadoSemestre = :idEstadoSemestre")
    , @NamedQuery(name = "EstadoSemestre.findByEstadoSemestre", query = "SELECT e FROM EstadoSemestre e WHERE e.estadoSemestre = :estadoSemestre")})
public class EstadoSemestre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ESTADO_SEMESTRE")
    private Integer idEstadoSemestre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ESTADO_SEMESTRE")
    private String estadoSemestre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoSemestre")
    private Collection<Semestre> semestreCollection;

    public EstadoSemestre() {
    }

    public EstadoSemestre(Integer idEstadoSemestre) {
        this.idEstadoSemestre = idEstadoSemestre;
    }

    public EstadoSemestre(Integer idEstadoSemestre, String estadoSemestre) {
        this.idEstadoSemestre = idEstadoSemestre;
        this.estadoSemestre = estadoSemestre;
    }

    public Integer getIdEstadoSemestre() {
        return idEstadoSemestre;
    }

    public void setIdEstadoSemestre(Integer idEstadoSemestre) {
        this.idEstadoSemestre = idEstadoSemestre;
    }

    public String getEstadoSemestre() {
        return estadoSemestre;
    }

    public void setEstadoSemestre(String estadoSemestre) {
        this.estadoSemestre = estadoSemestre;
    }

    @XmlTransient
    public Collection<Semestre> getSemestreCollection() {
        return semestreCollection;
    }

    public void setSemestreCollection(Collection<Semestre> semestreCollection) {
        this.semestreCollection = semestreCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoSemestre != null ? idEstadoSemestre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoSemestre)) {
            return false;
        }
        EstadoSemestre other = (EstadoSemestre) object;
        if ((this.idEstadoSemestre == null && other.idEstadoSemestre != null) || (this.idEstadoSemestre != null && !this.idEstadoSemestre.equals(other.idEstadoSemestre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.modelo.EstadoSemestre[ idEstadoSemestre=" + idEstadoSemestre + " ]";
    }
    
}
