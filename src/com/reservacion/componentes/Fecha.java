package com.reservacion.componentes;

import java.sql.Date;
import java.util.Calendar;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JOSE LUIS
 */
public class Fecha {

    public static String FechaString(int dia, int meses, int ano) {
        String gui;

        String mes = "";

        if (meses == 1) {
            mes = "Enero";
        }
        if (meses == 2) {
            mes = "Febrero";
        }
        if (meses == 3) {
            mes = "Marzo";
        }
        if (meses == 4) {
            mes = "Abril";
        }
        if (meses == 5) {
            mes = "Mayo";
        }
        if (meses == 6) {
            mes = "Junio";
        }
        if (meses == 7) {
            mes = "Julio";
        }
        if (meses == 8) {
            mes = "Agosto";
        }
        if (meses == 9) {
            mes = "Septiembre";
        }
        if (meses == 10) {
            mes = "Octubre";
        }
        if (meses == 11) {
            mes = "Noviembre";
        }
        if (meses == 12) {
            mes = "Diciembre";
        }

        gui = (dia + "/" + mes + "/" + ano);
        return gui.toUpperCase();
    }

    public static String Fecha() {
        String gui;
        Calendar c1 = Calendar.getInstance();
        String dia = Integer.toString(c1.get(Calendar.DATE));
        String mes = Integer.toString(c1.get(Calendar.MONTH) + 1);
        String ano = Integer.toString(c1.get(Calendar.YEAR));
        if (c1.get(Calendar.MONTH) + 1 == 1) {
            mes = "Enero";
        }
        if (c1.get(Calendar.MONTH) + 1 == 2) {
            mes = "Febrero";
        }
        if (c1.get(Calendar.MONTH) + 1 == 3) {
            mes = "Marzo";
        }
        if (c1.get(Calendar.MONTH) + 1 == 4) {
            mes = "Abril";
        }
        if (c1.get(Calendar.MONTH) + 1 == 5) {
            mes = "Mayo";
        }
        if (c1.get(Calendar.MONTH) + 1 == 6) {
            mes = "Junio";
        }
        if (c1.get(Calendar.MONTH) + 1 == 7) {
            mes = "Julio";
        }
        if (c1.get(Calendar.MONTH) + 1 == 8) {
            mes = "Agosto";
        }
        if (c1.get(Calendar.MONTH) + 1 == 9) {
            mes = "Septiembre";
        }
        if (c1.get(Calendar.MONTH) + 1 == 10) {
            mes = "Octubre";
        }
        if (c1.get(Calendar.MONTH) + 1 == 11) {
            mes = "Noviembre";
        }
        if (c1.get(Calendar.MONTH) + 1 == 12) {
            mes = "Diciembre";
        }

        gui = (dia + "/" + mes + "/" + ano);
        return gui;
    }

    public static int Anio() {
        Calendar c1 = Calendar.getInstance();
        return c1.get(Calendar.YEAR);
    }

    public static int Mes() {
        Calendar c1 = Calendar.getInstance();
        return c1.get(Calendar.MONTH) + 1;
    }

    public static int Dia() {
        Calendar c1 = Calendar.getInstance();
        return c1.get(Calendar.DATE);
    }

    public static Date fechaSql() {
        String fecha3 = Anio() + "-" + Mes() + "-" + Dia();
        Date dateSql = Date.valueOf(fecha3);
        return dateSql;
    }

    public static String fechaSqltoString(String fecha) {
        String[] arreglo = fecha.split("-");
        String mes = "0000-00-00";
        if ("01".equals(arreglo[1])) {
            mes = "Enero";
        }
        if ("02".equals(arreglo[1])) {
            mes = "Febrero";
        }
        if ("03".equals(arreglo[1])) {
            mes = "Marzo";
        }
        if ("04".equals(arreglo[1])) {
            mes = "Abril";
        }
        if ("05".equals(arreglo[1])) {
            mes = "Mayo";
        }
        if ("06".equals(arreglo[1])) {
            mes = "Junio";
        }
        if ("07".equals(arreglo[1])) {
            mes = "Julio";
        }
        if ("08".equals(arreglo[1])) {
            mes = "Agosto";
        }
        if ("09".equals(arreglo[1])) {
            mes = "Septiembre";
        }
        if ("10".equals(arreglo[1])) {
            mes = "Octubre";
        }
        if ("11".equals(arreglo[1])) {
            mes = "Noviembre";
        }
        if ("12".equals(arreglo[1])) {
            mes = "Diciembre";
        }
        mes = arreglo[2] + "/" + mes + "/" + arreglo[0];

        return mes;
    }

    public static String diasString(String dia) {
        String cadena = null;
        if ("MON".equals(dia) || "LUN".equals(dia)) {
            cadena = "LUNES";
        }
        if ("TUE".equals(dia) || "MAR".equals(dia)) {
            cadena = "MARTES";
        }

        if ("WED".equals(dia) || "MIE".equals(dia)) {
            cadena = "MIERCOLES";
        }

        if ("THU".equals(dia) || "JUE".equals(dia)) {
            cadena = "JUEVES";
        }

        if ("FRI".equals(dia) || "VIE".equals(dia)) {
            cadena = "VIERNES";
        }

        if ("SAT".equals(dia) || "SAB".equals(dia)) {
            cadena = "SABADO";
        }

        if ("SUN".equals(dia) || "DOM".equals(dia)) {
            cadena = "DOMINGO";
        }
        return cadena;
    }

    public static String diaSemana(int dia) {
        String cadena = null;
        if (dia == 1) {
            cadena = "LUNES";
        }
        if (dia == 2) {
            cadena = "MARTES";
        }

        if (dia == 3) {
            cadena = "MIERCOLES";
        }

        if (dia == 4) {
            cadena = "JUEVES";
        }

        if (dia == 5) {
            cadena = "VIERNES";
        }

        if (dia == 6) {
            cadena = "SABADO";
        }

        if (dia == 7) {
            cadena = "DOMINGO";
        }
        return cadena;
    }

    public static int diaSemanaInt(String dia) {
        int cadena = 0;
        if ("LUNES".equals(dia) || "LUN".equals(dia)) {
            cadena = 1;
        }
        if ("MARTES".equals(dia) || "MAR".equals(dia)) {
            cadena = 2;
        }

        if ("MIERCOLES".equals(dia) || "MIE".equals(dia)) {
            cadena = 3;
        }

        if ("JUEVES".equals(dia) || "JUE".equals(dia)) {
            cadena = 4;
        }

        if ("VIERNES".equals(dia) || "VIE".equals(dia)) {
            cadena = 5;
        }

        if ("SABADO".equals(dia) || "SAB".equals(dia)) {
            cadena = 6;
        }

        if ("DOMINGO".equals(dia) || "DOM".equals(dia)) {
            cadena = 7;
        }
        return cadena;
    }
}
