/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jpa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author Karol
 */
@Entity
@Table(name = "BUDYNEK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Budynek.findByIdKlub", query = "SELECT b FROM Budynek b WHERE b.idKlub = :idKlub")})
public class Budynek implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_BUDYNEK")
    private BigDecimal idBudynek;
    @Size(max = 6)
    @Column(name = "KOD_POCZTOWY")
    private String kodPocztowy;
    @Size(max = 20)
    @Column(name = "MIEJSCOWOSC")
    private String miejscowosc;
    @Size(max = 20)
    @Column(name = "ULICANUMER")
    private String ulicanumer;
    @Size(max = 50)
    @Column(name = "FUNKCJA")
    private String funkcja;
    @JoinColumn(name = "ID_KLUB", referencedColumnName = "ID_KLUB")
    @ManyToOne
    private Klub idKlub;

    public Budynek() {
    }

    public Budynek(BigDecimal idBudynek) {
        this.idBudynek = idBudynek;
    }

    public BigDecimal getIdBudynek() {
        return idBudynek;
    }

    public void setIdBudynek(BigDecimal idBudynek) {
        this.idBudynek = idBudynek;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getUlicanumer() {
        return ulicanumer;
    }

    public void setUlicanumer(String ulicanumer) {
        this.ulicanumer = ulicanumer;
    }

    public String getFunkcja() {
        return funkcja;
    }

    public void setFunkcja(String funkcja) {
        this.funkcja = funkcja;
    }

    public Klub getIdKlub() {
        return idKlub;
    }

    public void setIdKlub(Klub idKlub) {
        this.idKlub = idKlub;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBudynek != null ? idBudynek.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Budynek)) {
            return false;
        }
        Budynek other = (Budynek) object;
        if ((this.idBudynek == null && other.idBudynek != null) || (this.idBudynek != null && !this.idBudynek.equals(other.idBudynek))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.jpa.model.Budynek[ idBudynek=" + idBudynek + " ]";
    }
    
}
