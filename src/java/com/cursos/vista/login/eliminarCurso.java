/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cursos.vista.login;

import com.cursos.archivo.Archivo;
import com.cursos.dao.Base;
import com.cursos.dao.Consultas;
import demo.data.pojo.Ciencia;
import demo.data.pojo.Curso;
import demo.data.pojo.Materia;
import demo.data.pojo.Profesor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Doublebox;

import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

/**
 *
 * @author jtapia
 */
public class eliminarCurso extends GenericForwardComposer {

    Consultas consu = new Consultas();
    Base dao = new Base();
    Textbox nombrecurso, profesor, horario;
    @Wire
    Window ncurso, dialog;
    String mensaje = "";
    Combobox ciencia, materia, nombreprofesor;
    Button closeBtn, grabar;
    String codigo = "";
    int rep = 0;
    Datebox ff, fi;
    Doublebox valor;
    Integer op = 0, op2 = 0, op3 = 0;
    ArrayList<Ciencia> lista = consu.ConsultaCiencia("cursos", "select * from ciencia order by nombre_ciencia");
    ArrayList<Materia> lista2 = consu.ConsultaMateria("cursos", "select * from materia");
    ArrayList<Profesor> lista3 = consu.ConsultaProfesor("cursos", "select * from profesor where estado='Activo' order by nombre_profesor");
    ArrayList<Curso> lista4 = new ArrayList<Curso>();
    ArrayList<String> validar = new ArrayList<String>();
    String id_curso;
     Integer iden_curso;
    public void onCreate$ncurso() {
        init1();

    }

    public void init1() {
       
        Iterator it = arg.keySet().iterator();
        while (it.hasNext()) {
            Object key = it.next();
            iden_curso = (Integer) arg.get(key);
            dialog = (Window) arg.get("PARENT_WINDOW");
            System.out.println(" hey Parent "+iden_curso );
            init(iden_curso.toString());
        }
    }

    public void init(String clav) {
        id_curso = clav;
        lista4 = consu.ConsultaCurso("cursos", "select * from cursos where id_curso='" + clav + "' and estado='" + "ACTIVO" + "'");
        int pos = busquedaProfesor(lista3, lista4.get(0).getId_profesor());
        op3 = lista4.get(0).getId_profesor();
        nombrecurso.setText(lista4.get(0).getNombre_curso());
        nombreprofesor.setText(lista3.get(pos).getNombreprofesor() + " " + lista3.get(pos).getApellido());

        pos = busquedaCiencia(lista, lista4.get(0).getId_ciencia());
        op = lista4.get(0).getId_ciencia();
        ciencia.setText(lista.get(pos).getNombreciencia());
        pos = busquedaMateria(lista2, lista4.get(0).getId_materia());
        op2 = lista4.get(0).getId_materia();
        materia.setText(lista2.get(pos).getNombremateria());
        valor.setValue(lista4.get(0).getValor());
        fi.setText(lista4.get(0).getFecha_inicio());
        ff.setText(lista4.get(0).getFecha_fin());
        horario.setText(lista4.get(0).getHorario());

    }

    public void onClick$closeBtn() {
        arg.clear();
        ncurso.detach();

    }

    public void onOpen$nombreprofesor() {
        llenarComboProfesor();
    }

    public void onClick$ciencia() {
        llenarComboCiencia();

    }

    public void onOpen$ciencia() {
        llenarComboCiencia();
    }

    public void inHabilitar(boolean valor) {
        nombrecurso.setDisabled(valor);
        profesor.setDisabled(valor);
        materia.setDisabled(valor);
        nombreprofesor.setDisabled(valor);
    }

    public void onChange$nombrecurso() {
        nombrecurso.setText(nombrecurso.getText().toUpperCase());
    }

    public void onChange$ciencia() {
        op = lista.get(ciencia.getSelectedIndex()).getIdciencia();
        lista2 = consu.ConsultaMateria("cursos", "select * from materia where id_ciencia=" + op
                + " order by nombre_materia");
        llenarComboMateria();
    }

    public void onChange$materia() {
        op2 = lista2.get(materia.getSelectedIndex()).getIdmateria();
    }

    public void onChange$nombreprofesor() {
        op3 = lista3.get(nombreprofesor.getSelectedIndex()).getIdprofesor();
    }

    public void onClick$grabar() {
        delete();

    }

    public void delete() {

        try {
            String camp = "nombre_curso,fecha_inicio,fecha_fin,estado";
            String val = "'" + nombrecurso.getText() + "','" + fi.getText()
                    + "','" + ff.getText() + "','" + "INACTIVO" + "'";
            dao.Editar("cursos", camp, val, "cursos", "id_curso", id_curso);
        } catch (Exception ex) {
            Logger.getLogger(editProfesor.class.getName()).log(Level.SEVERE, null, ex);
        }

        grabar.setDisabled(true);
    }

    public void llenarComboCiencia() {

        if (ciencia.getItemCount() > 0) {
            ciencia.getChildren().clear();

        }

        if (lista.size() > 0) {
            Comboitem cmb = null;
            for (int i = 0; i < lista.size(); i++) {
                cmb = new Comboitem(lista.get(i).getNombreciencia());
                ciencia.appendChild(cmb);
            }
        }
    }

    public void llenarComboMateria() {
        System.out.println("materia " + lista.size());
        if (materia.getItemCount() > 0) {
            materia.getChildren().clear();
            materia.setText("");
        }

        if (lista2.size() > 0) {
            Comboitem cmb = null;
            for (int i = 0; i < lista2.size(); i++) {
                cmb = new Comboitem(lista2.get(i).getNombremateria());
                materia.appendChild(cmb);
            }

        }
    }

    public void llenarComboProfesor() {
        if (nombreprofesor.getItemCount() > 0) {
            nombreprofesor.getChildren().clear();
        }

        if (lista3.size() > 0) {
            Comboitem cmb = null;
            for (int i = 0; i < lista3.size(); i++) {
                cmb = new Comboitem(lista3.get(i).getNombreprofesor() + " " + lista3.get(i).getApellido());
                nombreprofesor.appendChild(cmb);
            }
        }
    }

    public int busquedaProfesor(ArrayList<Profesor> valor, int cod) {
        int b = 0;
        for (int i = 0; i < valor.size(); i++) {
            if (cod == valor.get(i).getIdprofesor()) {
                b = i;
                break;
            }
        }
        return b;
    }

    public int busquedaCiencia(ArrayList<Ciencia> valor, int cod) {
        int b = 0;
        for (int i = 0; i < valor.size(); i++) {
            if (cod == valor.get(i).getIdciencia()) {
                b = i;
                break;
            }
        }
        return b;
    }

    public int busquedaMateria(ArrayList<Materia> valor, int cod) {
        int b = 0;
        for (int i = 0; i < valor.size(); i++) {
            if (cod == valor.get(i).getIdmateria()) {
                b = i;
                break;
            }
        }
        return b;
    }
}
