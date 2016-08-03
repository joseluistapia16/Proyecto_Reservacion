package com.reservacion.componentes;

 
import com.reservacion.pojo.Estudiante;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Validaciones {

    public static boolean validarCedula(ArrayList<Estudiante> lista, String cedula) {
        boolean valor = false;
        if (cedula.length() < 10) {
            valor = false;

        } else {
            boolean valor1 = Validaciones.busquedaCedulaEstudiante(lista, cedula);
            if (valor1 == true) {
                JOptionPane.showMessageDialog(null, "Cedula ya Existe!! ");
                valor = false;
            } else {
                valor = true;
            }
        }
        return valor;
    }

    public static boolean busquedaCedulaEstudiante(ArrayList<Estudiante> lista, String cedula) {
        boolean valor = false;
        for (int o = 0; o < lista.size(); o++) {
            if (lista.get(o).getCedula().equals(cedula)) {
                valor = true;
                break;
            } else {
                valor = false;
            }
        }
        return valor;
    }
    
    public static boolean validarCedulaEstudiante(ArrayList<Estudiante> lista, String cedula) {
        boolean valor = false;
        if (cedula.length() < 10) {
            valor = false;

        } else {
            boolean valor1 = Validaciones.busquedaCedulaEstudiante(lista, cedula);
            if (valor1 == true) {
                JOptionPane.showMessageDialog(null, "Cedula ya Existe!! ");
                valor = false;
            } else {
                valor = true;
            }
        }
        return valor;
    }

     
}
