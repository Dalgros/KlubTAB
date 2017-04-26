/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jpa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Karol
 */
@Entity
@Table(name = "CZLONEK_ZARZADU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CzlonekZarzadu.findByIdKlub", query = "SELECT c FROM Czlonek_Zarzadu c WHERE c.idKlub = :idKlub")})
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(name = "usunCzlonekZarzadu", procedureName = "PAKIET_CZLONEK_ZARZADU.usun",
            parameters = {
                @StoredProcedureParameter(mode = ParameterMode.INOUT, type = Integer.class, name = "p_idczlonek")}
    ),
    @NamedStoredProcedureQuery(name = "dodajCzlonekZarzadu", procedureName = "PAKIET_CZLONEK_ZARZADU.dodaj",
            parameters = {
                @StoredProcedureParameter(mode = ParameterMode.INOUT, type = Integer.class, name = "p_idklub"),
                @StoredProcedureParameter(mode = ParameterMode.INOUT, type = String.class, name = "p_imie"),
                @StoredProcedureParameter(mode = ParameterMode.INOUT, type = String.class, name = "p_nazwisko"),
                @StoredProcedureParameter(mode = ParameterMode.INOUT, type = String.class, name = "p_stanowisko"),
                @StoredProcedureParameter(mode = ParameterMode.INOUT, type = Integer.class, name = "p_pensja")}
    ),
    @NamedStoredProcedureQuery(name = "edytujCzlonekZarzadu", procedureName = "PAKIET_CZLONEK_ZARZADU.modyfikuj",
            parameters = {
                @StoredProcedureParameter(mode = ParameterMode.INOUT, type = Integer.class, name = "p_idczlonek"),
                @StoredProcedureParameter(mode = ParameterMode.INOUT, type = Integer.class, name = "p_idklub"),
                @StoredProcedureParameter(mode = ParameterMode.INOUT, type = String.class, name = "p_imie"),
                @StoredProcedureParameter(mode = ParameterMode.INOUT, type = String.class, name = "p_nazwisko"),
                @StoredProcedureParameter(mode = ParameterMode.INOUT, type = String.class, name = "p_stanowisko"),
                @StoredProcedureParameter(mode = ParameterMode.INOUT, type = Integer.class, name = "p_pensja")}
    )
})
public class Czlonek_Zarzadu implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CZLONEK")
    private BigDecimal idCzlonek;
    @Size(max = 20)
    @Column(name = "IMIE")
    private String imie;
    @Size(max = 50)
    @Column(name = "NAZWISKO")
    private String nazwisko;
    @Size(max = 20)
    @Column(name = "STANOWISKO")
    private String stanowisko;
    @Column(name = "PENSJA")
    private BigInteger pensja;
    @JoinColumn(name = "ID_KLUB", referencedColumnName = "ID_KLUB")
    @ManyToOne(optional = false)
    private Klub idKlub;

    public Czlonek_Zarzadu() {
    }

    public Czlonek_Zarzadu(BigDecimal idCzlonek) {
        this.idCzlonek = idCzlonek;
    }

    public BigDecimal getIdCzlonek() {
        return idCzlonek;
    }

    public void setIdCzlonek(BigDecimal idCzlonek) {
        this.idCzlonek = idCzlonek;
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

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public BigInteger getPensja() {
        return pensja;
    }

    public void setPensja(BigInteger pensja) {
        this.pensja = pensja;
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
        hash += (idCzlonek != null ? idCzlonek.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Czlonek_Zarzadu)) {
            return false;
        }
        Czlonek_Zarzadu other = (Czlonek_Zarzadu) object;
        if ((this.idCzlonek == null && other.idCzlonek != null) || (this.idCzlonek != null && !this.idCzlonek.equals(other.idCzlonek))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.jpa.model.CzlonekZarzadu[ idCzlonek=" + idCzlonek + " ]";
    }
    
}
