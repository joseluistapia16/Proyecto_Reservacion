package com.cursos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import org.zkoss.zul.Messagebox;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JOSE LUIS
 */
public class Conectar {

    Connection Conect = null;

    public Connection Conexion(String base) {
          try {
            Class.forName("com.mysql.jdbc.Driver");
            String str = "jdbc:mysql://localhost:3306/" + base + "?zeroDateTimeBehavior=convertToNull";
            Conect = DriverManager.getConnection(str, "root", "1234");
        } catch (Exception ex) {
          //  Messagebox.show("No hay Conexión !!");
        }
        return Conect;
    }

    

}
