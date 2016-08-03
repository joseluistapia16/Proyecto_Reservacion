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
public class Reservacion implements Serializable{
    private BigInteger id_reservacion;
    private String cedula;
    private String escenario;
    private String fecha;
    private int hora_inicio;
    private int hora_final;
    private int total_hora;
    private int dia;
    private int mes;
    private int ano;

    public Reservacion() {
    }

    public Reservacion(BigInteger id_reservacion, String cedula, String escenario, String fecha, int hora_inicio, int hora_final, int total_hora, int dia, int mes, int ano) {
        this.id_reservacion = id_reservacion;
        this.cedula = cedula;
        this.escenario = escenario;
        this.fecha = fecha;
        this.hora_inicio = hora_inicio;
        this.hora_final = hora_final;
        this.total_hora = total_hora;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public BigInteger getId_reservacion() {
        return id_reservacion;
    }

    public void setId_reservacion(BigInteger id_reservacion) {
        this.id_reservacion = id_reservacion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEscenario() {
        return escenario;
    }

    public void setEscenario(String escenario) {
        this.escenario = escenario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(int hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public int getHora_final() {
        return hora_final;
    }

    public void setHora_final(int hora_final) {
        this.hora_final = hora_final;
    }

    public int getTotal_hora() {
        return total_hora;
    }

    public void setTotal_hora(int total_hora) {
        this.total_hora = total_hora;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
    
    
}
