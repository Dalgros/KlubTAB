/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jpa.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Karol
 */
@Entity
@Table(name = "KONTRAKT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kontrakt.findAll", query = "SELECT k FROM Kontrakt k"),
    @NamedQuery(name = "Kontrakt.findByIdZawodnik", query = "SELECT k FROM Kontrakt k WHERE k.kontraktPK.idZawodnik = :idZawodnik"),
    @NamedQuery(name = "Kontrakt.findByIdDruzyna", query = "SELECT k FROM Kontrakt k WHERE k.kontraktPK.idDruzyna = :idDruzyna"),
    @NamedQuery(name = "Kontrakt.findByPoczatekKontraktu", query = "SELECT k FROM Kontrakt k WHERE k.poczatekKontraktu = :poczatekKontraktu"),
    @NamedQuery(name = "Kontrakt.findByKoniecKontraktu", query = "SELECT k FROM Kontrakt k WHERE k.koniecKontraktu = :koniecKontraktu"),
    @NamedQuery(name = "Kontrakt.findByPensja", query = "SELECT k FROM Kontrakt k WHERE k.pensja = :pensja"),
    @NamedQuery(name = "Kontrakt.findByWartoscRynkowa", query = "SELECT k FROM Kontrakt k WHERE k.wartoscRynkowa = :wartoscRynkowa")})
public class Kontrakt implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected KontraktPK kontraktPK;
    @Column(name = "POCZATEK_KONTRAKTU")
    @Temporal(TemporalType.DATE)
    private Date poczatekKontraktu;
    @Column(name = "KONIEC_KONTRAKTU")
    @Temporal(TemporalType.DATE)
    private Date koniecKontraktu;
    @Column(name = "PENSJA")
    private BigInteger pensja;
    @Column(name = "WARTOSC_RYNKOWA")
    private BigInteger wartoscRynkowa;
    @JoinColumn(name = "ID_DRUZYNA", referencedColumnName = "ID_DRUZYNA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Druzyna druzyna;
    @JoinColumn(name = "ID_ZAWODNIK", referencedColumnName = "ID_ZAWODNIK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Zawodnik zawodnik;

    public Kontrakt() {
    }

    public Kontrakt(KontraktPK kontraktPK) {
        this.kontraktPK = kontraktPK;
    }

    public Kontrakt(BigInteger idZawodnik, BigInteger idDruzyna) {
        this.kontraktPK = new KontraktPK(idZawodnik, idDruzyna);
    }

    public KontraktPK getKontraktPK() {
        return kontraktPK;
    }

    public void setKontraktPK(KontraktPK kontraktPK) {
        this.kontraktPK = kontraktPK;
    }

    public Date getPoczatekKontraktu() {
        return poczatekKontraktu;
    }

    public void setPoczatekKontraktu(Date poczatekKontraktu) {
        this.poczatekKontraktu = poczatekKontraktu;
    }

    public Date getKoniecKontraktu() {
        return koniecKontraktu;
    }

    public void setKoniecKontraktu(Date koniecKontraktu) {
        this.koniecKontraktu = koniecKontraktu;
    }

    public BigInteger getPensja() {
        return pensja;
    }

    public void setPensja(BigInteger pensja) {
        this.pensja = pensja;
    }

    public BigInteger getWartoscRynkowa() {
        return wartoscRynkowa;
    }

    public void setWartoscRynkowa(BigInteger wartoscRynkowa) {
        this.wartoscRynkowa = wartoscRynkowa;
    }

    public Druzyna getDruzyna() {
        return druzyna;
    }

    public void setDruzyna(Druzyna druzyna) {
        this.druzyna = druzyna;
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
        hash += (kontraktPK != null ? kontraktPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kontrakt)) {
            return false;
        }
        Kontrakt other = (Kontrakt) object;
        if ((this.kontraktPK == null && other.kontraktPK != null) || (this.kontraktPK != null && !this.kontraktPK.equals(other.kontraktPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.jpa.model.Kontrakt[ kontraktPK=" + kontraktPK + " ]";
    }
    
}
