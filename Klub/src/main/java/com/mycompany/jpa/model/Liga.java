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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
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
@Table(name = "LIGA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Liga.findAll", query = "SELECT l FROM Liga l"),
    @NamedQuery(name = "Liga.findByName", query = "SELECT l FROM Liga l WHERE l.nazwa = :nazwa")})
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(name = "usunLiga", procedureName = "PAKIET_LIGA.usun",
            parameters = {
                @StoredProcedureParameter(mode = ParameterMode.INOUT, type = Integer.class, name = "p_idliga")}
    ),
    @NamedStoredProcedureQuery(name = "dodajLiga", procedureName = "PAKIET_LIGA.dodaj",
            parameters = {
                @StoredProcedureParameter(mode = ParameterMode.INOUT, type = String.class, name = "p_nazwa"),
                @StoredProcedureParameter(mode = ParameterMode.INOUT, type = String.class, name = "p_kraj")}
    ),
    @NamedStoredProcedureQuery(name = "edytujLiga", procedureName = "PAKIET_LIGA.modyfikuj",
            parameters = {
                @StoredProcedureParameter(mode = ParameterMode.INOUT, type = Integer.class, name = "p_idliga"),
                @StoredProcedureParameter(mode = ParameterMode.INOUT, type = String.class, name = "p_nazwa"),
                @StoredProcedureParameter(mode = ParameterMode.INOUT, type = String.class, name = "p_kraj")}
    )
})
public class Liga implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_LIGA")
    private BigDecimal idLiga;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NAZWA")
    private String nazwa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "KRAJ")
    private String kraj;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLiga")
    private List<Druzyna> druzynaList;

    public Liga() {
    }

    public Liga(BigDecimal idLiga) {
        this.idLiga = idLiga;
    }

    public Liga(BigDecimal idLiga, String nazwa, String kraj) {
        this.idLiga = idLiga;
        this.nazwa = nazwa;
        this.kraj = kraj;
    }

    public Integer getIdLiga() {
        return Integer.valueOf(idLiga.toString());
    }

    public void setIdLiga(BigDecimal idLiga) {
        this.idLiga = idLiga;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getKraj() {
        return kraj;
    }

    public void setKraj(String kraj) {
        this.kraj = kraj;
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
        hash += (idLiga != null ? idLiga.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Liga)) {
            return false;
        }
        Liga other = (Liga) object;
        if ((this.idLiga == null && other.idLiga != null) || (this.idLiga != null && !this.idLiga.equals(other.idLiga))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.jpa.model.Liga[ idLiga=" + idLiga + " ]";
    }

}
