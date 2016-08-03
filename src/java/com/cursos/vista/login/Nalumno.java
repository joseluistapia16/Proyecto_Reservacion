/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cursos.vista.login;

import com.curso.componentes.Fecha;
import com.curso.componentes.Generacion;
import com.curso.componentes.Validacion;
import com.cursos.dao.Base;
import com.cursos.dao.Consultas;
import demo.data.pojo.Alumnos;
import demo.data.pojo.Usuario;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

/**
 *
 * @author jtapia
 */
public class Nalumno extends GenericForwardComposer {

    Consultas consu = new Consultas();
    Base dao = new Base();
    Textbox cedula, nombre, apellido, telefono, direccion, correo;
    Window nestudiante;
    Combobox combo;
    Button closeBtn, grabar, buscar;
    String codigo = "";
    int rep = 0;
    Integer op = 0;
    String mensaje = "";
    ArrayList<Alumnos> lista = consu.ConsultaEstudiante("cursos", "select * from alumnos  WHERE estado='ACTIVO' order by nombre");
    ArrayList<String> validar = new ArrayList<String>();
    //////////////////////

    public void onCreate$nestudiante() {
        inHabilitar(true);
    }

    public void onClick$buscar() {
        ValidarCedula();
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
        if (Validacion.Cedula(cedula.getText()) == false) {
            mensaje = mensaje + " Cedula ";
            conta++;
        } else {
            if (consu.ConsultaEstudiante("cursos", "select * from alumnos where  estado='ACTIVO' and cedula='"
                    + cedula.getText() + "'").size() > 0) {
                mensaje = mensaje + " Cedula Ya Existe ";
                conta++;
            }
        }

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

    public void ValidarCedula() {
        if (Validacion.Cedula(cedula.getText()) == true) {
            if (consu.ConsultaEstudiante("cursos", "select * from alumnos   WHERE estado='ACTIVO' and cedula='"
                    + cedula.getText() + "'").size() > 0) {
                Messagebox.show(cedula.getText() + " ! ! " + "\n" + " Ya Existe");
                inHabilitar(true);
            } else {
                inHabilitar(false);
            }
        } else {
            inHabilitar(true);
            Messagebox.show(" Cedula Invàlida !");

        }

    }

    public void inHabilitar(boolean valor) {
        nombre.setDisabled(valor);
        apellido.setDisabled(valor);
        telefono.setDisabled(valor);
        direccion.setDisabled(valor);
        correo.setDisabled(valor);;
    }

    //////////////////////
    public void onClick$closeBtn() {
        if (rep == 0 && validarCampos() > 0) {
            nestudiante.detach();
        }
        String h = cedula.getText();
        if (rep > 0 && validarCampos() == 0) {

            record(h);
            nestudiante.detach();
        }
        if (rep == 0 && validarCampos() == 0) {
            Messagebox.show("Desea Grabar ?", "Confirm Dialog", Messagebox.OK | Messagebox.IGNORE | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
                public void onEvent(Event evt) throws InterruptedException {
                    String hi = cedula.getText();
                    if (evt.getName().equals("onOK")) {
                        record(hi);
                        alert("Data Saved !");
                        nestudiante.detach();
                    }  // if sec    

                    if (evt.getName().equals("onCANCEL")) {
                        alert("Data Saved !");
                        nestudiante.detach();
                    }  // if sec  
                }  // imetod sec               
            }); // metodo mensaje        
        } // if princ

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

        String camp;
        String camp2 = "cedula,nombre_usuario,apellido,telefono,direccion,correo,fechas,nombre_rol,id_rol";
        String val = "'" + cedula.getText() + "','" + nombre.getText() + "','" + apellido.getText()
                + "','" + telefono.getText() + "','" + direccion.getText() + "','" + correo.getText() + "','" + Fecha.Fecha()
                + "','" + "ALUMNO" + "','" + 4 + "'";

        try {

            dao.Guardar("cursos", "usuarios", camp2, val);

            ArrayList<Usuario> lista2 = consu.ConsultaUsuario("cursos", "SELECT * from usuarios");
            int pos = lista2.size() - 1;

            String usuario = Generacion.generaUsuario(nombre.getText(), apellido.getText()) + lista2.get(pos).getIdusuario();

            String val2 = "'" + usuario + "','" + ("E-" + lista2.get(pos).getIdusuario() + cedula.getText()) + "'";
            dao.EditarNM("cursos", "usuario,clave", val2, "usuarios", "id_usuario", lista2.get(pos).getIdusuario());
            camp = "cedula,nombre,apellido,telefono,direccion,correo,fechas,nombre_rol,id_rol,nombre_usuario,estado";
            val = "'" + cedula.getText() + "','" + nombre.getText() + "','" + apellido.getText()
                    + "','" + telefono.getText() + "','" + direccion.getText() + "','" + correo.getText() + "','" + Fecha.Fecha()
                    + "','" + "ALUMNOS" + "','" + 4 + "','" + usuario + "','" + "ACTIVO" + "'";
            dao.Guardar("cursos", "alumnos", camp, val);
            lista2.clear();
        } catch (Exception ex) {
            Logger.getLogger(Nalumno.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
