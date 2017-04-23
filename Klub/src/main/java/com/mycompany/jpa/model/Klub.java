/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jpa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
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
@Table(name = "KLUB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Klub.findAll", query = "SELECT k FROM Klub k")})
@NamedStoredProcedureQuery(
	name = "usunklub", 
	procedureName = "usunklub", 
	parameters = { 
		@StoredProcedureParameter(mode = ParameterMode.INOUT, type = Integer.class, name = "pid")
	}
)
public class Klub implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_KLUB")
    private BigDecimal idKlub;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NAZWA")
    private String nazwa;
    @Lob
    @Column(name = "LOGO")
    private byte[] logo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idKlub")
    private List<Sekcja> sekcjaList;
    @OneToMany(mappedBy = "idKlub")
    private List<Budynek> budynekList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idKlub")
    private List<Czlonek_Zarzadu> czlonekZarzaduList;

    public Klub() {
    }

    public Klub(BigDecimal idKlub) {
        this.idKlub = idKlub;
    }

    public Klub(BigDecimal idKlub, String nazwa) {
        this.idKlub = idKlub;
        this.nazwa = nazwa;
    }

    public BigDecimal getIdKlub() {
        return idKlub;
    }

    public void setIdKlub(BigDecimal idKlub) {
        this.idKlub = idKlub;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public byte[] getLogo() throws SQLException {
        //Blob blob = new javax.sql.rowset.serial.SerialBlob(logo);
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    @XmlTransient
    public List<Sekcja> getSekcjaList() {
        return sekcjaList;
    }

    public void setSekcjaList(List<Sekcja> sekcjaList) {
        this.sekcjaList = sekcjaList;
    }

    @XmlTransient
    public List<Budynek> getBudynekList() {
        return budynekList;
    }

    public void setBudynekList(List<Budynek> budynekList) {
        this.budynekList = budynekList;
    }

    @XmlTransient
    public List<Czlonek_Zarzadu> getCzlonekZarzaduList() {
        return czlonekZarzaduList;
    }

    public void setCzlonekZarzaduList(List<Czlonek_Zarzadu> czlonekZarzaduList) {
        this.czlonekZarzaduList = czlonekZarzaduList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKlub != null ? idKlub.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Klub)) {
            return false;
        }
        Klub other = (Klub) object;
        if ((this.idKlub == null && other.idKlub != null) || (this.idKlub != null && !this.idKlub.equals(other.idKlub))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.jpa.model.Klub[ idKlub=" + idKlub + " ]";
    }
    
}
