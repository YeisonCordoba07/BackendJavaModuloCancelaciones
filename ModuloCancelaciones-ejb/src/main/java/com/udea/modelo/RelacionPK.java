/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author YEISON
 */
@Embeddable
public class RelacionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_MATERIA")
    private int codigoMateria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_MATERIA_RELACIONADA")
    private int codigoMateriaRelacionada;

    public RelacionPK() {
    }

    public RelacionPK(int codigoMateria, int codigoMateriaRelacionada) {
        this.codigoMateria = codigoMateria;
        this.codigoMateriaRelacionada = codigoMateriaRelacionada;
    }

    public int getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(int codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public int getCodigoMateriaRelacionada() {
        return codigoMateriaRelacionada;
    }

    public void setCodigoMateriaRelacionada(int codigoMateriaRelacionada) {
        this.codigoMateriaRelacionada = codigoMateriaRelacionada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoMateria;
        hash += (int) codigoMateriaRelacionada;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelacionPK)) {
            return false;
        }
        RelacionPK other = (RelacionPK) object;
        if (this.codigoMateria != other.codigoMateria) {
            return false;
        }
        if (this.codigoMateriaRelacionada != other.codigoMateriaRelacionada) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.modelo.RelacionPK[ codigoMateria=" + codigoMateria + ", codigoMateriaRelacionada=" + codigoMateriaRelacionada + " ]";
    }
    
}
