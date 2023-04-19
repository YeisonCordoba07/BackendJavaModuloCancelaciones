/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author YEISON
 */
@Entity
@Table(name = "SEMESTRE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Semestre.findAll", query = "SELECT s FROM Semestre s")
    , @NamedQuery(name = "Semestre.findByIdSemestre", query = "SELECT s FROM Semestre s WHERE s.idSemestre = :idSemestre")
    , @NamedQuery(name = "Semestre.findByFechaInicio", query = "SELECT s FROM Semestre s WHERE s.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Semestre.findByFechaTerminacion", query = "SELECT s FROM Semestre s WHERE s.fechaTerminacion = :fechaTerminacion")})
public class Semestre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SEMESTRE")
    private Integer idSemestre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_TERMINACION")
    @Temporal(TemporalType.DATE)
    private Date fechaTerminacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSemestre")
    private Collection<MateriaSemestre> materiaSemestreCollection;
    @JoinColumn(name = "ESTADO_SEMESTRE", referencedColumnName = "ID_ESTADO_SEMESTRE")
    @ManyToOne(optional = false)
    private EstadoSemestre estadoSemestre;
    @JoinColumn(name = "TIPO_SEMESTRE", referencedColumnName = "ID_TIPO_SEMESTRE")
    @ManyToOne(optional = false)
    private TipoSemestre tipoSemestre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSemestre")
    private Collection<HistoriaAcademica> historiaAcademicaCollection;

    public Semestre() {
    }

    public Semestre(Integer idSemestre) {
        this.idSemestre = idSemestre;
    }

    public Semestre(Integer idSemestre, Date fechaInicio, Date fechaTerminacion) {
        this.idSemestre = idSemestre;
        this.fechaInicio = fechaInicio;
        this.fechaTerminacion = fechaTerminacion;
    }

    public Integer getIdSemestre() {
        return idSemestre;
    }

    public void setIdSemestre(Integer idSemestre) {
        this.idSemestre = idSemestre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTerminacion() {
        return fechaTerminacion;
    }

    public void setFechaTerminacion(Date fechaTerminacion) {
        this.fechaTerminacion = fechaTerminacion;
    }

    @XmlTransient
    public Collection<MateriaSemestre> getMateriaSemestreCollection() {
        return materiaSemestreCollection;
    }

    public void setMateriaSemestreCollection(Collection<MateriaSemestre> materiaSemestreCollection) {
        this.materiaSemestreCollection = materiaSemestreCollection;
    }

    public EstadoSemestre getEstadoSemestre() {
        return estadoSemestre;
    }

    public void setEstadoSemestre(EstadoSemestre estadoSemestre) {
        this.estadoSemestre = estadoSemestre;
    }

    public TipoSemestre getTipoSemestre() {
        return tipoSemestre;
    }

    public void setTipoSemestre(TipoSemestre tipoSemestre) {
        this.tipoSemestre = tipoSemestre;
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
        hash += (idSemestre != null ? idSemestre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Semestre)) {
            return false;
        }
        Semestre other = (Semestre) object;
        if ((this.idSemestre == null && other.idSemestre != null) || (this.idSemestre != null && !this.idSemestre.equals(other.idSemestre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.modelo.Semestre[ idSemestre=" + idSemestre + " ]";
    }
    
}
