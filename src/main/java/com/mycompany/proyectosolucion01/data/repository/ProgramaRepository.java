/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectosolucion01.data.repository;

import com.mycompany.proyectosolucion01.data.entity.Disco;
import com.mycompany.proyectosolucion01.data.entity.Programa;
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
public class ProgramaRepository extends DataBaseHandler{
    public boolean save(String nombre,String nCorto,String version, String fabricante) {
        try {
            Connection conn = this.getConnection();
            Statement stmt = conn.createStatement();
            boolean result = stmt.execute("INSERT INTO `PROGRAMA`(`Nombre`,`Nombre_corto`,`Version`,`Fabricante`) VALUES ('" + nombre + "','" + nCorto + "','" + version + "','" + fabricante + "');");
            conn.close();
            return result;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    public List<Programa> findAll() {
        List<Programa> programas = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from PROGRAMA");
            while (rs.next()) {
                
                Programa programa = new Programa();
                programa.setIdPROGRAMA(rs.getInt(1));
                programa.setNombre(rs.getString(2));
                programa.setNombrecorto(rs.getString(3));
                programa.setVersion(rs.getString(4));
                programa.setFabricante(rs.getString(5));
               
                programas.add(programa);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return programas;
    }
     public int getIdByNamePrograma(List<Programa> programaList, String nombre) {
        int id = -1;

        for (Programa programa : programaList) {
            
            if (programa.getNombre().equals(nombre)) {
                id = programa.getIdPROGRAMA();
            }
            
        }
        return id;
    }
    
}
