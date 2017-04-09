/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jpa.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Karol
 */
@Entity
@Table(name = "ZAWODNIK_STATYSTYKI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ZawodnikStatystyki.findAll", query = "SELECT z FROM ZawodnikStatystyki z"),
    @NamedQuery(name = "ZawodnikStatystyki.findByIdZawodnik", query = "SELECT z FROM ZawodnikStatystyki z WHERE z.zawodnikStatystykiPK.idZawodnik = :idZawodnik"),
    @NamedQuery(name = "ZawodnikStatystyki.findByIdSezon", query = "SELECT z FROM ZawodnikStatystyki z WHERE z.zawodnikStatystykiPK.idSezon = :idSezon"),
    @NamedQuery(name = "ZawodnikStatystyki.findByStrzeloneBramki", query = "SELECT z FROM ZawodnikStatystyki z WHERE z.strzeloneBramki = :strzeloneBramki"),
    @NamedQuery(name = "ZawodnikStatystyki.findByStraconeBramki", query = "SELECT z FROM ZawodnikStatystyki z WHERE z.straconeBramki = :straconeBramki"),
    @NamedQuery(name = "ZawodnikStatystyki.findByZolteKartki", query = "SELECT z FROM ZawodnikStatystyki z WHERE z.zolteKartki = :zolteKartki"),
    @NamedQuery(name = "ZawodnikStatystyki.findByCzerwoneKartki", query = "SELECT z FROM ZawodnikStatystyki z WHERE z.czerwoneKartki = :czerwoneKartki"),
    @NamedQuery(name = "ZawodnikStatystyki.findByFaule", query = "SELECT z FROM ZawodnikStatystyki z WHERE z.faule = :faule"),
    @NamedQuery(name = "ZawodnikStatystyki.findByRozegraneMinuty", query = "SELECT z FROM ZawodnikStatystyki z WHERE z.rozegraneMinuty = :rozegraneMinuty")})
public class Zawodnik_Statystyki implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Zawodnik_StatystykiPK zawodnikStatystykiPK;
    @Column(name = "STRZELONE_BRAMKI")
    private Short strzeloneBramki;
    @Column(name = "STRACONE_BRAMKI")
    private Short straconeBramki;
    @Column(name = "ZOLTE_KARTKI")
    private Short zolteKartki;
    @Column(name = "CZERWONE_KARTKI")
    private Short czerwoneKartki;
    @Column(name = "FAULE")
    private Short faule;
    @Column(name = "ROZEGRANE_MINUTY")
    private BigInteger rozegraneMinuty;
    @JoinColumn(name = "ID_SEZON", referencedColumnName = "ID_SEZON", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sezon sezon;
    @JoinColumn(name = "ID_ZAWODNIK", referencedColumnName = "ID_ZAWODNIK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Zawodnik zawodnik;

    public Zawodnik_Statystyki() {
    }

    public Zawodnik_Statystyki(Zawodnik_StatystykiPK zawodnikStatystykiPK) {
        this.zawodnikStatystykiPK = zawodnikStatystykiPK;
    }

    public Zawodnik_Statystyki(BigInteger idZawodnik, BigInteger idSezon) {
        this.zawodnikStatystykiPK = new Zawodnik_StatystykiPK(idZawodnik, idSezon);
    }

    public Zawodnik_StatystykiPK getZawodnikStatystykiPK() {
        return zawodnikStatystykiPK;
    }

    public void setZawodnikStatystykiPK(Zawodnik_StatystykiPK zawodnikStatystykiPK) {
        this.zawodnikStatystykiPK = zawodnikStatystykiPK;
    }

    public Short getStrzeloneBramki() {
        return strzeloneBramki;
    }

    public void setStrzeloneBramki(Short strzeloneBramki) {
        this.strzeloneBramki = strzeloneBramki;
    }

    public Short getStraconeBramki() {
        return straconeBramki;
    }

    public void setStraconeBramki(Short straconeBramki) {
        this.straconeBramki = straconeBramki;
    }

    public Short getZolteKartki() {
        return zolteKartki;
    }

    public void setZolteKartki(Short zolteKartki) {
        this.zolteKartki = zolteKartki;
    }

    public Short getCzerwoneKartki() {
        return czerwoneKartki;
    }

    public void setCzerwoneKartki(Short czerwoneKartki) {
        this.czerwoneKartki = czerwoneKartki;
    }

    public Short getFaule() {
        return faule;
    }

    public void setFaule(Short faule) {
        this.faule = faule;
    }

    public BigInteger getRozegraneMinuty() {
        return rozegraneMinuty;
    }

    public void setRozegraneMinuty(BigInteger rozegraneMinuty) {
        this.rozegraneMinuty = rozegraneMinuty;
    }

    public Sezon getSezon() {
        return sezon;
    }

    public void setSezon(Sezon sezon) {
        this.sezon = sezon;
    }

    public Zawodnik getZawodnik() {
        return zawodnik;
    }

    public void setZawodnik(Zawodnik zawodnik) {
        this.zawodnik = zawodnik;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zawodnikStatystykiPK != null ? zawodnikStatystykiPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zawodnik_Statystyki)) {
            return false;
        }
        Zawodnik_Statystyki other = (Zawodnik_Statystyki) object;
        if ((this.zawodnikStatystykiPK == null && other.zawodnikStatystykiPK != null) || (this.zawodnikStatystykiPK != null && !this.zawodnikStatystykiPK.equals(other.zawodnikStatystykiPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.jpa.model.ZawodnikStatystyki[ zawodnikStatystykiPK=" + zawodnikStatystykiPK + " ]";
    }
    
}
