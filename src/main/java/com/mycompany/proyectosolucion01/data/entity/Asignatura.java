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
@Table(name = "ASIGNATURA")
@NamedQueries({
    @NamedQuery(name = "Asignatura.findAll", query = "SELECT a FROM Asignatura a"),
    @NamedQuery(name = "Asignatura.findByIdASIGNATURA", query = "SELECT a FROM Asignatura a WHERE a.idASIGNATURA = :idASIGNATURA"),
    @NamedQuery(name = "Asignatura.findByNombre", query = "SELECT a FROM Asignatura a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Asignatura.findByClave", query = "SELECT a FROM Asignatura a WHERE a.clave = :clave"),
    @NamedQuery(name = "Asignatura.findByCurso", query = "SELECT a FROM Asignatura a WHERE a.curso = :curso"),
    @NamedQuery(name = "Asignatura.findByTitulacion", query = "SELECT a FROM Asignatura a WHERE a.titulacion = :titulacion")})
public class Asignatura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idASIGNATURA")
    private Integer idASIGNATURA;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Clave")
    private String clave;
    @Column(name = "Curso")
    private String curso;
    @Column(name = "Titulacion")
    private String titulacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignatura")
    private Collection<Documento> documentoCollection;

    public Asignatura() {
    }

    public Asignatura(Integer idASIGNATURA) {
        this.idASIGNATURA = idASIGNATURA;
    }

    public Integer getIdASIGNATURA() {
        return idASIGNATURA;
    }

    public void setIdASIGNATURA(Integer idASIGNATURA) {
        this.idASIGNATURA = idASIGNATURA;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
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
        hash += (idASIGNATURA != null ? idASIGNATURA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignatura)) {
            return false;
        }
        Asignatura other = (Asignatura) object;
        if ((this.idASIGNATURA == null && other.idASIGNATURA != null) || (this.idASIGNATURA != null && !this.idASIGNATURA.equals(other.idASIGNATURA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyectosolucion01.data.entity.Asignatura[ idASIGNATURA=" + idASIGNATURA + " ]";
    }
    
}
