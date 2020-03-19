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
@Table(name = "DIRECTORIO")
@NamedQueries({
    @NamedQuery(name = "Directorio.findAll", query = "SELECT d FROM Directorio d"),
    @NamedQuery(name = "Directorio.findByIdDIRECTORIO", query = "SELECT d FROM Directorio d WHERE d.idDIRECTORIO = :idDIRECTORIO"),
    @NamedQuery(name = "Directorio.findByNombre", query = "SELECT d FROM Directorio d WHERE d.nombre = :nombre")})
public class Directorio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDIRECTORIO")
    private Integer idDIRECTORIO;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "directorio")
    private Collection<Documento> documentoCollection;

    public Directorio() {
    }

    public Directorio(Integer idDIRECTORIO) {
        this.idDIRECTORIO = idDIRECTORIO;
    }

    public Integer getIdDIRECTORIO() {
        return idDIRECTORIO;
    }

    public void setIdDIRECTORIO(Integer idDIRECTORIO) {
        this.idDIRECTORIO = idDIRECTORIO;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Documento> getDocumentoCollection() {
        return documentoCollection;
    }

    public void setDocumentoCollection(Collection<Documento> documentoCollection) {
        this.documentoCollection = documentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDIRECTORIO != null ? idDIRECTORIO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Directorio)) {
            return false;
        }
        Directorio other = (Directorio) object;
        if ((this.idDIRECTORIO == null && other.idDIRECTORIO != null) || (this.idDIRECTORIO != null && !this.idDIRECTORIO.equals(other.idDIRECTORIO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyectosolucion01.data.entity.Directorio[ idDIRECTORIO=" + idDIRECTORIO + " ]";
    }
    
}
