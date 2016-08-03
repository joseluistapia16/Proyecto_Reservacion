package com.cursos.vista.login;

import com.curso.componentes.Validacion;
import com.cursos.archivo.Archivo;
import com.cursos.dao.Base;
import com.cursos.dao.Consultas;
import demo.data.pojo.Profesor;

import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.zkoss.zk.ui.event.Event;

import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

/**
 *
 * @author TapiaSoftware
 */

public class editProfesor extends GenericForwardComposer {
// @Inject
   Consultas consu = new Consultas();
    Base dao = new Base();
    Textbox cedula, nombre, apellido, telefono, direccion, correo;
   
    Combobox combo;
    Button cerrar, grabar;
    String codigo = "";
    int rep = 0;
    Integer op = 0;
    String mensaje = "";
    ArrayList<Profesor> lista = new ArrayList<Profesor>();
    ArrayList<String> validar = new ArrayList<String>();

    

    String id_profesor;

    @Wire  // anotacion que apunta a la ventana
    Window venprofesor;
  
public void onCreate$venprofesor(){
      init();
      
}
    public void init() {
       String clav= Archivo.leerArchivo("curso");
       id_profesor = clav;
        lista= consu.ConsultaProfesor("cursos","select * from profesor where id_profesor='"+clav+"'");
      cedula.setText(lista.get(0).getCedula());
      nombre.setText(lista.get(0).getNombreprofesor());
      apellido.setText(lista.get(0).getApellido());
      telefono.setText(lista.get(0).getTelefono());
      direccion.setText(lista.get(0).getDireccion());
      correo.setText(lista.get(0).getCorreo());
    }
    
 
 

     

    public void onChange$nombre() {
        nombre.setText(nombre.getText().toUpperCase());
    }

    public void onChange$apellido() {
        apellido.setText(apellido.getText().toUpperCase());
    }

    public void onChange$direccion() {
        direccion.setText(direccion.getText().toUpperCase());
    }

    public int validarCampos() {
        mensaje = "";
        int conta = 0;
       
        if ("".equals(nombre.getText())) {
            mensaje = mensaje + " Nombre ";
            conta++;
        }
        if ("".equals(apellido.getText())) {
            mensaje = mensaje + " Apellido ";
            conta++;
        }

        if ("".equals(direccion.getText())) {
            mensaje = mensaje + " Direccion ";
            conta++;
        }

        if (Validacion.Telefono(telefono.getText()) == false) {
            mensaje = mensaje + " Telefono ";
            conta++;
        }

        if (Validacion.Email(correo.getText()) == false) {
            mensaje = mensaje + " Correo ";
            conta++;
        }
        if (conta > 1) {
            mensaje = "Campos " + mensaje + " Invàlidos.";
        }
        if (conta == 1) {
            mensaje = "Campo " + mensaje + " Invàlido.";
        }
        if (conta < 1) {
            mensaje = "";
        }
        return conta;

    }

     

    public void inHabilitar(boolean valor) {
        nombre.setDisabled(valor);
        apellido.setDisabled(valor);
        telefono.setDisabled(valor);
        direccion.setDisabled(valor);
        correo.setDisabled(valor);;
    }

    //////////////////////
    public void onClick$cerrar() {
        if (rep == 0 && validarCampos() > 0) {
            venprofesor.detach();
        }
        String h = cedula.getText();
        if (rep > 0 && validarCampos() == 0) {

            record(h);
            venprofesor.detach();
        }
        if (rep == 0 && validarCampos() == 0) {
            Messagebox.show("Desea Grabar ?", "Confirm Dialog", Messagebox.OK | Messagebox.IGNORE | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
                public void onEvent(Event evt) throws InterruptedException {
                    String hi = cedula.getText();
                    if (evt.getName().equals("onOK")) {
                        record(hi);
                        alert("Data Saved !");
                        venprofesor.detach();
                    }  // if sec    

                    else {
                      
                        venprofesor.detach();
                    }  // if sec  
                }  // imetod sec               
            }); // metodo mensaje        
        } // if princ
      rep=0;
    }

    public void onClick$grabar() {
        if (validarCampos() == 0) {
            rep++;
        } else {
            Messagebox.show(mensaje + " !" + "\n");
            rep = 0;
        }

    }

    public void record(String cadena) {

        try {
            String camp = "nombre_profesor,apellido,telefono,direccion,correo";
            String val = "'"  + nombre.getText() + "','" + apellido.getText()
                    + "','" + telefono.getText() + "','" + direccion.getText() + "','" + correo.getText() + "'";          
            dao.Editar("cursos", camp, val, "profesor", "id_profesor",id_profesor );      
        } catch (Exception ex) {
            Logger.getLogger(editProfesor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


}
