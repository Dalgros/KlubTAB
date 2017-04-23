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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author Karol
 */
@Entity
@Table(name = "SEKCJA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sekcja.findByIdKlub", query = "SELECT s FROM Sekcja s WHERE s.idKlub = :idKlub")})
public class Sekcja implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SEKCJA")
    private BigDecimal idSekcja;
    @Size(max = 20)
    @Column(name = "DYSCYPLINA")
    private String dyscyplina;
    @Size(max = 1)
    @Column(name = "PLEC")
    private String plec;
    @JoinColumn(name = "ID_KLUB", referencedColumnName = "ID_KLUB")
    @ManyToOne(optional = false)
    private Klub idKlub;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSekcja")
    private List<Druzyna> druzynaList;

    public Sekcja() {
    }

    public Sekcja(BigDecimal idSekcja) {
        this.idSekcja = idSekcja;
    }

    public BigDecimal getIdSekcja() {
        return idSekcja;
    }

    public void setIdSekcja(BigDecimal idSekcja) {
        this.idSekcja = idSekcja;
    }

    public String getDyscyplina() {
        return dyscyplina;
    }

    public void setDyscyplina(String dyscyplina) {
        this.dyscyplina = dyscyplina;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public Klub getIdKlub() {
        return idKlub;
    }

    public void setIdKlub(Klub idKlub) {
        this.idKlub = idKlub;
    }

    @XmlTransient
    public List<Druzyna> getDruzynaList() {
        return druzynaList;
    }

    public void setDruzynaList(List<Druzyna> druzynaList) {
        this.druzynaList = druzynaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSekcja != null ? idSekcja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sekcja)) {
            return false;
        }
        Sekcja other = (Sekcja) object;
        if ((this.idSekcja == null && other.idSekcja != null) || (this.idSekcja != null && !this.idSekcja.equals(other.idSekcja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.jpa.model.Sekcja[ idSekcja=" + idSekcja + " ]";
    }
    
}
