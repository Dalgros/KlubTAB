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
@Table(name = "DRUZYNA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Druzyna.findByIdSekcja", query = "SELECT d FROM Druzyna d WHERE d.idSekcja = :idSekcja"),
    @NamedQuery(name = "Druzyna.findByIdLiga", query = "SELECT d FROM Druzyna d WHERE d.idLiga = :idLiga")})
public class Druzyna implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DRUZYNA")
    private BigDecimal idDruzyna;
    @Size(max = 20)
    @Column(name = "NAZWA")
    private String nazwa;
    @JoinColumn(name = "ID_LIGA", referencedColumnName = "ID_LIGA")
    @ManyToOne(optional = false)
    private Liga idLiga;
    @JoinColumn(name = "ID_SEKCJA", referencedColumnName = "ID_SEKCJA")
    @ManyToOne(optional = false)
    private Sekcja idSekcja;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "druzyna")
    private List<Kontrakt> kontraktList;

    public Druzyna() {
    }

    public Druzyna(BigDecimal idDruzyna) {
        this.idDruzyna = idDruzyna;
    }

    public BigDecimal getIdDruzyna() {
        return idDruzyna;
    }

    public void setIdDruzyna(BigDecimal idDruzyna) {
        this.idDruzyna = idDruzyna;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Liga getIdLiga() {
        return idLiga;
    }

    public void setIdLiga(Liga idLiga) {
        this.idLiga = idLiga;
    }

    public Sekcja getIdSekcja() {
        return idSekcja;
    }

    public void setIdSekcja(Sekcja idSekcja) {
        this.idSekcja = idSekcja;
    }

    @XmlTransient
    public List<Kontrakt> getKontraktList() {
        return kontraktList;
    }

    public void setKontraktList(List<Kontrakt> kontraktList) {
        this.kontraktList = kontraktList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDruzyna != null ? idDruzyna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Druzyna)) {
            return false;
        }
        Druzyna other = (Druzyna) object;
        if ((this.idDruzyna == null && other.idDruzyna != null) || (this.idDruzyna != null && !this.idDruzyna.equals(other.idDruzyna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.jpa.model.Druzyna[ idDruzyna=" + idDruzyna + " ]";
    }

}
