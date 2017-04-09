/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jpa.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Karol
 */
@Embeddable
public class Zawodnik_StatystykiPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ZAWODNIK")
    private BigInteger idZawodnik;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SEZON")
    private BigInteger idSezon;

    public Zawodnik_StatystykiPK() {
    }

    public Zawodnik_StatystykiPK(BigInteger idZawodnik, BigInteger idSezon) {
        this.idZawodnik = idZawodnik;
        this.idSezon = idSezon;
    }

    public BigInteger getIdZawodnik() {
        return idZawodnik;
    }

    public void setIdZawodnik(BigInteger idZawodnik) {
        this.idZawodnik = idZawodnik;
    }

    public BigInteger getIdSezon() {
        return idSezon;
    }

    public void setIdSezon(BigInteger idSezon) {
        this.idSezon = idSezon;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idZawodnik != null ? idZawodnik.hashCode() : 0);
        hash += (idSezon != null ? idSezon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zawodnik_StatystykiPK)) {
            return false;
        }
        Zawodnik_StatystykiPK other = (Zawodnik_StatystykiPK) object;
        if ((this.idZawodnik == null && other.idZawodnik != null) || (this.idZawodnik != null && !this.idZawodnik.equals(other.idZawodnik))) {
            return false;
        }
        if ((this.idSezon == null && other.idSezon != null) || (this.idSezon != null && !this.idSezon.equals(other.idSezon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.jpa.model.ZawodnikStatystykiPK[ idZawodnik=" + idZawodnik + ", idSezon=" + idSezon + " ]";
    }
    
}
