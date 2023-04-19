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
@Table(name = "TIPO_SEMESTRE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoSemestre.findAll", query = "SELECT t FROM TipoSemestre t")
    , @NamedQuery(name = "TipoSemestre.findByIdTipoSemestre", query = "SELECT t FROM TipoSemestre t WHERE t.idTipoSemestre = :idTipoSemestre")
    , @NamedQuery(name = "TipoSemestre.findByTipoSemestre", query = "SELECT t FROM TipoSemestre t WHERE t.tipoSemestre = :tipoSemestre")})
public class TipoSemestre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_SEMESTRE")
    private Integer idTipoSemestre;
    @Size(max = 50)
    @Column(name = "TIPO_SEMESTRE")
    private String tipoSemestre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoSemestre")
    private Collection<Semestre> semestreCollection;

    public TipoSemestre() {
    }

    public TipoSemestre(Integer idTipoSemestre) {
        this.idTipoSemestre = idTipoSemestre;
    }

    public Integer getIdTipoSemestre() {
        return idTipoSemestre;
    }

    public void setIdTipoSemestre(Integer idTipoSemestre) {
        this.idTipoSemestre = idTipoSemestre;
    }

    public String getTipoSemestre() {
        return tipoSemestre;
    }

    public void setTipoSemestre(String tipoSemestre) {
        this.tipoSemestre = tipoSemestre;
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
        hash += (idTipoSemestre != null ? idTipoSemestre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoSemestre)) {
            return false;
        }
        TipoSemestre other = (TipoSemestre) object;
        if ((this.idTipoSemestre == null && other.idTipoSemestre != null) || (this.idTipoSemestre != null && !this.idTipoSemestre.equals(other.idTipoSemestre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.modelo.TipoSemestre[ idTipoSemestre=" + idTipoSemestre + " ]";
    }
    
}
