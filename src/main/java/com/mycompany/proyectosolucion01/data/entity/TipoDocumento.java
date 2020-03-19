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
@Table(name = "TIPO_DOCUMENTO")
@NamedQueries({
    @NamedQuery(name = "TipoDocumento.findAll", query = "SELECT t FROM TipoDocumento t"),
    @NamedQuery(name = "TipoDocumento.findByIdTIPODOCUMENTO", query = "SELECT t FROM TipoDocumento t WHERE t.idTIPODOCUMENTO = :idTIPODOCUMENTO"),
    @NamedQuery(name = "TipoDocumento.findByNombre", query = "SELECT t FROM TipoDocumento t WHERE t.nombre = :nombre")})
public class TipoDocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idTIPO_DOCUMENTO")
    private Integer idTIPODOCUMENTO;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDocumento")
    private Collection<Documento> documentoCollection;

    public TipoDocumento() {
    }

    public TipoDocumento(Integer idTIPODOCUMENTO) {
        this.idTIPODOCUMENTO = idTIPODOCUMENTO;
    }

    public Integer getIdTIPODOCUMENTO() {
        return idTIPODOCUMENTO;
    }

    public void setIdTIPODOCUMENTO(Integer idTIPODOCUMENTO) {
        this.idTIPODOCUMENTO = idTIPODOCUMENTO;
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
        hash += (idTIPODOCUMENTO != null ? idTIPODOCUMENTO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDocumento)) {
            return false;
        }
        TipoDocumento other = (TipoDocumento) object;
        if ((this.idTIPODOCUMENTO == null && other.idTIPODOCUMENTO != null) || (this.idTIPODOCUMENTO != null && !this.idTIPODOCUMENTO.equals(other.idTIPODOCUMENTO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyectosolucion01.data.entity.TipoDocumento[ idTIPODOCUMENTO=" + idTIPODOCUMENTO + " ]";
    }
    
}
