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
@Table(name = "TIPO_FORMATO")
@NamedQueries({
    @NamedQuery(name = "TipoFormato.findAll", query = "SELECT t FROM TipoFormato t"),
    @NamedQuery(name = "TipoFormato.findByIdTIPOFORMATO", query = "SELECT t FROM TipoFormato t WHERE t.idTIPOFORMATO = :idTIPOFORMATO"),
    @NamedQuery(name = "TipoFormato.findByNombre", query = "SELECT t FROM TipoFormato t WHERE t.nombre = :nombre")})
public class TipoFormato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTIPO_FORMATO")
    private Integer idTIPOFORMATO;
    @Column(name = "Nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoFormato")
    private Collection<Disco> discoCollection;

    public TipoFormato() {
    }

    public TipoFormato(Integer idTIPOFORMATO) {
        this.idTIPOFORMATO = idTIPOFORMATO;
    }

    public Integer getIdTIPOFORMATO() {
        return idTIPOFORMATO;
    }

    public void setIdTIPOFORMATO(Integer idTIPOFORMATO) {
        this.idTIPOFORMATO = idTIPOFORMATO;
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
        hash += (idTIPOFORMATO != null ? idTIPOFORMATO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoFormato)) {
            return false;
        }
        TipoFormato other = (TipoFormato) object;
        if ((this.idTIPOFORMATO == null && other.idTIPOFORMATO != null) || (this.idTIPOFORMATO != null && !this.idTIPOFORMATO.equals(other.idTIPOFORMATO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyectosolucion01.data.entity.TipoFormato[ idTIPOFORMATO=" + idTIPOFORMATO + " ]";
    }
    
}
