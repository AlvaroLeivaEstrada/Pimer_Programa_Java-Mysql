/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectosolucion01.data.repository;

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
public class TipoDiscoRepository extends DataBaseHandler {

    public boolean save(String nombre) {
        try {
            Connection conn = this.getConnection();
            Statement stmt = conn.createStatement();
            boolean result = stmt.execute("INSERT INTO `TIPO_DISCO`(`Nombre`) VALUES ('" + nombre + "');");

            conn.close();
            return result;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public List<TipoDisco> findAll() {
        List<TipoDisco> Tipodiscos = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from TIPO_DISCO");
            while (rs.next()) {
                TipoDisco tipoDisco = new TipoDisco();
                tipoDisco.setIdTIPODISCO(rs.getInt(1));
                tipoDisco.setNombre(rs.getString(2));
                Tipodiscos.add(tipoDisco);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return Tipodiscos;
    }

}
