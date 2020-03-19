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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author fercholeiva
 */
@Entity
@Table(name = "DISCO")
@NamedQueries({
    @NamedQuery(name = "Disco.findAll", query = "SELECT d FROM Disco d"),
    @NamedQuery(name = "Disco.findByIdDISCO", query = "SELECT d FROM Disco d WHERE d.idDISCO = :idDISCO"),
    @NamedQuery(name = "Disco.findByComentario", query = "SELECT d FROM Disco d WHERE d.comentario = :comentario"),
    @NamedQuery(name = "Disco.findByUbicacion", query = "SELECT d FROM Disco d WHERE d.ubicacion = :ubicacion")})
public class Disco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDISCO")
    private Integer idDISCO;
    @Column(name = "Comentario")
    private String comentario;
    @Column(name = "Ubicacion")
    private String ubicacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disco")
    private Collection<Documento> documentoCollection;
    @JoinColumns({
        @JoinColumn(name = "TIPO_DISCO_idTIPO_DISCO", referencedColumnName = "idTIPO_DISCO"),
        @JoinColumn(name = "TIPO_DISCO_idTIPO_DISCO", referencedColumnName = "idTIPO_DISCO")})
    @ManyToOne(optional = false)
    private TipoDisco tipoDisco;
    @JoinColumns({
        @JoinColumn(name = "TIPO_FORMATO_idTIPO_FORMATO", referencedColumnName = "idTIPO_FORMATO"),
        @JoinColumn(name = "TIPO_FORMATO_idTIPO_FORMATO", referencedColumnName = "idTIPO_FORMATO")})
    @ManyToOne(optional = false)
    private TipoFormato tipoFormato;

    public Disco() {
    }

    public Disco(Integer idDISCO) {
        this.idDISCO = idDISCO;
    }

    public Integer getIdDISCO() {
        return idDISCO;
    }

    public void setIdDISCO(Integer idDISCO) {
        this.idDISCO = idDISCO;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Collection<Documento> getDocumentoCollection() {
        return documentoCollection;
    }

    public void setDocumentoCollection(Collection<Documento> documentoCollection) {
        this.documentoCollection = documentoCollection;
    }

    public TipoDisco getTipoDisco() {
        return tipoDisco;
    }

    public void setTipoDisco(TipoDisco tipoDisco) {
        this.tipoDisco = tipoDisco;
    }

    public TipoFormato getTipoFormato() {
        return tipoFormato;
    }

    public void setTipoFormato(TipoFormato tipoFormato) {
        this.tipoFormato = tipoFormato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDISCO != null ? idDISCO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disco)) {
            return false;
        }
        Disco other = (Disco) object;
        if ((this.idDISCO == null && other.idDISCO != null) || (this.idDISCO != null && !this.idDISCO.equals(other.idDISCO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyectosolucion01.data.entity.Disco[ idDISCO=" + idDISCO + " ]";
    }
    
}
