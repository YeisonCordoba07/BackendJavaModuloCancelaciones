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
@Table(name = "TERCIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tercio.findAll", query = "SELECT t FROM Tercio t")
    , @NamedQuery(name = "Tercio.findByIdTercio", query = "SELECT t FROM Tercio t WHERE t.idTercio = :idTercio")
    , @NamedQuery(name = "Tercio.findByTercio", query = "SELECT t FROM Tercio t WHERE t.tercio = :tercio")})
public class Tercio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TERCIO")
    private Integer idTercio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TERCIO")
    private String tercio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTercio")
    private Collection<HistoriaAcademica> historiaAcademicaCollection;

    public Tercio() {
    }

    public Tercio(Integer idTercio) {
        this.idTercio = idTercio;
    }

    public Tercio(Integer idTercio, String tercio) {
        this.idTercio = idTercio;
        this.tercio = tercio;
    }

    public Integer getIdTercio() {
        return idTercio;
    }

    public void setIdTercio(Integer idTercio) {
        this.idTercio = idTercio;
    }

    public String getTercio() {
        return tercio;
    }

    public void setTercio(String tercio) {
        this.tercio = tercio;
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
        hash += (idTercio != null ? idTercio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tercio)) {
            return false;
        }
        Tercio other = (Tercio) object;
        if ((this.idTercio == null && other.idTercio != null) || (this.idTercio != null && !this.idTercio.equals(other.idTercio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.modelo.Tercio[ idTercio=" + idTercio + " ]";
    }
    
}
