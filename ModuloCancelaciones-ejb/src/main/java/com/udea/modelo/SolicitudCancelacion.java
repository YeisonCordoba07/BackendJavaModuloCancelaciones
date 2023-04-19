/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YEISON
 */
@Entity
@Table(name = "SOLICITUD_CANCELACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitudCancelacion.findAll", query = "SELECT s FROM SolicitudCancelacion s")
    , @NamedQuery(name = "SolicitudCancelacion.findByIdCancelacion", query = "SELECT s FROM SolicitudCancelacion s WHERE s.idCancelacion = :idCancelacion")
    , @NamedQuery(name = "SolicitudCancelacion.findByFechaSolicitud", query = "SELECT s FROM SolicitudCancelacion s WHERE s.fechaSolicitud = :fechaSolicitud")
    , @NamedQuery(name = "SolicitudCancelacion.findByComentario", query = "SELECT s FROM SolicitudCancelacion s WHERE s.comentario = :comentario")})
public class SolicitudCancelacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CANCELACION")
    private Integer idCancelacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_SOLICITUD")
    @Temporal(TemporalType.DATE)
    private Date fechaSolicitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "COMENTARIO")
    private String comentario;
    @JoinColumn(name = "ESTADO_SOLICITUD", referencedColumnName = "ID_ESTADO_SOLICITUD")
    @ManyToOne(optional = false)
    private EstadoSolicitud estadoSolicitud;
    @JoinColumn(name = "CEDULA_ESTUDIANTE", referencedColumnName = "CEDULA")
    @ManyToOne(optional = false)
    private Estudiante cedulaEstudiante;
    @JoinColumn(name = "ID_MATERIA_SEMESTRE", referencedColumnName = "ID_MATERIA_SEMESTRE")
    @ManyToOne(optional = false)
    private MateriaSemestre idMateriaSemestre;
    @JoinColumn(name = "CEDULA_PROFESOR", referencedColumnName = "CEDULA_PROFESOR")
    @ManyToOne(optional = false)
    private Profesor cedulaProfesor;

    
    /*Se pone a las claves foraneas que tengan ManyTo-Algo
    Esto es para que retorne el valor y no el identificador
    */
    //---------------------------------------------   
    public int getIdEstadoSolicitud(){
        return this.estadoSolicitud.getIdEstadoSolicitud();
    }
    public void setIdEstadoSolicitud(int estado){
        this.estadoSolicitud = new EstadoSolicitud(estado);
    }
    
    //---------------------------------------------   
    public String getCedula(){
        return this.cedulaEstudiante.getCedula();
    }
    public void setCedula(String cedula){
        this.cedulaEstudiante = new Estudiante(cedula);
    }
    
    //---------------------------------------------   
    public int getIdMateriaSemestre1(){
        return this.idMateriaSemestre.getIdMateriaSemestre();
    }
    public void setIdMateriaSemestre1(int id){
        this.idMateriaSemestre = new MateriaSemestre(id);
    }
    
    //---------------------------------------------
    public String getCedulaProfesor1(){
        return this.cedulaProfesor.getCedulaProfesor();
    }
    public void setCedulaProfesor1(String cedulaProfesor){
        this.cedulaProfesor = new Profesor(cedulaProfesor);
    }
    //---------------------------------------------    
    
    
    public SolicitudCancelacion() {
    }

    public SolicitudCancelacion(Integer idCancelacion) {
        this.idCancelacion = idCancelacion;
    }

    public SolicitudCancelacion(Integer idCancelacion, Date fechaSolicitud, String comentario) {
        this.idCancelacion = idCancelacion;
        this.fechaSolicitud = fechaSolicitud;
        this.comentario = comentario;
    }

    public Integer getIdCancelacion() {
        return idCancelacion;
    }

    public void setIdCancelacion(Integer idCancelacion) {
        this.idCancelacion = idCancelacion;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public EstadoSolicitud getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(EstadoSolicitud estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    public Estudiante getCedulaEstudiante() {
        return cedulaEstudiante;
    }

    public void setCedulaEstudiante(Estudiante cedulaEstudiante) {
        this.cedulaEstudiante = cedulaEstudiante;
    }

    public MateriaSemestre getIdMateriaSemestre() {
        return idMateriaSemestre;
    }

    public void setIdMateriaSemestre(MateriaSemestre idMateriaSemestre) {
        this.idMateriaSemestre = idMateriaSemestre;
    }

    public Profesor getCedulaProfesor() {
        return cedulaProfesor;
    }

    public void setCedulaProfesor(Profesor cedulaProfesor) {
        this.cedulaProfesor = cedulaProfesor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCancelacion != null ? idCancelacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudCancelacion)) {
            return false;
        }
        SolicitudCancelacion other = (SolicitudCancelacion) object;
        if ((this.idCancelacion == null && other.idCancelacion != null) || (this.idCancelacion != null && !this.idCancelacion.equals(other.idCancelacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.modelo.SolicitudCancelacion[ idCancelacion=" + idCancelacion + " ]";
    }

}
