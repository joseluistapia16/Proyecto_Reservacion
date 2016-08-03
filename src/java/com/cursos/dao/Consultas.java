package com.cursos.dao;

import demo.data.pojo.Alumnos;
import demo.data.pojo.Ciencia;
import demo.data.pojo.Curso;
import demo.data.pojo.CursoEstudiante;
import demo.data.pojo.Materia;
import demo.data.pojo.Profesor;
import demo.data.pojo.Usuario;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JOSE LUIS
 */
public class Consultas {

    Conectar con = new Conectar();
    Connection conect = null;
    ResultSet rs;
    java.sql.Statement st = null;
    String query;

    public ArrayList<Ciencia> ConsultaCiencia(String base, String query) {
        ArrayList<Ciencia> lista = new ArrayList<Ciencia>();

        try {
            conect = con.Conexion(base);
            st = conect.createStatement();
            rs = st.executeQuery(query);

            //   rs = st.executeQuery(query);
            while (rs.next()) {
                Ciencia objeto = new Ciencia(rs.getInt("id_ciencia"),
                        rs.getString("nombre_ciencia"), rs.getString("fechas"));
                lista.add(objeto);
            }
            conect.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public ArrayList<Usuario> ConsultaUsuario(String base, String query) {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();

        try {
            conect = con.Conexion(base);
            st = conect.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {
                Usuario objeto = new Usuario(rs.getInt("id_usuario"),
                        rs.getString("nombre_rol"), rs.getInt("id_rol"), rs.getString("cedula"), rs.getString("nombre_usuario"),
                        rs.getString("apellido"), rs.getString("telefono"), rs.getString("direccion"), rs.getString("correo"),
                        rs.getString("fechas"), rs.getString("usuario"), rs.getString("clave"));
                lista.add(objeto);
            }
            conect.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public ArrayList<Profesor> ConsultaProfesor(String base, String query) {
        ArrayList<Profesor> lista = new ArrayList<Profesor>();

        try {
            conect = con.Conexion(base);
            st = conect.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {
                Profesor objeto = new Profesor(rs.getInt("id_profesor"),
                        rs.getString("cedula"), rs.getString("nombre_profesor"),
                        rs.getString("apellido"), rs.getString("telefono"), rs.getString("direccion"), rs.getString("correo"),
                        rs.getString("fechas"), rs.getString("nombre_usuario"), rs.getString("nombre_rol"), rs.getInt("id_rol"));
                lista.add(objeto);
            }
            conect.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public ArrayList<Alumnos> ConsultaEstudiante(String base, String query) {
        ArrayList<Alumnos> lista = new ArrayList<Alumnos>();

        try {
            conect = con.Conexion(base);
            st = conect.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {
                Alumnos objeto = new Alumnos(rs.getInt("id_alumno"),
                        rs.getString("cedula"), rs.getString("nombre"),
                        rs.getString("apellido"), rs.getString("telefono"), rs.getString("direccion"), rs.getString("correo"),
                        rs.getString("fechas"), rs.getString("nombre_rol"), rs.getInt("id_rol"), rs.getString("nombre_usuario"));
                lista.add(objeto);
            }
            conect.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public ArrayList<Curso> ConsultaCurso(String base, String query) {
        ArrayList<Curso> lista = new ArrayList<Curso>();

        try {
            conect = con.Conexion(base);
            st = conect.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {
                Curso objeto = new Curso(rs.getInt("id_curso"),
                        rs.getInt("id_ciencia"), rs.getString("nombre_curso"),
                        rs.getInt("id_materia"), rs.getInt("id_profesor"), rs.getDouble("valor"), rs.getString("fecha_inicio"),
                        rs.getString("fecha_fin"), rs.getString("horario"));
                lista.add(objeto);
            }
            conect.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public ArrayList<CursoEstudiante> ConsultaCursoEstudiante(String base, String query) {
        ArrayList<CursoEstudiante> lista = new ArrayList<CursoEstudiante>();

        try {
            conect = con.Conexion(base);
            st = conect.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {
                CursoEstudiante objeto = new CursoEstudiante(rs.getInt("id_cursoestudiante"),
                        rs.getInt("id_curso"), rs.getInt("id_alumno"), rs.getString("estado"), rs.getString("nombre_cursosestudiante"),
                        rs.getString("cedula_estudiante"), rs.getInt("id_profesor"));
                lista.add(objeto);
            }
            conect.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public ArrayList<Materia> ConsultaMateria(String base, String query) {
        ArrayList<Materia> lista = new ArrayList<Materia>();

        try {
            conect = con.Conexion(base);
            st = conect.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                Materia objeto = new Materia(rs.getInt("id_materia"),
                        rs.getInt("id_ciencia"), rs.getString("nombre_materia"), rs.getString("fechas"));
                lista.add(objeto);

            }
            conect.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public String NR(String Tabla, String query) {

        int nom = 0;
        int s = 0;
        try {
            conect = con.Conexion("cursos");
            st = conect.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {
                nom = rs.getInt(1);
                System.out.println(nom);
                if (nom <= 0) {

                    s = 0;
                } else {
                    s = 1;
                }
            }
        } catch (SQLException ex) {

            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (s == 1) {
            return String.valueOf(nom);
        } else {
            s = 0;
            return String.valueOf(s);
        }

    }
    
    
}
