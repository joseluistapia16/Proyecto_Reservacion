/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cursos.vista.login;

import com.cursos.archivo.Archivo;
import com.cursos.dao.Base;
import com.cursos.dao.Consultas;
import demo.data.pojo.Alumnos;
import demo.data.pojo.Ciencia;
import demo.data.pojo.Curso;
import demo.data.pojo.CursoEstudiante;
import demo.data.pojo.Materia;
import demo.data.pojo.Profesor;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

/**
 *
 * @author jtapia
 */
public class editarNECurso extends GenericForwardComposer {

    Consultas consu = new Consultas();
    Base dao = new Base();
    Combobox nombrecurso, nombreestudiante;
    @Wire
    Window ncurso;
    Textbox ciencia, materia, nombreprofesor, ff, fi, horario;
    Button closeBtn, grabar;
    String codigo = "";
    int rep = 0, posi = 0;
    String mensaje = "";
    Doublebox valor;
    Integer cur = 0, cal = 0, err = 0;
    ArrayList<Curso> lista = consu.ConsultaCurso("cursos", "select * from cursos where estado='ACTIVO' order by nombre_curso");
    ArrayList<Alumnos> lista2 = consu.ConsultaEstudiante("cursos", "select * from alumnos where estado='ACTIVO' order by nombre");
    String cedulaE, id_cursoE;
    ArrayList<CursoEstudiante> lista1 = new ArrayList<CursoEstudiante>();

    public void onCreate$ncurso() {

        init();

    }

    public void init() {
        String clav = Archivo.leerArchivo("curso");
        id_cursoE = clav;
        llenarComboCurso();
        llenarComboEstudiante();

        lista1 = consu.ConsultaCursoEstudiante("cursos", "select * from cursosestudiante where id_cursoestudiante='" + clav + "' and estado='ÀCTIVO'");
        cur = lista1.get(0).getIdcursoestudiante();
        cal = lista1.get(0).getIdalumno();
        cedulaE = lista1.get(0).getCedulaestudiante();
        lista2 = consu.ConsultaEstudiante("cursos", "select * from alumnos where id_alumno=" + lista1.get(0).getIdalumno() + " and estado='ACTIVO' order by nombre");
        nombreestudiante.setText(lista2.get(0).getCedula() + " " + lista2.get(0).getNombre() + " " + lista2.get(0).getApellido());
        lista = consu.ConsultaCurso("cursos", "select * from cursos where id_curso=" + lista1.get(0).getIdcurso() + " and estado='ACTIVO' order by nombre_curso");
        Ciencia(lista.get(0).getId_ciencia());

        nombrecurso.setText(lista.get(0).getNombre_curso());
        posi = valorCurso(lista, nombrecurso.getText());
        profesor(lista.get(0).getId_profesor());
        Materia(lista.get(0).getId_materia());
        fi.setText(lista.get(0).getFecha_inicio());
        ff.setText(lista.get(0).getFecha_fin());
        valor.setText("" + lista.get(0).getValor());
        horario.setText(lista.get(0).getHorario());
    }

