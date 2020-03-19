/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectosolucion01.data.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author fercholeiva
 */
public class DocumentoRepository extends DataBaseHandler{
       
    public int save(int Disco, int Directorio,int tipoDocumento,int programa, int asignatura , String nombre, String creacion,String modificaion,String comentario, String bytes) {
        try {
            Connection conn = this.getConnection();
            Statement stmt = conn.createStatement();

            String insert = ""
                    + "INSERT INTO `solucion_ejercicio_1`.`DOCUMENTO` (`DISCO_idDISCO`,"
                    +"`DIRECTORIO_idDIRECTORIO`,`TIPO_DOCUMENTO_idTIPO_DOCUMENTO`,`PROGRAMA_idPROGRAMA`,"
                    +"`ASIGNATURA_idASIGNATURA`,`Nombre`,`Fecha_creacion`,`Fecha_modificacion`, `Comentario`,`Tamaño_bytes`) "
                    + "VALUES ( '" + Disco + "','" + Directorio + "','" + tipoDocumento + "', '" + programa + "','"+asignatura+"','"+nombre+"','"+creacion+"','"+modificaion+"','"+comentario+"','"+ bytes+"');";
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

    
}
