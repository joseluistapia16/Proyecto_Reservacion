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
public class RProfesor extends GenericForwardComposer{
    Textbox usuario,clave;
    Menuitem cursos,alumnos; 
    Button login;
    
     public void onClick$cursos(){
         
        try {
            //create a window programmatically and use it as a modal dialog.
            Window window = (Window) Executions.createComponents(
                    "/consuRCurso.zul", null, null);
            window.doModal();
        } catch (Exception eu) {

        }
    }   
    
     public void onClick$alumnos(){ 
        try {
            //create a window programmatically and use it as a modal dialog.
            Window window = (Window) Executions.createComponents(
                    "/consuACurso.zul", null, null);
            window.doModal();
        } catch (Exception eu) {

        }
    }   
     
      
     
     
      
}
