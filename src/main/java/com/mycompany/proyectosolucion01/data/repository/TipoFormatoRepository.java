/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectosolucion01.data.repository;

import com.mycompany.proyectosolucion01.data.entity.TipoDisco;
import com.mycompany.proyectosolucion01.data.entity.TipoFormato;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fercholeiva
 */
public class TipoFormatoRepository extends DataBaseHandler{
    public boolean save(String nombre) {
        try {
            Connection conn = this.getConnection();
            Statement stmt = conn.createStatement();
            boolean result = stmt.execute("INSERT INTO `TiPO_FORMATO`(`Nombre`) VALUES ('" + nombre + "');");

            conn.close();
            return result;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
     public List<TipoFormato> findAll() {
        List<TipoFormato> tipoFormatolist = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from TIPO_FORMATO");
            while (rs.next()) {
                TipoFormato tipoFormato = new TipoFormato();
                tipoFormato.setIdTIPOFORMATO(rs.getInt(1));
                tipoFormato.setNombre(rs.getString(2));
                tipoFormatolist.add(tipoFormato);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return tipoFormatolist;
    }
    
    
    
}