    public void onClick$closeBtn() {

        if (rep == 0 && validarCampos() > 0) {
            if (lista.size() > 0 || lista2.size() > 0) {
                lista.clear();
                lista2.clear();
            }
            ncurso.detach();
        }

        if (rep > 0 && validarCampos() == 0) {
            record();
            lista.clear();
            lista2.clear();
            ncurso.detach();
        }
        if (rep == 0 && validarCampos() == 0 && err == 0) {
            Messagebox.show("Desea Grabar ?", "Confirm Dialog", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
                public void onEvent(Event evt) throws InterruptedException {

                    if (evt.getName().equals("onOK")) {
                        record();
                        lista.clear();
                        lista2.clear();
                        alert("Data Saved !");
                        ncurso.detach();
                    } // if sec    
                    else {
                        lista.clear();
                        lista2.clear();
                        ncurso.detach();
                    }  // if sec  
                }  // imetod sec               
            }); // metodo mensaje        
        } else {
            lista.clear();
            lista2.clear();
            ncurso.detach();
        }  // if sec 

    }

    public void onOpen$nombrecurso() {
         lista = consu.ConsultaCurso("cursos", "select * from cursos where estado='ACTIVO' order by nombre_curso");
        llenarComboCurso();
    }

    public void onOpen$nombreestudiante() {

        lista2 = consu.ConsultaEstudiante("cursos", "select * from alumnos where estado='ACTIVO' order by nombre");
        llenarComboEstudiante();
    }

    public void onChange$nombrecurso() {
        
        if (!"".equals(nombrecurso.getText())) {
            posi = valorCurso(lista, nombrecurso.getText());

            cur = lista.get(posi).getId_curso();
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(lista.get(i).getNombre_curso() + " " + nombrecurso.getItemAtIndex(i).getLabel() + " " + lista.get(i).getId_profesor() + " " + lista.get(i).getId_curso() + " " + posi);
            }

            llenarCurso();
        }
    }

    public void onChange$nombreestudiante() {
        cal = lista2.get(nombreestudiante.getSelectedIndex()).getIdealumno();
        cedulaE = lista2.get(nombreestudiante.getSelectedIndex()).getCedula();
    }

    public void onClick$grabar() {
        String n = ciencia.getText(), h = nombrecurso.getText();
        int vali = validarCampos();
        if (vali == 0) {
            nombrecurso.setText(h.toUpperCase());
            if (consu.ConsultaCursoEstudiante("cursos", "select * from cursosestudiante where id_curso=" + cur + " and id_alumno=" + cal + " and estado='ÀCTIVO'").size() > 0) {
                Messagebox.show("No puede un alumno, inscribirse en un curso màs de una vez!!");
                rep = 0;
                err = 1;
            } else {
                rep++;
                err = 0;
            }
        } else {
            Messagebox.show(mensaje + " ! ! " + "\n");
            rep = 0;
            err = 1;
        }

    }

    public void record() {
        String camp = "id_curso,id_alumno,estado,nombre_cursosestudiante,cedula_estudiante,id_profesor";
        String val = "'" + lista.get(posi).getId_curso() + "','" + cal + "','" + "ACTIVO" + "','" + nombrecurso.getText() + "','" + cedulaE +"','" + lista.get(posi).getId_profesor() +  "'";
        try {
            dao.Editar("cursos", camp, val, "CursosEstudiante", "id_cursoestudiante", id_cursoE);
        } catch (Exception ex) {
            Logger.getLogger(editarNECurso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void llenarCurso() {
        valor.setValue(lista.get(posi).getValor());
        fi.setText(lista.get(posi).getFecha_inicio());
        ff.setText(lista.get(posi).getFecha_fin());
        horario.setText(lista.get(posi).getHorario());
        profesor(lista.get(posi).getId_profesor());
        Ciencia(lista.get(posi).getId_ciencia());
        Materia(lista.get(posi).getId_materia());

    }

    public void profesor(Integer cod) {
        ArrayList<Profesor> listap = consu.ConsultaProfesor("cursos", "select * from profesor where id_profesor=" + cod + " and estado='ACTIVO'");
        nombreprofesor.setText(listap.get(0).getNombreprofesor() + " " + listap.get(0).getApellido());
        listap = null;
    }

    public void Ciencia(Integer cod) {
        ArrayList<Ciencia> listap = consu.ConsultaCiencia("cursos", "select * from ciencia where id_ciencia=" + cod);
        ciencia.setText(listap.get(0).getNombreciencia());
        listap = null;
    }

    public void Materia(Integer cod) {
        ArrayList<Materia> listap = consu.ConsultaMateria("cursos", "select * from materia where id_materia=" + cod);
        materia.setText(listap.get(0).getNombremateria());
        listap = null;
    }

    public void llenarComboEstudiante() {
        System.out.println("materia " + lista.size());
        if (nombreestudiante.getItemCount() > 0) {
            nombreestudiante.getChildren().clear();

        }

        if (lista2.size() > 0) {
            Comboitem cmb = null;
            for (int i = 0; i < lista2.size(); i++) {
                cmb = new Comboitem(lista2.get(i).getCedula() + " " + lista2.get(i).getNombre() + " " + lista2.get(i).getApellido());
                nombreestudiante.appendChild(cmb);
            }

        }
    }

    public void llenarComboCurso() {
        if (nombrecurso.getItemCount() > 0) {
            nombrecurso.getChildren().clear();
        }

        if (lista.size() > 0) {
            Comboitem cmb = null;
            for (int i = 0; i < lista.size(); i++) {
                cmb = new Comboitem(lista.get(i).getNombre_curso());
                nombrecurso.appendChild(cmb);
            }
        }
    }

    //***********
    public int validarCampos() {
        mensaje = "";
        int conta = 0;

        if ("".equals(nombrecurso.getText())) {
            mensaje = mensaje + " Nombre del curso del estudiante ";
            conta++;
        }
        if ("".equals(nombreestudiante.getText())) {
            mensaje = mensaje + " Alumno ";
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

    public int valorCurso(ArrayList<Curso> lista1, String val) {
        int j = 0;
        for (int i = 0; i < lista1.size(); i++) {
            if (val.equals(lista1.get(i).getNombre_curso())) {
                j = i;
                break;
            }
        }
        return j;

    }

}
