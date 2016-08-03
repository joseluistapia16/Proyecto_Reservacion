package com.reservacion.archivos;

import com.reservacion.pojo.Estudiante;
import com.reservacion.pojo.Reservacion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.ArrayList;

public class Archivo {
     public static void guardarReservaciones(String archivo1, ArrayList<Reservacion> objeto) {
        try {
            ObjectOutputStream escritura = new ObjectOutputStream(new FileOutputStream(archivo1));
            escritura.writeObject(objeto);
            escritura.flush();
            escritura.close();
        } catch (Exception e) {

        }
    }

    public static void guardarEstudiante(String archivo1, ArrayList<Estudiante> objeto) {
        try {
            ObjectOutputStream escritura = new ObjectOutputStream(new FileOutputStream(archivo1));
            escritura.writeObject(objeto);
            escritura.flush();
            escritura.close();
        } catch (Exception e) {

        }
    }

    public static ArrayList<Estudiante> LeerEstudiantes(String archivo1) {
       
        ArrayList<Estudiante> lista = new ArrayList<Estudiante>();
         try{
            File fichero = new File(archivo1);
            FileInputStream fis = new FileInputStream(fichero);
            ObjectInputStream ois = new ObjectInputStream(fis);
            lista = (ArrayList<Estudiante>) ois.readObject();
         }catch(Exception e){
             
         }
        return lista;
    }
    
    public static ArrayList<Reservacion> LeerReservaciones(String archivo1) {
       
        ArrayList<Reservacion> lista = new ArrayList<Reservacion>();
         try{
            File fichero = new File(archivo1);
            FileInputStream fis = new FileInputStream(fichero);
            ObjectInputStream ois = new ObjectInputStream(fis);
            lista = (ArrayList<Reservacion>) ois.readObject();
         }catch(Exception e){
             
         }
        return lista;
    }
    
    

}
