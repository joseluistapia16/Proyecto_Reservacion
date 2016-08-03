/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reservacion.pojo;

import java.io.Serializable;
import java.math.BigInteger;

/**
 *
 * @author mayra
 */
public class Estudiante implements Serializable{

    private BigInteger id_estudiante;
    private String cedula;
    private String nombre;
    private String apellido;

    public Estudiante() {
    }

    public Estudiante(BigInteger id_estudiante, String cedula, String nombre, String apellido) {
        this.id_estudiante = id_estudiante;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public BigInteger getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(BigInteger id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    
}
