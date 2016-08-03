/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cursos.vista.login;

/**
 *
 * @author jtapia
 */
import com.cursos.archivo.Archivo;
import com.cursos.dao.Consultas;
import demo.data.pojo.Alumnos;
import demo.data.pojo.Curso;
import demo.data.pojo.CursoEstudiante;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listhead;
import org.zkoss.zul.Listheader;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class consuCurso extends GenericForwardComposer {

    int ind = 0;
    Consultas consu = new Consultas();
    Map<String, Integer> parametro = new HashMap<String, Integer>();
    private static final long serialVersionUID = 1L;
    @Wire
    Listbox tabla;
    @Wire
    Window consuprofe;
    @Wire
    Button closeBtn, buscar;
    @Wire
    Textbox filtro;
    List<CursoEstudiante> lista = new ArrayList<CursoEstudiante>();
    List<Curso> lista2 = new ArrayList<Curso>();
    List<Alumnos> lista3 = new ArrayList<Alumnos>();
    public void onClick$closeBtn() {
        consuprofe.detach();
    }

    public void onClick$tabla() {
      try{ 
        if (lista.size() > 0) {
            int id = tabla.getSelectedIndex();
            Integer iden = lista.get(id).getIdcursoestudiante();
            parametro.put("id_curso", iden);
            Archivo.crearArchivo("curso", iden.toString());
            Window window = (Window) Executions.createComponents("/editarCursoE.zul", null, parametro);
            window.doModal();
            consuprofe.detach();

        }
      } catch(Exception e){
          
      }

    }

    public void onClick$buscar() {
        Tabla1b(filtro.getText());
    }

    public void onCreate$consuprofe() {  // Ejecuta los procesos al arrancar la pagina

        Tabla1();

    }

    public void Tabla1() {

        lista = consu.ConsultaCursoEstudiante("cursos", "select * from cursosestudiante WHERE estado='ACTIVO'");// aqui falta corregir   
        tabla.setRows(7);
        for (int i = 0; i < lista.size(); i++) {
            lista3= consu.ConsultaEstudiante("cursos","select * from alumnos where id_alumno="+lista.get(i).getIdalumno()+" AND estado='ACTIVO'");
            lista2= consu.ConsultaCurso("cursos","select * from cursos where id_curso="+lista.get(i).getIdcurso()+" AND estado='ACTIVO'");
            Listitem item = new Listitem();
            Listcell cell = new Listcell(lista2.get(0).getNombre_curso());
            Listcell cell1 = new Listcell(lista2.get(0).getFecha_inicio());
            Listcell cell2 = new Listcell(lista2.get(0).getFecha_fin());
            Listcell cell3 = new Listcell(lista3.get(0).getCedula());
            Listcell cell4 = new Listcell(lista2.get(0).getHorario());
            item.appendChild(cell);
            item.appendChild(cell1);
            item.appendChild(cell2);
            item.appendChild(cell3);
            item.appendChild(cell4);
            tabla.appendChild(item);
        }
    }

    public void Tabla1b(String cedula) {
        if (tabla.getRows() > 0) {
            tabla.getChildren().clear();
        }

        lista = consu.ConsultaCursoEstudiante("Cursos", "Select * from cursosestudiante where cedula_estudiante LIKE '%" + cedula + "%' and estado='ACTIVO'"); // aqui falta corregir   
        tabla.setRows(7);
      
        Listhead cabeza = new Listhead();
        Listheader ti = new Listheader("Curso");            ti.setAlign("center");
        Listheader to = new Listheader("Fecha Inicio");    to.setWidth("120px"); to.setAlign("center");
        Listheader to1 = new Listheader("Fecha Fin");      to1.setWidth("120px"); to1.setAlign("center");
        Listheader to2 = new Listheader("Id Alumno");          to2.setWidth("110px"); to2.setAlign("center");
        Listheader to3 = new Listheader("Horario");         to3.setAlign("center");
        tabla.appendChild(cabeza);
        for (int i = 0; i < lista.size(); i++) {
            lista3= consu.ConsultaEstudiante("cursos","select * from alumnos where id_alumno="+lista.get(i).getIdalumno()+" AND estado='ACTIVO'");
            lista2= consu.ConsultaCurso("cursos","select * from cursos where id_curso="+lista.get(i).getIdcurso()+" AND estado='ACTIVO'");
            Listitem item = new Listitem();
            Listcell cell = new Listcell(lista2.get(0).getNombre_curso());
            Listcell cell1 = new Listcell(lista2.get(0).getFecha_inicio());
            Listcell cell2 = new Listcell(lista2.get(0).getFecha_fin());
            Listcell cell3 = new Listcell(lista3.get(0).getCedula());
            Listcell cell4 = new Listcell(lista2.get(0).getHorario());
            cabeza.appendChild(ti);
            cabeza.appendChild(to);
            cabeza.appendChild(to1);
            cabeza.appendChild(to2);
            cabeza.appendChild(to3);
            item.appendChild(cell);
            item.appendChild(cell1);
            item.appendChild(cell2);
            item.appendChild(cell3);
            item.appendChild(cell4);
            tabla.appendChild(item);
        }
    }

}
