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
@Table(name = "PROGRAMA")
@NamedQueries({
    @NamedQuery(name = "Programa.findAll", query = "SELECT p FROM Programa p"),
    @NamedQuery(name = "Programa.findByIdPROGRAMA", query = "SELECT p FROM Programa p WHERE p.idPROGRAMA = :idPROGRAMA"),
    @NamedQuery(name = "Programa.findByNombre", query = "SELECT p FROM Programa p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Programa.findByNombrecorto", query = "SELECT p FROM Programa p WHERE p.nombrecorto = :nombrecorto"),
    @NamedQuery(name = "Programa.findByVersion", query = "SELECT p FROM Programa p WHERE p.version = :version"),
    @NamedQuery(name = "Programa.findByFabricante", query = "SELECT p FROM Programa p WHERE p.fabricante = :fabricante")})
public class Programa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPROGRAMA")
    private Integer idPROGRAMA;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Nombre_corto")
    private String nombrecorto;
    @Column(name = "Version")
    private String version;
    @Column(name = "Fabricante")
    private String fabricante;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programa")
    private Collection<Documento> documentoCollection;

    public Programa() {
    }

    public Programa(Integer idPROGRAMA) {
        this.idPROGRAMA = idPROGRAMA;
    }

    public Integer getIdPROGRAMA() {
        return idPROGRAMA;
    }

    public void setIdPROGRAMA(Integer idPROGRAMA) {
        this.idPROGRAMA = idPROGRAMA;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombrecorto() {
        return nombrecorto;
    }

    public void setNombrecorto(String nombrecorto) {
        this.nombrecorto = nombrecorto;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
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
        hash += (idPROGRAMA != null ? idPROGRAMA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programa)) {
            return false;
        }
        Programa other = (Programa) object;
        if ((this.idPROGRAMA == null && other.idPROGRAMA != null) || (this.idPROGRAMA != null && !this.idPROGRAMA.equals(other.idPROGRAMA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyectosolucion01.data.entity.Programa[ idPROGRAMA=" + idPROGRAMA + " ]";
    }
    
}
