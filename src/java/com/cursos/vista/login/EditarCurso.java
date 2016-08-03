/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cursos.vista.login;
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
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

/**
 *
 * @author jtapia
 */
public class EditarCurso extends GenericForwardComposer {

    Consultas consu = new Consultas();
    Base dao = new Base();
    Textbox nombrecurso, profesor, horario;
    @Wire
    Window ncurso1, dialog;
    String mensaje = "";
    Combobox ciencia, materia, nombreprofesor;
    Button closeBtn, grabar;
    String codigo = "";
    int rep = 0;
    Datebox ff, fi;
    Doublebox valor;
    Integer op = 0, op2 = 0, op3 = 0, iden_curso;
    ArrayList<Ciencia> lista = consu.ConsultaCiencia("cursos", "select * from ciencia order by nombre_ciencia");
    ArrayList<Materia> lista2 = consu.ConsultaMateria("cursos", "select * from materia");
    ArrayList<Profesor> lista3 = consu.ConsultaProfesor("cursos", "select * from profesor where estado='Activo' order by nombre_profesor");
    ArrayList<Curso> lista4 = new ArrayList<Curso>();
    ArrayList<String> validar = new ArrayList<String>();
    String id_curso;

    public void onCreate$ncurso1() {
        init1();

    }

    public void init1() {
        Iterator it = arg.keySet().iterator();
        while (it.hasNext()) {
            Object key = it.next();
            iden_curso = (Integer) arg.get(key);
            dialog = (Window) arg.get("PARENT_WINDOW");
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
        String h = nombrecurso.getText();
        if (rep == 0 && validarCampos() > 0) {
            if (lista.size() > 0 || lista2.size() > 0 || lista3.size() > 0) {
                lista.clear();
                lista2.clear();
                lista3.clear();
            }
            arg.clear();
            ncurso1.detach();

        }

        if (rep > 0 && validarCampos() == 0) {
            record(h);
            lista.clear();
            lista2.clear();
            lista3.clear();
            arg.clear();
            ncurso1.detach();

        }
        if (rep == 0 && validarCampos() == 0) {
            Messagebox.show("Desea Grabar ?", "Confirm Dialog", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
                public void onEvent(Event evt) throws InterruptedException {
                    String hi = nombrecurso.getText();
                    if (evt.getName().equals("onOK")) {
                        record(hi);
                        lista.clear();
                        lista2.clear();
                        lista3.clear();
                        arg.clear();
                        ncurso1.detach();

                    } else {
                        lista.clear();
                        lista2.clear();
                        lista3.clear();
                        arg.clear();
                        ncurso1.detach();

                    }  // if sec  
                }  // imetod sec               
            }); // metodo mensaje        
        } // if princ

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
        String n = ciencia.getText(), h = nombrecurso.getText();
        int vali = validarCampos();
        if (vali == 0) {
            nombrecurso.setText(h.toUpperCase());
            if (consu.ConsultaCurso("cursos", "select * from cursos where nombre_curso='"
                    + nombrecurso.getText() + "' and id_ciencia=" + op + " and id_materia=" + op2 + " and id_profesor=" + op3
                    + " and valor=" + valor.getValue() + " and horario='" + horario.getText() + "'").size() > 0) {
                Messagebox.show("Curso de " + nombrecurso.getText() + " con el mismo Horario " + " ! ! " + "\n" + " y el mismo Profesor.. Ya Existe");
                rep = 0;
            } else {
                rep++;

            }
        } else {
            Messagebox.show(mensaje + " ! ! " + "\n");
            rep = 0;
        }

    }

    public void record(String cadena) {

        String camp = "id_ciencia,nombre_curso,id_materia,id_profesor,valor,fecha_inicio,fecha_fin,horario";
        String val = "'" + op + "','" + nombrecurso.getText() + "','" + op2 + "','" + op3 + "','" + valor.getValue() + "','"
                + fi.getText() + "','" + ff.getText() + "','" + horario.getText() + "'";
        System.out.println(camp);
        System.out.println(val);
        try {
            dao.Editar("cursos", camp, val, "cursos", "id_curso", id_curso);

        } catch (Exception ex) {
            Logger.getLogger(EditarCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    //***********
    public int validarCampos() {
        mensaje = "";
        int conta = 0;

        if ("".equals(nombrecurso.getText())) {
            mensaje = mensaje + " Nombre del curso ";
            conta++;
        }
        if ("".equals(nombreprofesor.getText())) {
            mensaje = mensaje + " Profesor ";
            conta++;
        }

        if ("".equals(ciencia.getText())) {
            mensaje = mensaje + " Ciencia ";
            conta++;
        }

        if ("".equals(materia.getText())) {
            mensaje = mensaje + " Materia ";
            conta++;
        }
        if ("".equals(horario.getText())) {
            mensaje = mensaje + " Horario ";
            conta++;
        }

        if ("".equals(ff.getText())) {
            mensaje = mensaje + "  Fecha Final ";
            conta++;
        }

        if ("".equals(fi.getText())) {
            mensaje = mensaje + " Fecha Inicial ";
            conta++;
        }
        if (valor.getValue() < 1) {
            mensaje = mensaje + " Valor ";
            conta++;
        }

        if ("".equals(horario.getText())) {
            mensaje = mensaje + "  Horario ";
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
