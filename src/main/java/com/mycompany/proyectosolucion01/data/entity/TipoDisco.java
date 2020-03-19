/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectosolucion01.data.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author fercholeiva
 */
@Entity
@Table(name = "TIPO_DISCO")
@NamedQueries({
    @NamedQuery(name = "TipoDisco.findAll", query = "SELECT t FROM TipoDisco t"),
    @NamedQuery(name = "TipoDisco.findByIdTIPODISCO", query = "SELECT t FROM TipoDisco t WHERE t.idTIPODISCO = :idTIPODISCO"),
    @NamedQuery(name = "TipoDisco.findByNombre", query = "SELECT t FROM TipoDisco t WHERE t.nombre = :nombre")})
public class TipoDisco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTIPO_DISCO")
    private Integer idTIPODISCO;
    @Column(name = "Nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDisco")
    private Collection<Disco> discoCollection;

    public TipoDisco() {
    }

    public TipoDisco(Integer idTIPODISCO) {
        this.idTIPODISCO = idTIPODISCO;
    }

    public Integer getIdTIPODISCO() {
        return idTIPODISCO;
    }

    public void setIdTIPODISCO(Integer idTIPODISCO) {
        this.idTIPODISCO = idTIPODISCO;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Disco> getDiscoCollection() {
        return discoCollection;
    }

    public void setDiscoCollection(Collection<Disco> discoCollection) {
        this.discoCollection = discoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTIPODISCO != null ? idTIPODISCO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDisco)) {
            return false;
        }
        TipoDisco other = (TipoDisco) object;
        if ((this.idTIPODISCO == null && other.idTIPODISCO != null) || (this.idTIPODISCO != null && !this.idTIPODISCO.equals(other.idTIPODISCO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyectosolucion01.data.entity.TipoDisco[ idTIPODISCO=" + idTIPODISCO + " ]";
    }
    
}
