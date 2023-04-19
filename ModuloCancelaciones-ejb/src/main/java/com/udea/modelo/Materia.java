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
@Table(name = "MATERIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materia.findAll", query = "SELECT m FROM Materia m")
    , @NamedQuery(name = "Materia.findByCodigoMateria", query = "SELECT m FROM Materia m WHERE m.codigoMateria = :codigoMateria")
    , @NamedQuery(name = "Materia.findByNombreMateria", query = "SELECT m FROM Materia m WHERE m.nombreMateria = :nombreMateria")
    , @NamedQuery(name = "Materia.findByCreditos", query = "SELECT m FROM Materia m WHERE m.creditos = :creditos")})
public class Materia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_MATERIA")
    private Integer codigoMateria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE_MATERIA")
    private String nombreMateria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREDITOS")
    private int creditos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoMateria")
    private Collection<MateriaSemestre> materiaSemestreCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materia")
    private Collection<Relacion> relacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materia1")
    private Collection<Relacion> relacionCollection1;

    public Materia() {
    }

    public Materia(Integer codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public Materia(Integer codigoMateria, String nombreMateria, int creditos) {
        this.codigoMateria = codigoMateria;
        this.nombreMateria = nombreMateria;
        this.creditos = creditos;
    }

    public Integer getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(Integer codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    @XmlTransient
    public Collection<MateriaSemestre> getMateriaSemestreCollection() {
        return materiaSemestreCollection;
    }

    public void setMateriaSemestreCollection(Collection<MateriaSemestre> materiaSemestreCollection) {
        this.materiaSemestreCollection = materiaSemestreCollection;
    }

    @XmlTransient
    public Collection<Relacion> getRelacionCollection() {
        return relacionCollection;
    }

    public void setRelacionCollection(Collection<Relacion> relacionCollection) {
        this.relacionCollection = relacionCollection;
    }

    @XmlTransient
    public Collection<Relacion> getRelacionCollection1() {
        return relacionCollection1;
    }

    public void setRelacionCollection1(Collection<Relacion> relacionCollection1) {
        this.relacionCollection1 = relacionCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoMateria != null ? codigoMateria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materia)) {
            return false;
        }
        Materia other = (Materia) object;
        if ((this.codigoMateria == null && other.codigoMateria != null) || (this.codigoMateria != null && !this.codigoMateria.equals(other.codigoMateria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.modelo.Materia[ codigoMateria=" + codigoMateria + " ]";
    }
    
}
