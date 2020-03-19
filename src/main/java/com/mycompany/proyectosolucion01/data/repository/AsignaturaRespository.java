/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectosolucion01.data.repository;

import com.mycompany.proyectosolucion01.data.entity.Asignatura;
import com.mycompany.proyectosolucion01.data.entity.TipoDocumento;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fercholeiva
 */
public class AsignaturaRespository extends DataBaseHandler{
    
     public boolean save(String nombre,String clave,String curso,String titulacion) {
        try {
            Connection conn = this.getConnection();
            Statement stmt = conn.createStatement();
            boolean result = stmt.execute("INSERT INTO `ASIGNATURA`(`Nombre`,`Clave`,`Curso`,`Titulacion`) VALUES ('" + nombre + "','"+clave+"','"+curso+"','"+titulacion+"');");

            conn.close();
            return result;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
      public List<Asignatura> findAll() {
        List<Asignatura> asignaturas = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from ASIGNATURA");
            while (rs.next()) {
                
                Asignatura asignatura = new Asignatura();
                asignatura.setIdASIGNATURA(rs.getInt(1));
                asignatura.setNombre(rs.getString(2));
                asignatura.setClave(rs.getString(3));
                asignatura.setCurso(rs.getString(4));
                asignatura.setTitulacion(rs.getString(5));
                          
                asignaturas.add(asignatura);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return asignaturas;
    }
     public int getIdByNameAsignatura(List<Asignatura> asignaturaList, String nombre) {
        int id = -1;

        for (Asignatura asignatura : asignaturaList) {
            
            if (asignatura.getNombre().equals(nombre)) {
                id = asignatura.getIdASIGNATURA();
            }
            
        }
        return id;
    }
    
    
    
}
