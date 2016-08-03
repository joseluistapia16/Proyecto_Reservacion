/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cursos.vista.login;

import com.curso.componentes.Fecha;
import com.cursos.archivo.Archivo;
import com.cursos.dao.Base;
import com.cursos.dao.Consultas;
import demo.data.pojo.Usuario;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;


/**
 *
 * @author jtapia
 */
public class VistaLogin extends GenericForwardComposer {
    
    Consultas consu = new Consultas();
    Base dao = new Base();
    Textbox usuario, clave;
    Label mensaje;
    ArrayList<Usuario> lista = new ArrayList<Usuario>();
    ArrayList<Usuario> consulta = new ArrayList<Usuario>();
    Button login;
  
    public void onClick$login() {
         mensaje.setValue("");
        lista = consu.ConsultaUsuario("cursos", "select * from usuarios where Usuario='" + usuario.getText() + "'"
                + " and Clave='" + clave.getText() + "'");
        if (lista.size() > 0) {
            recordP();
            if (lista.get(0).getIdrol() == 1) {
                login.setHref("/Administrador.zul");
            }
            if (lista.get(0).getIdrol() == 2) {
                login.setHref("/Digitador.zul");
            }
            if (lista.get(0).getIdrol() == 3) {
                
                Archivo.crearArchivo("cursoProfesor", lista.get(0).getIdrol() + "-" + lista.get(0).getCedula() + "-");
                System.out.println(" cedula login " + lista.get(0).getCedula());
                login.setHref("/Profesor.zul");
            }
            
        } else {
            recordF();
            mensaje.setValue("Usuario o clave Incorrecta");
        }
        
    }
    
    public void recordP() {
        
        String camp2 = "id_usuario,usuario,hora_conexion,fecha_conexion,intento_fallido,intento_exitoso,detalle";
        String val = "'" + lista.get(0).getIdusuario() + "','" + lista.get(0).getUsuario() + "','" + Fecha.getHoraActual()
                + "','" + Fecha.Fecha() + "','" + 0 + "','" + 1 + "','" + "EXITOSO" + "'";
        
        try {
            
            dao.Guardar("cursos", "seguridad", camp2, val);
            
        } catch (Exception ex) {
            Logger.getLogger(VistaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void recordF() {
        
        String camp2 = "id_usuario,usuario,hora_conexion,fecha_conexion,intento_fallido,intento_exitoso,detalle";
        String val = "'" + 0 + "','" + usuario.getText() + "','" + Fecha.getHoraActual()
                + "','" + Fecha.Fecha() + "','" + 1 + "','" + 0 + "','" + "FALLIDO" + "'";
        
        try {
            
            dao.Guardar("cursos", "seguridad", camp2, val);
            
        } catch (Exception ex) {
            Logger.getLogger(VistaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
