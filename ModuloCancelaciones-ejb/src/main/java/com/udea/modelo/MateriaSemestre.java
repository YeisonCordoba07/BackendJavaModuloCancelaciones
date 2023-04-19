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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author YEISON
 */
@Entity
@Table(name = "MATERIA_SEMESTRE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MateriaSemestre.findAll", query = "SELECT m FROM MateriaSemestre m")
    , @NamedQuery(name = "MateriaSemestre.findByIdMateriaSemestre", query = "SELECT m FROM MateriaSemestre m WHERE m.idMateriaSemestre = :idMateriaSemestre")
    , @NamedQuery(name = "MateriaSemestre.findByNota", query = "SELECT m FROM MateriaSemestre m WHERE m.nota = :nota")
    , @NamedQuery(name = "MateriaSemestre.findByPorcentajeEvaluado", query = "SELECT m FROM MateriaSemestre m WHERE m.porcentajeEvaluado = :porcentajeEvaluado")})
public class MateriaSemestre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_MATERIA_SEMESTRE")
    private Integer idMateriaSemestre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NOTA")
    private short nota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PORCENTAJE_EVALUADO")
    private int porcentajeEvaluado;
    @JoinColumn(name = "CEDULA_ESTUDIANTE", referencedColumnName = "CEDULA")
    @ManyToOne(optional = false)
    private Estudiante cedulaEstudiante;
    @JoinColumn(name = "CODIGO_MATERIA", referencedColumnName = "CODIGO_MATERIA")
    @ManyToOne(optional = false)
    private Materia codigoMateria;
    @JoinColumn(name = "CEDULA_PROFESOR", referencedColumnName = "CEDULA_PROFESOR")
    @ManyToOne(optional = false)
    private Profesor cedulaProfesor;
    @JoinColumn(name = "ID_SEMESTRE", referencedColumnName = "ID_SEMESTRE")
    @ManyToOne(optional = false)
    private Semestre idSemestre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMateriaSemestre")
    private Collection<SolicitudCancelacion> solicitudCancelacionCollection;

    public MateriaSemestre() {
    }

    public MateriaSemestre(Integer idMateriaSemestre) {
        this.idMateriaSemestre = idMateriaSemestre;
    }

    public MateriaSemestre(Integer idMateriaSemestre, short nota, int porcentajeEvaluado) {
        this.idMateriaSemestre = idMateriaSemestre;
        this.nota = nota;
        this.porcentajeEvaluado = porcentajeEvaluado;
    }

    public Integer getIdMateriaSemestre() {
        return idMateriaSemestre;
    }

    public void setIdMateriaSemestre(Integer idMateriaSemestre) {
        this.idMateriaSemestre = idMateriaSemestre;
    }

    public short getNota() {
        return nota;
    }

    public void setNota(short nota) {
        this.nota = nota;
    }

    public int getPorcentajeEvaluado() {
        return porcentajeEvaluado;
    }

    public void setPorcentajeEvaluado(int porcentajeEvaluado) {
        this.porcentajeEvaluado = porcentajeEvaluado;
    }

    public Estudiante getCedulaEstudiante() {
        return cedulaEstudiante;
    }

    public void setCedulaEstudiante(Estudiante cedulaEstudiante) {
        this.cedulaEstudiante = cedulaEstudiante;
    }

    public Materia getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(Materia codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public Profesor getCedulaProfesor() {
        return cedulaProfesor;
    }

    public void setCedulaProfesor(Profesor cedulaProfesor) {
        this.cedulaProfesor = cedulaProfesor;
    }

    public Semestre getIdSemestre() {
        return idSemestre;
    }

    public void setIdSemestre(Semestre idSemestre) {
        this.idSemestre = idSemestre;
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
        hash += (idMateriaSemestre != null ? idMateriaSemestre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MateriaSemestre)) {
            return false;
        }
        MateriaSemestre other = (MateriaSemestre) object;
        if ((this.idMateriaSemestre == null && other.idMateriaSemestre != null) || (this.idMateriaSemestre != null && !this.idMateriaSemestre.equals(other.idMateriaSemestre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.modelo.MateriaSemestre[ idMateriaSemestre=" + idMateriaSemestre + " ]";
    }
    
}
