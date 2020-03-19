/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectosolucion01.data.entity;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.Table;

/**
 *
 * @author fercholeiva
 */
@Entity
@Table(name = "DOCUMENTO")
@NamedQueries({
    @NamedQuery(name = "Documento.findAll", query = "SELECT d FROM Documento d"),
    @NamedQuery(name = "Documento.findByIdDOCUMENTO", query = "SELECT d FROM Documento d WHERE d.idDOCUMENTO = :idDOCUMENTO"),
    @NamedQuery(name = "Documento.findByNombre", query = "SELECT d FROM Documento d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Documento.findByFechacreacion", query = "SELECT d FROM Documento d WHERE d.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "Documento.findByFechamodificacion", query = "SELECT d FROM Documento d WHERE d.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Documento.findByComentario", query = "SELECT d FROM Documento d WHERE d.comentario = :comentario"),
    @NamedQuery(name = "Documento.findByTama\u00f1obytes", query = "SELECT d FROM Documento d WHERE d.tama\u00f1obytes = :tama\u00f1obytes")})
public class Documento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDOCUMENTO")
    private Integer idDOCUMENTO;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Fecha_creacion")
    private String fechacreacion;
    @Column(name = "Fecha_modificacion")
    private String fechamodificacion;
    @Column(name = "Comentario")
    private String comentario;
    @Column(name = "Tama\u00f1o_bytes")
    private String tamañobytes;
    @JoinColumns({
        @JoinColumn(name = "ASIGNATURA_idASIGNATURA", referencedColumnName = "idASIGNATURA"),
        @JoinColumn(name = "ASIGNATURA_idASIGNATURA", referencedColumnName = "idASIGNATURA")})
    @ManyToOne(optional = false)
    private Asignatura asignatura;
    @JoinColumns({
        @JoinColumn(name = "DIRECTORIO_idDIRECTORIO", referencedColumnName = "idDIRECTORIO"),
        @JoinColumn(name = "DIRECTORIO_idDIRECTORIO", referencedColumnName = "idDIRECTORIO")})
    @ManyToOne(optional = false)
    private Directorio directorio;
    @JoinColumns({
        @JoinColumn(name = "DISCO_idDISCO", referencedColumnName = "idDISCO"),
        @JoinColumn(name = "DISCO_idDISCO", referencedColumnName = "idDISCO")})
    @ManyToOne(optional = false)
    private Disco disco;
    @JoinColumns({
        @JoinColumn(name = "PROGRAMA_idPROGRAMA", referencedColumnName = "idPROGRAMA"),
        @JoinColumn(name = "PROGRAMA_idPROGRAMA", referencedColumnName = "idPROGRAMA")})
    @ManyToOne(optional = false)
    private Programa programa;
    @JoinColumns({
        @JoinColumn(name = "TIPO_DOCUMENTO_idTIPO_DOCUMENTO", referencedColumnName = "idTIPO_DOCUMENTO"),
        @JoinColumn(name = "TIPO_DOCUMENTO_idTIPO_DOCUMENTO", referencedColumnName = "idTIPO_DOCUMENTO")})
    @ManyToOne(optional = false)
    private TipoDocumento tipoDocumento;

    public Documento() {
    }

    public Documento(Integer idDOCUMENTO) {
        this.idDOCUMENTO = idDOCUMENTO;
    }

    public Integer getIdDOCUMENTO() {
        return idDOCUMENTO;
    }

    public void setIdDOCUMENTO(Integer idDOCUMENTO) {
        this.idDOCUMENTO = idDOCUMENTO;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public String getFechamodificacion() {
        return fechamodificacion;
    }

    public void setFechamodificacion(String fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getTamañobytes() {
        return tamañobytes;
    }

    public void setTamañobytes(String tamañobytes) {
        this.tamañobytes = tamañobytes;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Directorio getDirectorio() {
        return directorio;
    }

    public void setDirectorio(Directorio directorio) {
        this.directorio = directorio;
    }

    public Disco getDisco() {
        return disco;
    }

    public void setDisco(Disco disco) {
        this.disco = disco;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDOCUMENTO != null ? idDOCUMENTO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documento)) {
            return false;
        }
        Documento other = (Documento) object;
        if ((this.idDOCUMENTO == null && other.idDOCUMENTO != null) || (this.idDOCUMENTO != null && !this.idDOCUMENTO.equals(other.idDOCUMENTO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyectosolucion01.data.entity.Documento[ idDOCUMENTO=" + idDOCUMENTO + " ]";
    }
    
}
