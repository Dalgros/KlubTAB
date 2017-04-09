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
public class KontraktPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ZAWODNIK")
    private BigInteger idZawodnik;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DRUZYNA")
    private BigInteger idDruzyna;

    public KontraktPK() {
    }

    public KontraktPK(BigInteger idZawodnik, BigInteger idDruzyna) {
        this.idZawodnik = idZawodnik;
        this.idDruzyna = idDruzyna;
    }

    public BigInteger getIdZawodnik() {
        return idZawodnik;
    }

    public void setIdZawodnik(BigInteger idZawodnik) {
        this.idZawodnik = idZawodnik;
    }

    public BigInteger getIdDruzyna() {
        return idDruzyna;
    }

    public void setIdDruzyna(BigInteger idDruzyna) {
        this.idDruzyna = idDruzyna;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idZawodnik != null ? idZawodnik.hashCode() : 0);
        hash += (idDruzyna != null ? idDruzyna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KontraktPK)) {
            return false;
        }
        KontraktPK other = (KontraktPK) object;
        if ((this.idZawodnik == null && other.idZawodnik != null) || (this.idZawodnik != null && !this.idZawodnik.equals(other.idZawodnik))) {
            return false;
        }
        if ((this.idDruzyna == null && other.idDruzyna != null) || (this.idDruzyna != null && !this.idDruzyna.equals(other.idDruzyna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.jpa.model.KontraktPK[ idZawodnik=" + idZawodnik + ", idDruzyna=" + idDruzyna + " ]";
    }
    
}
