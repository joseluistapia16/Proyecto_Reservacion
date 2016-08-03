package com.cursos.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JOSE LUIS
 */
public class Base {

 

    public static void Editar2(String Base, String cadena, String cadena1, String tabla, String clav, String clave) {
        // OPERACIONES DE DESCOMPOSICION DE LA CADENA Y AMMADO DE LA SENTENCIA SQL   
        ArrayList<String> lista = new ArrayList<String>();
        ArrayList<String> lista1 = new ArrayList<String>();
        String consu = "", consu1 = "";
        lista = Recoger(cadena);     // ENVIA LAS CADENA DE CAMPOS PARA SELECCIONAR PREVIAMENTE PARA LA CONSULTA 
        lista1 = null;
        lista1 = Recoger(cadena1);    // ENVIA LAS CADENA DE VALORES PARA SELECCIONAR PREVIAMENTE PARA LA CONSULTA 
        //   if (lista.size() > 1) {
        consu = "UPDATE " + tabla + " set " + lista.get(0) + "='" + lista1.get(0);
        consu1 = consu + "'";
        for (int i = 1; i < lista.size(); i++) {
            consu1 = consu1 + "," + lista.get(i) + "='" + lista1.get(i) + "'";
        }
        consu = consu1 + " where " + clav + "='" + clave + "';";
        lista.clear();
        lista1.clear();  // VACIAR LAS LISTAS, PARA   AHORRO DE MEMORIA
///   CONEXION Y OPERACION DE ACTUALIZACIÒN
        Conectar con = new Conectar();
        Connection conect = null;
        ResultSet rs = null;
        try {
            String query = consu;
            conect = con.Conexion(Base);
            java.sql.Statement st = conect.createStatement();
            st.executeUpdate(query);

        } catch (SQLException ex) {
           
        }

    }

    //**********************************************************
    public static void Editar(String Base, String cadena, String cadena1, String tabla, String clav, String clave) {
        // OPERACIONES DE DESCOMPOSICION DE LA CADENA Y AMMADO DE LA SENTENCIA SQL   
        ArrayList<String> lista = new ArrayList<String>();
        ArrayList<String> lista1 = new ArrayList<String>();
        String consu = "", consu1 = "";
        lista = Recoger(cadena);     // ENVIA LAS CADENA DE CAMPOS PARA SELECCIONAR PREVIAMENTE PARA LA CONSULTA 
        lista1 = null;
        lista1 = Recoger(cadena1);    // ENVIA LAS CADENA DE VALORES PARA SELECCIONAR PREVIAMENTE PARA LA CONSULTA 
        if (lista.size() > 1) {
            consu = "UPDATE " + tabla + " set " + lista.get(0) + "='" + lista1.get(0);
            consu1 = consu + "'";
            for (int i = 1; i < lista.size(); i++) {
                consu1 = consu1 + "," + lista.get(i) + "='" + lista1.get(i) + "'";
            }
            consu = consu1 + " where " + clav + "='" + clave + "';";
        } else {
            consu = "UPDATE " + tabla + " set " + lista.get(0) + "='" + lista1.get(0);
            consu = consu1 + " where " + clav + "='" + clave + "';";
        }
        lista.clear();
        lista1.clear();  // VACIAR LAS LISTAS, PARA   AHORRO DE MEMORIA
///   CONEXION Y OPERACION DE ACTUALIZACIÒN
        Conectar con = new Conectar();
        Connection conect = null;
        ResultSet rs = null;
        try {
            String query = consu;
            //    System.out.println("consu   "+query);
            conect = con.Conexion(Base);
            java.sql.Statement st = conect.createStatement();
            st.executeUpdate(query);

        } catch (SQLException ex) {
            Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void EditarNM(String Base, String cadena, String cadena1, String tabla, String clav, int clave) {
        // OPERACIONES DE DESCOMPOSICION DE LA CADENA Y AMMADO DE LA SENTENCIA SQL   
        ArrayList<String> lista = new ArrayList<String>();
        ArrayList<String> lista1 = new ArrayList<String>();
        String consu = "", consu1 = "";
        lista = Recoger(cadena);     // ENVIA LAS CADENA DE CAMPOS PARA SELECCIONAR PREVIAMENTE PARA LA CONSULTA 
        lista1 = null;
        lista1 = Recoger(cadena1);    // ENVIA LAS CADENA DE VALORES PARA SELECCIONAR PREVIAMENTE PARA LA CONSULTA 
        if (lista.size() > 1) {
            consu = "UPDATE " + tabla + " set " + lista.get(0) + "='" + lista1.get(0);
            consu1 = consu + "'";
            for (int i = 1; i < lista.size(); i++) {
                consu1 = consu1 + "," + lista.get(i) + "='" + lista1.get(i) + "'";
            }
            consu = consu1 + " where " + clav + "=" + clave + ";";
            System.out.println(consu + "  hey ");
        } else {
            consu = "UPDATE " + tabla + " set " + lista.get(0) + "='" + lista1.get(0);
            consu = consu1 + " where " + clav + "=" + clave + ";";
            System.out.println(consu + "  hey ");
        }
        lista.clear();
        lista1.clear();  // VACIAR LAS LISTAS, PARA   AHORRO DE MEMORIA
///   CONEXION Y OPERACION DE ACTUALIZACIÒN
        Conectar con = new Conectar();
        Connection conect = null;

        try {
            String query = consu;
            conect = con.Conexion(Base);
            java.sql.Statement st = conect.createStatement();
            st.executeUpdate(query);

        } catch (SQLException ex) {          
        }

    }

    public static ArrayList<String> Recoger(String cadena) {          //METODO QUE DESCOMPONE Y SELECCIONA LAS CADENAS VALIDAS
        int i = 0;
        String h;
        ArrayList<String> lista1 = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer(cadena, ",'", true);
        while (st.hasMoreTokens()) {
            h = st.nextToken();
            if (!",".equals(h) && !"'".equals(h)) {
                {
                    lista1.add(h);

                }
            }
        }
        return lista1;
    }

//**************************************************************************************************************************** 
//    METODO " TRAER " JAVA PARA RECUPERACION DE DATOS , DE UN CAMPO A N CAMPOS CON SUS RESPECTIVOS VALORES
//    CREADO POR: JOSE LUIS TAPIA  8/JUNIO/2014
    public ArrayList<String> Traer(String base, String tabla, String campos, String clave, String vclave) throws SQLException {
        ArrayList<String> lista = new ArrayList<String>();
        ArrayList<String> lista1 = new ArrayList<String>();
        lista = Recoger(campos);
        String B, A = "SELECT " + campos + " from " + tabla + " where " + clave + "='" + vclave + "';";
        System.out.println(A);
        int i = 0;
        String sq = A;
        Conectar cone = new Conectar();
        Connection cn = cone.Conexion(base);
        java.sql.Statement sti = cn.createStatement();

        for (i = 0; i < lista.size(); i++) {
            ResultSet ru = sti.executeQuery(sq);
            while (ru.next()) {
                lista1.add(i, ru.getString(lista.get(i)));
            }
        }
        lista.clear();
        return lista1;

    }

//***********************************************     
             
    public void Guardar(String base, String Tabla, String Campos, String val) throws Exception {
        Conectar con = new Conectar();
        Connection conect = null;
        try {
            String query = "insert into " + Tabla + "(" + Campos + ")values (" + val + ")";
            conect = con.Conexion(base);
            java.sql.Statement st = conect.createStatement();
            st.executeUpdate(query);

        } catch (SQLException ex) {
            Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);          
        }

    }

     
   
}
