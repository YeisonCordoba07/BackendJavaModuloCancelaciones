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
@Table(name = "SITUACION_ACADEMIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SituacionAcademia.findAll", query = "SELECT s FROM SituacionAcademia s")
    , @NamedQuery(name = "SituacionAcademia.findByIdSituacionAcademica", query = "SELECT s FROM SituacionAcademia s WHERE s.idSituacionAcademica = :idSituacionAcademica")
    , @NamedQuery(name = "SituacionAcademia.findBySituacionAcademica", query = "SELECT s FROM SituacionAcademia s WHERE s.situacionAcademica = :situacionAcademica")})
public class SituacionAcademia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SITUACION_ACADEMICA")
    private Integer idSituacionAcademica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SITUACION_ACADEMICA")
    private String situacionAcademica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "situacionAcademica")
    private Collection<HistoriaAcademica> historiaAcademicaCollection;

    public SituacionAcademia() {
    }

    public SituacionAcademia(Integer idSituacionAcademica) {
        this.idSituacionAcademica = idSituacionAcademica;
    }

    public SituacionAcademia(Integer idSituacionAcademica, String situacionAcademica) {
        this.idSituacionAcademica = idSituacionAcademica;
        this.situacionAcademica = situacionAcademica;
    }

    public Integer getIdSituacionAcademica() {
        return idSituacionAcademica;
    }

    public void setIdSituacionAcademica(Integer idSituacionAcademica) {
        this.idSituacionAcademica = idSituacionAcademica;
    }

    public String getSituacionAcademica() {
        return situacionAcademica;
    }

    public void setSituacionAcademica(String situacionAcademica) {
        this.situacionAcademica = situacionAcademica;
    }

    @XmlTransient
    public Collection<HistoriaAcademica> getHistoriaAcademicaCollection() {
        return historiaAcademicaCollection;
    }

    public void setHistoriaAcademicaCollection(Collection<HistoriaAcademica> historiaAcademicaCollection) {
        this.historiaAcademicaCollection = historiaAcademicaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSituacionAcademica != null ? idSituacionAcademica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SituacionAcademia)) {
            return false;
        }
        SituacionAcademia other = (SituacionAcademia) object;
        if ((this.idSituacionAcademica == null && other.idSituacionAcademica != null) || (this.idSituacionAcademica != null && !this.idSituacionAcademica.equals(other.idSituacionAcademica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.modelo.SituacionAcademia[ idSituacionAcademica=" + idSituacionAcademica + " ]";
    }
    
}
