/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YEISON
 */
@Entity
@Table(name = "RELACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relacion.findAll", query = "SELECT r FROM Relacion r")
    , @NamedQuery(name = "Relacion.findByCodigoMateria", query = "SELECT r FROM Relacion r WHERE r.relacionPK.codigoMateria = :codigoMateria")
    , @NamedQuery(name = "Relacion.findByCodigoMateriaRelacionada", query = "SELECT r FROM Relacion r WHERE r.relacionPK.codigoMateriaRelacionada = :codigoMateriaRelacionada")
    , @NamedQuery(name = "Relacion.findByTipoRelacion", query = "SELECT r FROM Relacion r WHERE r.tipoRelacion = :tipoRelacion")})
public class Relacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RelacionPK relacionPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "TIPO_RELACION")
    private String tipoRelacion;
    @JoinColumn(name = "CODIGO_MATERIA_RELACIONADA", referencedColumnName = "CODIGO_MATERIA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Materia materia;
    @JoinColumn(name = "CODIGO_MATERIA", referencedColumnName = "CODIGO_MATERIA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Materia materia1;

    public Relacion() {
    }

    public Relacion(RelacionPK relacionPK) {
        this.relacionPK = relacionPK;
    }

    public Relacion(RelacionPK relacionPK, String tipoRelacion) {
        this.relacionPK = relacionPK;
        this.tipoRelacion = tipoRelacion;
    }

    public Relacion(int codigoMateria, int codigoMateriaRelacionada) {
        this.relacionPK = new RelacionPK(codigoMateria, codigoMateriaRelacionada);
    }

    public RelacionPK getRelacionPK() {
        return relacionPK;
    }

    public void setRelacionPK(RelacionPK relacionPK) {
        this.relacionPK = relacionPK;
    }

    public String getTipoRelacion() {
        return tipoRelacion;
    }

    public void setTipoRelacion(String tipoRelacion) {
        this.tipoRelacion = tipoRelacion;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Materia getMateria1() {
        return materia1;
    }

    public void setMateria1(Materia materia1) {
        this.materia1 = materia1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (relacionPK != null ? relacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relacion)) {
            return false;
        }
        Relacion other = (Relacion) object;
        if ((this.relacionPK == null && other.relacionPK != null) || (this.relacionPK != null && !this.relacionPK.equals(other.relacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.modelo.Relacion[ relacionPK=" + relacionPK + " ]";
    }
    
}
