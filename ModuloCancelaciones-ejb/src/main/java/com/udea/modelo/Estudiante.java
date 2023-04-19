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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author YEISON
 */
@Entity
@Table(name = "ESTUDIANTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e")
    , @NamedQuery(name = "Estudiante.findByCedula", query = "SELECT e FROM Estudiante e WHERE e.cedula = :cedula")
    , @NamedQuery(name = "Estudiante.findByNombre", query = "SELECT e FROM Estudiante e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Estudiante.findByApellido", query = "SELECT e FROM Estudiante e WHERE e.apellido = :apellido")
    , @NamedQuery(name = "Estudiante.findByCorreoInstitucional", query = "SELECT e FROM Estudiante e WHERE e.correoInstitucional = :correoInstitucional")
    , @NamedQuery(name = "Estudiante.findByCorreoPersonal", query = "SELECT e FROM Estudiante e WHERE e.correoPersonal = :correoPersonal")
    , @NamedQuery(name = "Estudiante.findByCelular", query = "SELECT e FROM Estudiante e WHERE e.celular = :celular")
    , @NamedQuery(name = "Estudiante.findByEstrato", query = "SELECT e FROM Estudiante e WHERE e.estrato = :estrato")
    , @NamedQuery(name = "Estudiante.findByFechaIngreso", query = "SELECT e FROM Estudiante e WHERE e.fechaIngreso = :fechaIngreso")})
public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "CEDULA")
    private String cedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "APELLIDO")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CORREO_INSTITUCIONAL")
    private String correoInstitucional;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CORREO_PERSONAL")
    private String correoPersonal;
    @Size(max = 30)
    @Column(name = "CELULAR")
    private String celular;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTRATO")
    private int estrato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INGRESO")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cedulaEstudiante")
    private Collection<MateriaSemestre> materiaSemestreCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cedulaEstudiante")
    private Collection<SolicitudCancelacion> solicitudCancelacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cedulaEstudiante")
    private Collection<HistoriaAcademica> historiaAcademicaCollection;

    public Estudiante() {
    }

    public Estudiante(String cedula) {
        this.cedula = cedula;
    }

    public Estudiante(String cedula, String nombre, String apellido, String correoInstitucional, String correoPersonal, int estrato, Date fechaIngreso) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoInstitucional = correoInstitucional;
        this.correoPersonal = correoPersonal;
        this.estrato = estrato;
        this.fechaIngreso = fechaIngreso;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }

    public String getCorreoPersonal() {
        return correoPersonal;
    }

    public void setCorreoPersonal(String correoPersonal) {
        this.correoPersonal = correoPersonal;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getEstrato() {
        return estrato;
    }

    public void setEstrato(int estrato) {
        this.estrato = estrato;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @XmlTransient
    public Collection<MateriaSemestre> getMateriaSemestreCollection() {
        return materiaSemestreCollection;
    }

    public void setMateriaSemestreCollection(Collection<MateriaSemestre> materiaSemestreCollection) {
        this.materiaSemestreCollection = materiaSemestreCollection;
    }

    @XmlTransient
    public Collection<SolicitudCancelacion> getSolicitudCancelacionCollection() {
        return solicitudCancelacionCollection;
    }

    public void setSolicitudCancelacionCollection(Collection<SolicitudCancelacion> solicitudCancelacionCollection) {
        this.solicitudCancelacionCollection = solicitudCancelacionCollection;
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
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.modelo.Estudiante[ cedula=" + cedula + " ]";
    }
    
}
