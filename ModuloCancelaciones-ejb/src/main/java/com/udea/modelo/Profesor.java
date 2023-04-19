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
@Table(name = "PROFESOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesor.findAll", query = "SELECT p FROM Profesor p")
    , @NamedQuery(name = "Profesor.findByCedulaProfesor", query = "SELECT p FROM Profesor p WHERE p.cedulaProfesor = :cedulaProfesor")
    , @NamedQuery(name = "Profesor.findByNombre", query = "SELECT p FROM Profesor p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Profesor.findByApellido", query = "SELECT p FROM Profesor p WHERE p.apellido = :apellido")
    , @NamedQuery(name = "Profesor.findByCorreoInstitucional", query = "SELECT p FROM Profesor p WHERE p.correoInstitucional = :correoInstitucional")
    , @NamedQuery(name = "Profesor.findByCorreoPersonal", query = "SELECT p FROM Profesor p WHERE p.correoPersonal = :correoPersonal")
    , @NamedQuery(name = "Profesor.findByCelular", query = "SELECT p FROM Profesor p WHERE p.celular = :celular")
    , @NamedQuery(name = "Profesor.findByEstrato", query = "SELECT p FROM Profesor p WHERE p.estrato = :estrato")
    , @NamedQuery(name = "Profesor.findByFechaContratacion", query = "SELECT p FROM Profesor p WHERE p.fechaContratacion = :fechaContratacion")})
public class Profesor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "CEDULA_PROFESOR")
    private String cedulaProfesor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "APELLIDO")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "CORREO_INSTITUCIONAL")
    private String correoInstitucional;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "CORREO_PERSONAL")
    private String correoPersonal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "CELULAR")
    private String celular;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ESTRATO")
    private String estrato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "FECHA_CONTRATACION")
    private String fechaContratacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cedulaProfesor")
    private Collection<MateriaSemestre> materiaSemestreCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cedulaProfesor")
    private Collection<SolicitudCancelacion> solicitudCancelacionCollection;

    public Profesor() {
    }

    public Profesor(String cedulaProfesor) {
        this.cedulaProfesor = cedulaProfesor;
    }

    public Profesor(String cedulaProfesor, String nombre, String apellido, String correoInstitucional, String correoPersonal, String celular, String estrato, String fechaContratacion) {
        this.cedulaProfesor = cedulaProfesor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoInstitucional = correoInstitucional;
        this.correoPersonal = correoPersonal;
        this.celular = celular;
        this.estrato = estrato;
        this.fechaContratacion = fechaContratacion;
    }

    public String getCedulaProfesor() {
        return cedulaProfesor;
    }

    public void setCedulaProfesor(String cedulaProfesor) {
        this.cedulaProfesor = cedulaProfesor;
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

    public String getEstrato() {
        return estrato;
    }

    public void setEstrato(String estrato) {
        this.estrato = estrato;
    }

    public String getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(String fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedulaProfesor != null ? cedulaProfesor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesor)) {
            return false;
        }
        Profesor other = (Profesor) object;
        if ((this.cedulaProfesor == null && other.cedulaProfesor != null) || (this.cedulaProfesor != null && !this.cedulaProfesor.equals(other.cedulaProfesor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.modelo.Profesor[ cedulaProfesor=" + cedulaProfesor + " ]";
    }
    
}
