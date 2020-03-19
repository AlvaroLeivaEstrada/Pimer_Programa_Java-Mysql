/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectosolucion01.data.repository;

import com.mycompany.proyectosolucion01.data.entity.Directorio;
import com.mycompany.proyectosolucion01.data.entity.Disco;
import com.mycompany.proyectosolucion01.data.entity.TipoDisco;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fercholeiva
 */
public class DirectorioRepository extends DataBaseHandler{
    public boolean save(String nombre) {
        try {
            Connection conn = this.getConnection();
            Statement stmt = conn.createStatement();
            boolean result = stmt.execute("INSERT INTO `DIRECTORIO`(`nombre`) VALUES ('" + nombre + "');");

            conn.close();
            return result;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
     public List<Directorio> findAll() {
        List<Directorio> directorios = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from DIRECTORIO");
            while (rs.next()) {
                
                Directorio directorio = new Directorio();
                
                directorio.setIdDIRECTORIO(rs.getInt(1));
                directorio.setNombre(rs.getString(2));
             
                directorios.add(directorio);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return directorios;
    }
      public int getIdByNameDirectorio(List<Directorio> directorioList, String nombre) {
        int id = -1;

        for (Directorio directorio : directorioList) {
            
            if (directorio.getNombre().equals(nombre)) {
                id = directorio.getIdDIRECTORIO();
            }
            
        }
        return id;
    }
    
}
