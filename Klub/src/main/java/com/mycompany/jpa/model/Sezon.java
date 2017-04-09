/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jpa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Karol
 */
@Entity
@Table(name = "SEZON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sezon.findAll", query = "SELECT s FROM Sezon s"),
    @NamedQuery(name = "Sezon.findByIdSezon", query = "SELECT s FROM Sezon s WHERE s.idSezon = :idSezon"),
    @NamedQuery(name = "Sezon.findByRok", query = "SELECT s FROM Sezon s WHERE s.rok = :rok")})
public class Sezon implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SEZON")
    private BigDecimal idSezon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROK")
    private short rok;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sezon")
    private List<Zawodnik_Statystyki> zawodnikStatystykiList;

    public Sezon() {
    }

    public Sezon(BigDecimal idSezon) {
        this.idSezon = idSezon;
    }

    public Sezon(BigDecimal idSezon, short rok) {
        this.idSezon = idSezon;
        this.rok = rok;
    }

    public BigDecimal getIdSezon() {
        return idSezon;
    }

    public void setIdSezon(BigDecimal idSezon) {
        this.idSezon = idSezon;
    }

    public short getRok() {
        return rok;
    }

    public void setRok(short rok) {
        this.rok = rok;
    }

    @XmlTransient
    public List<Zawodnik_Statystyki> getZawodnikStatystykiList() {
        return zawodnikStatystykiList;
    }

    public void setZawodnikStatystykiList(List<Zawodnik_Statystyki> zawodnikStatystykiList) {
        this.zawodnikStatystykiList = zawodnikStatystykiList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSezon != null ? idSezon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sezon)) {
            return false;
        }
        Sezon other = (Sezon) object;
        if ((this.idSezon == null && other.idSezon != null) || (this.idSezon != null && !this.idSezon.equals(other.idSezon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.jpa.model.Sezon[ idSezon=" + idSezon + " ]";
    }
    
}
