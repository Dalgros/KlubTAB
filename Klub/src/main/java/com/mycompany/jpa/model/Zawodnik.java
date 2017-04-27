/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jpa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Karol
 */
@Entity
@Table(name = "ZAWODNIK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zawodnik.findByIdDruzyna", query = "SELECT z FROM Zawodnik z, Kontrakt k WHERE k.kontraktPK.idDruzyna = :idDruzyna AND k.kontraktPK.idZawodnik = z.idZawodnik"),
    @NamedQuery(name = "Zawodnik.findAll", query = "SELECT z FROM Zawodnik z")})

@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(name = "usunZawodnik", procedureName = "PAKIET_ZAWODNIK.usun",
            parameters = {
                @StoredProcedureParameter(mode = ParameterMode.INOUT, type = Integer.class, name = "p_idzawodnik")}
    ),
    @NamedStoredProcedureQuery(name = "dodajZawodnik", procedureName = "PAKIET_ZAWODNIK.dodaj",
            parameters = {
                @StoredProcedureParameter(mode = ParameterMode.INOUT, type = String.class, name = "p_imie"),
                @StoredProcedureParameter(mode = ParameterMode.INOUT, type = String.class, name = "p_nazwisko"),
                @StoredProcedureParameter(mode = ParameterMode.INOUT, type = Date.class, name = "p_data"),
                @StoredProcedureParameter(mode = ParameterMode.INOUT, type = Integer.class, name = "p_wzrost"),
                @StoredProcedureParameter(mode = ParameterMode.INOUT, type = Integer.class, name = "p_waga")}
    ),
    @NamedStoredProcedureQuery(name = "edytujZawodnik", procedureName = "PAKIET_ZAWODNIK.modyfikuj",
            parameters = {
                @StoredProcedureParameter(mode = ParameterMode.INOUT, type = Integer.class, name = "p_idzawodnik"),
                @StoredProcedureParameter(mode = ParameterMode.INOUT, type = String.class, name = "p_imie"),
                @StoredProcedureParameter(mode = ParameterMode.INOUT, type = String.class, name = "p_nazwisko"),
                @StoredProcedureParameter(mode = ParameterMode.INOUT, type = Date.class, name = "p_data"),
                @StoredProcedureParameter(mode = ParameterMode.INOUT, type = Integer.class, name = "p_wzrost"),
                @StoredProcedureParameter(mode = ParameterMode.INOUT, type = Integer.class, name = "p_waga")}
    )
})
public class Zawodnik implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ZAWODNIK")
    private BigDecimal idZawodnik;
    @Size(max = 20)
    @Column(name = "IMIE")
    private String imie;
    @Size(max = 50)
    @Column(name = "NAZWISKO")
    private String nazwisko;
    @Column(name = "DATA_URODZENIA")
    @Temporal(TemporalType.DATE)
    private Date dataUrodzenia;
    @Column(name = "WZROST")
    private Short wzrost;
    @Column(name = "WAGA")
    private Short waga;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zawodnik")
    private List<Zawodnik_Statystyki> zawodnikStatystykiList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zawodnik")
    private List<Kontrakt> kontraktList;

    public Zawodnik() {
    }

    public Zawodnik(BigDecimal idZawodnik) {
        this.idZawodnik = idZawodnik;
    }

    public BigDecimal getIdZawodnik() {
        return idZawodnik;
    }

    public void setIdZawodnik(BigDecimal idZawodnik) {
        this.idZawodnik = idZawodnik;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Date getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(Date dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public Short getWzrost() {
        return wzrost;
    }

    public void setWzrost(Short wzrost) {
        this.wzrost = wzrost;
    }

    public Short getWaga() {
        return waga;
    }

    public void setWaga(Short waga) {
        this.waga = waga;
    }

    @XmlTransient
    public List<Zawodnik_Statystyki> getZawodnikStatystykiList() {
        return zawodnikStatystykiList;
    }

    public void setZawodnikStatystykiList(List<Zawodnik_Statystyki> zawodnikStatystykiList) {
        this.zawodnikStatystykiList = zawodnikStatystykiList;
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
        hash += (idZawodnik != null ? idZawodnik.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zawodnik)) {
            return false;
        }
        Zawodnik other = (Zawodnik) object;
        if ((this.idZawodnik == null && other.idZawodnik != null) || (this.idZawodnik != null && !this.idZawodnik.equals(other.idZawodnik))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.jpa.model.Zawodnik[ idZawodnik=" + idZawodnik + " ]";
    }

}
