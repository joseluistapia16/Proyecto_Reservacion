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
public class Digitador extends GenericForwardComposer{
    Textbox usuario,clave;
    Menuitem idci,idma,idingcr,idedicr,cnprofesoreliprofesor,edalumno,elalumno,elidicr; 
    Button login;
    
      
     public void onClick$idingcr(){
        try {
            Window window = (Window) Executions.createComponents(
                    "/NuevoCursoE.zul", null, null);
            window.doModal();
        } catch (Exception eu) {

        }
    }   
    
     public void onClick$idedicr(){ 
        try {
            Window window = (Window) Executions.createComponents(
                    "/consuECurso.zul", null, null);
            window.doModal();
        } catch (Exception eu) {

        }
    }   
     
     public void onClick$elidicr(){ 
        try {
            Window window = (Window) Executions.createComponents(
                    "/consuDECurso.zul", null, null);
            window.doModal();
        } catch (Exception eu) {

        }
    } 
     
     
      
}
