/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cursos.vista.login;


import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Menuitem;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

/**
 *
 * @author jtapia
 */
public class Madministrador extends GenericForwardComposer{
    Textbox usuario,clave;
    Menuitem idci,idma,idingcr,idedicr,cnprofesoreliprofesor,edalumno,elalumno,elidicr; 
    Button login;
    public void onClick$idci(){
        try {
            //create a window programmatically and use it as a modal dialog.
            Window window = (Window) Executions.createComponents(
                    "/Fciencia.zul", null, null);
            window.doModal();
        } catch (Exception eu) {

        }
    }
    
      public void onClick$idma(){
        try {
            //create a window programmatically and use it as a modal dialog.
            Window window = (Window) Executions.createComponents(
                    "/Nmateria.zul", null, null);
            window.doModal();
        } catch (Exception eu) {

        }
    }
      
     public void onClick$idingcr(){
        try {
            //create a window programmatically and use it as a modal dialog.
            Window window = (Window) Executions.createComponents(
                    "/NuevoCurso.zul", null, null);
            window.doModal();
        } catch (Exception eu) {

        }
    }   
    
     public void onClick$idedicr(){ 
        try {
            //create a window programmatically and use it as a modal dialog.
            Window window = (Window) Executions.createComponents(
                    "/consuCurso.zul", null, null);
            window.doModal();
        } catch (Exception eu) {

        }
    }   
     
     public void onClick$elidicr(){ 
        try {
            //create a window programmatically and use it as a modal dialog.
            Window window = (Window) Executions.createComponents(
                    "/EliminaCurso.zul", null, null);
            window.doModal();
        } catch (Exception eu) {

        }
    } 
     
     
     public void onClick$inprofesor(){
        try {
            //create a window programmatically and use it as a modal dialog.
            Window window = (Window) Executions.createComponents(
                    "/NuevoProfesor.zul", null, null);
            window.doModal();
        } catch (Exception eu) {

        }
    }
     
      public void onClick$cnprofesor(){
        try {
            //create a window programmatically and use it as a modal dialog.
            Window window = (Window) Executions.createComponents(
                    "/consuProfesor.zul", null, null);
            window.doModal();
        } catch (Exception eu) {

        }
    }  
      
       public void onClick$eliprofesor(){
        try {
            //create a window programmatically and use it as a modal dialog.
            Window window = (Window) Executions.createComponents(
                    "/conelProfesor.zul", null, null);
            window.doModal();
        } catch (Exception eu) {

        }
    }  
      
     
    public void onClick$inalumno(){
        try {
            //create a window programmatically and use it as a modal dialog.
            Window window = (Window) Executions.createComponents(
                    "/NuevoAlumno.zul", null, null);
            window.doModal();
        } catch (Exception eu) {

        }
    } 
    
     public void onClick$edalumno(){
        try {
            //create a window programmatically and use it as a modal dialog.
            Window window = (Window) Executions.createComponents(
                    "/consuAlumno.zul", null, null);
            window.doModal();
        } catch (Exception eu) {

        }
    }
     
     public void onClick$elalumno(){
        try {
            //create a window programmatically and use it as a modal dialog.
            Window window = (Window) Executions.createComponents(
                    "/conelAlumno.zul", null, null);
            window.doModal();
        } catch (Exception eu) {

        }
    }
      
}
