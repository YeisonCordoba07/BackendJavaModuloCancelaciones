/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YEISON
 */
@Entity
@Table(name = "HISTORIA_ACADEMICA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoriaAcademica.findAll", query = "SELECT h FROM HistoriaAcademica h")
    , @NamedQuery(name = "HistoriaAcademica.findByIdHistoriaAcademica", query = "SELECT h FROM HistoriaAcademica h WHERE h.idHistoriaAcademica = :idHistoriaAcademica")
    , @NamedQuery(name = "HistoriaAcademica.findByCodigoPrograma", query = "SELECT h FROM HistoriaAcademica h WHERE h.codigoPrograma = :codigoPrograma")
    , @NamedQuery(name = "HistoriaAcademica.findByPromedioAcumulado", query = "SELECT h FROM HistoriaAcademica h WHERE h.promedioAcumulado = :promedioAcumulado")
    , @NamedQuery(name = "HistoriaAcademica.findByPromedioSemestre", query = "SELECT h FROM HistoriaAcademica h WHERE h.promedioSemestre = :promedioSemestre")})
public class HistoriaAcademica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_HISTORIA_ACADEMICA")
    private Integer idHistoriaAcademica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_PROGRAMA")
    private int codigoPrograma;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROMEDIO_ACUMULADO")
    private short promedioAcumulado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROMEDIO_SEMESTRE")
    private short promedioSemestre;
    @JoinColumn(name = "CEDULA_ESTUDIANTE", referencedColumnName = "CEDULA")
    @ManyToOne(optional = false)
    private Estudiante cedulaEstudiante;
    @JoinColumn(name = "ID_SEMESTRE", referencedColumnName = "ID_SEMESTRE")
    @ManyToOne(optional = false)
    private Semestre idSemestre;
    @JoinColumn(name = "SITUACION_ACADEMICA", referencedColumnName = "ID_SITUACION_ACADEMICA")
    @ManyToOne(optional = false)
    private SituacionAcademia situacionAcademica;
    @JoinColumn(name = "ID_TERCIO", referencedColumnName = "ID_TERCIO")
    @ManyToOne(optional = false)
    private Tercio idTercio;

    public HistoriaAcademica() {
    }

    public HistoriaAcademica(Integer idHistoriaAcademica) {
        this.idHistoriaAcademica = idHistoriaAcademica;
    }

    public HistoriaAcademica(Integer idHistoriaAcademica, int codigoPrograma, short promedioAcumulado, short promedioSemestre) {
        this.idHistoriaAcademica = idHistoriaAcademica;
        this.codigoPrograma = codigoPrograma;
        this.promedioAcumulado = promedioAcumulado;
        this.promedioSemestre = promedioSemestre;
    }

    public Integer getIdHistoriaAcademica() {
        return idHistoriaAcademica;
    }

    public void setIdHistoriaAcademica(Integer idHistoriaAcademica) {
        this.idHistoriaAcademica = idHistoriaAcademica;
    }

    public int getCodigoPrograma() {
        return codigoPrograma;
    }

    public void setCodigoPrograma(int codigoPrograma) {
        this.codigoPrograma = codigoPrograma;
    }

    public short getPromedioAcumulado() {
        return promedioAcumulado;
    }

    public void setPromedioAcumulado(short promedioAcumulado) {
        this.promedioAcumulado = promedioAcumulado;
    }

    public short getPromedioSemestre() {
        return promedioSemestre;
    }

    public void setPromedioSemestre(short promedioSemestre) {
        this.promedioSemestre = promedioSemestre;
    }

    public Estudiante getCedulaEstudiante() {
        return cedulaEstudiante;
    }

    public void setCedulaEstudiante(Estudiante cedulaEstudiante) {
        this.cedulaEstudiante = cedulaEstudiante;
    }

    public Semestre getIdSemestre() {
        return idSemestre;
    }

    public void setIdSemestre(Semestre idSemestre) {
        this.idSemestre = idSemestre;
    }

    public SituacionAcademia getSituacionAcademica() {
        return situacionAcademica;
    }

    public void setSituacionAcademica(SituacionAcademia situacionAcademica) {
        this.situacionAcademica = situacionAcademica;
    }

    public Tercio getIdTercio() {
        return idTercio;
    }

    public void setIdTercio(Tercio idTercio) {
        this.idTercio = idTercio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistoriaAcademica != null ? idHistoriaAcademica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoriaAcademica)) {
            return false;
        }
        HistoriaAcademica other = (HistoriaAcademica) object;
        if ((this.idHistoriaAcademica == null && other.idHistoriaAcademica != null) || (this.idHistoriaAcademica != null && !this.idHistoriaAcademica.equals(other.idHistoriaAcademica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.modelo.HistoriaAcademica[ idHistoriaAcademica=" + idHistoriaAcademica + " ]";
    }
    
}
