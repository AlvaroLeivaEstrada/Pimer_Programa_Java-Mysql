/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectosolucion01.data.repository;

import com.mycompany.proyectosolucion01.data.entity.Disco;
import com.mycompany.proyectosolucion01.data.entity.TipoDisco;
import com.mycompany.proyectosolucion01.data.entity.TipoFormato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fercholeiva
 */
public class DiscoRepository extends DataBaseHandler {

    List<TipoDisco> tipoDiscoList = null;
    List<TipoFormato> tipoFormatoList = null;

    public int save(int tipoDisco, int tipoFormato, String comentario, String ubicacion) {
        try {
            Connection conn = this.getConnection();
            Statement stmt = conn.createStatement();

            String insert = ""
                    + "INSERT INTO `solucion_ejercicio_1`.`Disco` (`TIPO_DISCO_idTIPO_DISCO`,`TIPO_FORMATO_idTIPO_FORMATO`,`Comentario`, `Ubicacion`) "
                    + "VALUES ( '" + tipoDisco + "','" + tipoFormato + "','" + comentario + "', '" + ubicacion + "');";
            PreparedStatement ps = conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            int id = -1;
            if (rs.next()) {
                id = rs.getInt(1);
            }
            conn.close();
            return id;
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }

    }

    public int getIdByNameTipoDisco(List<TipoDisco> tipoDiscoList, String nombre) {
        int id = -1;

        for (TipoDisco tipoDisco : tipoDiscoList) {
            
            if (tipoDisco.getNombre().equals(nombre)) {
                id = tipoDisco.getIdTIPODISCO();
            }
            
        }
        return id;
    }
     public int getIdByNameTipoFormato(List<TipoFormato> tipoFormatoList, String nombre) {
        int id = -1;

        for (TipoFormato tipoFormato : tipoFormatoList) {
            if (tipoFormato.getNombre().equals(nombre)) {
                id = tipoFormato.getIdTIPOFORMATO();
            }
        }
        return id;
    }
     
     public List<Disco> findAll() {
        List<Disco> discos = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from DISCO");
            while (rs.next()) {
                
                Disco disco = new Disco();
                disco.setIdDISCO(rs.getInt(1));
                disco.setComentario(rs.getString(4));
                disco.setUbicacion(rs.getString(5));
                discos.add(disco);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return discos;
    }

}
