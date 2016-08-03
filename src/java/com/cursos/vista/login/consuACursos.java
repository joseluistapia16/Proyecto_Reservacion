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
import com.curso.componentes.Generacion;
import com.cursos.archivo.Archivo;
import com.cursos.dao.Consultas;
import demo.data.pojo.Alumnos;
import demo.data.pojo.Curso;
import demo.data.pojo.CursoEstudiante;
import demo.data.pojo.Profesor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

public class consuACursos extends GenericForwardComposer {

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
    List<CursoEstudiante> lista2 = new ArrayList<CursoEstudiante>();
    List<Curso> lista = new ArrayList<Curso>();
    List<Profesor> lista3 = new ArrayList<Profesor>();
    ArrayList<Alumnos> lista4 = new ArrayList<Alumnos>();
    String id_profesor;
    Integer iden_profesor;

    public void onCreate$consuprofe() {
        init();

    }

    public void onClick$closeBtn() {
        consuprofe.detach();
    }

    public void init() {
        String clav = Archivo.leerArchivo("cursoProfesor"), cedula;

        ArrayList<String> valores = Generacion.descompnerCadena(clav);
        id_profesor = valores.get(0);
        cedula = valores.get(1);
        lista3 = consu.ConsultaProfesor("cursos", "select * from profesor where cedula='" + cedula + "' and estado='ACTIVO'");
        iden_profesor = lista3.get(0).getIdprofesor();
        System.out.println(iden_profesor + "  id_ profesor vesa " + clav);
        Tabla1();
    }

//    public void onClick$tabla() {
//      try{ 
//        if (lista.size() > 0) {
//            int id = tabla.getSelectedIndex();    
//            Integer iden = lista.get(id).getIdcursoestudiante();
//            parametro.put("id_curso", iden);
//            Archivo.crearArchivo("curso", iden.toString());
//            Window window = (Window) Executions.createComponents("/eliminarECurso.zul", null, null);
//            window.doModal();
//            consuprofe.detach();
//
//        }
//      } catch(Exception e){
//          
//      }
//
//    }
    public void onClick$buscar() {
        Tabla1b(filtro.getText());
    }

//   
    public void Tabla1b(String curso) {
        if (tabla.getRows() > 0) {
            tabla.getChildren().clear();
        }

        tabla.setRows(7);
        Listhead cabeza = new Listhead();
        Listheader ti1 = new Listheader("Curso");
        ti1.setAlign("center");
        ti1.setWidth("220px");
        Listheader ti2 = new Listheader("Id Alumno");
        ti2.setAlign("center");
        Listheader ti3 = new Listheader("Estudiante");
        ti3.setWidth("280px");
        ti3.setAlign("center");
        Listheader ti4 = new Listheader("Fecha inicio");
        ti4.setAlign("center");
        Listheader ti5 = new Listheader("Fecha fin");
        ti5.setAlign("center");
        Listheader ti6 = new Listheader("Horario");
        ti6.setAlign("center");
        tabla.appendChild(cabeza);
        lista2 = consu.ConsultaCursoEstudiante("cursos", "select * from cursosestudiante where nombre_cursosestudiante LIKE '%" + curso
                + "%' AND estado='ACTIVO' order by nombre_cursosestudiante");
        for (int x = 0; x < lista2.size(); x++) {
            lista = consu.ConsultaCurso("cursos", "select * from cursos where id_curso=" + lista2.get(x).getIdcurso());
            lista4 = consu.ConsultaEstudiante("cursos", "select * from alumnos where id_alumno=" + lista2.get(x).getIdalumno() + " AND estado='ACTIVO'");
            Listitem item = new Listitem();
            Listcell cell = new Listcell(lista2.get(x).getNombrecursosestudiante());
            Listcell cell1 = new Listcell(lista2.get(x).getCedulaestudiante());
            Listcell cell2 = new Listcell(lista4.get(0).getNombre() + " " + lista4.get(0).getApellido());
            Listcell cell3 = new Listcell(lista.get(0).getFecha_inicio());
            Listcell cell4 = new Listcell(lista.get(0).getFecha_fin());
            Listcell cell5 = new Listcell(lista.get(0).getHorario());
            item.appendChild(cell5);
            cabeza.appendChild(ti1);
            cabeza.appendChild(ti2);
            cabeza.appendChild(ti3);
            cabeza.appendChild(ti4);
            cabeza.appendChild(ti5);
            cabeza.appendChild(ti6);
            item.appendChild(cell);
            item.appendChild(cell1);
            item.appendChild(cell2);
            item.appendChild(cell3);
            item.appendChild(cell4);
            item.appendChild(cell5);
            tabla.appendChild(item);
        }
    }

    public void Tabla1() {

        lista2 = consu.ConsultaCursoEstudiante("cursos", "select * from cursosestudiante where id_profesor=" + iden_profesor
                + " AND estado='ACTIVO' order by nombre_cursosestudiante");
        for (int x = 0; x < lista2.size(); x++) {
            lista = consu.ConsultaCurso("cursos", "select * from cursos where id_curso=" + lista2.get(x).getIdcurso());
            lista4 = consu.ConsultaEstudiante("cursos", "select * from alumnos where id_alumno=" + lista2.get(x).getIdalumno() + " AND estado='ACTIVO'");
            Listitem item = new Listitem();
            Listcell cell = new Listcell(lista2.get(x).getNombrecursosestudiante());
            Listcell cell1 = new Listcell(lista2.get(x).getCedulaestudiante());
            Listcell cell2 = new Listcell(lista4.get(0).getNombre() + " " + lista4.get(0).getApellido());
            Listcell cell3 = new Listcell(lista.get(0).getFecha_inicio());
            Listcell cell4 = new Listcell(lista.get(0).getFecha_fin());
            Listcell cell5 = new Listcell(lista.get(0).getHorario());
            item.appendChild(cell);
            item.appendChild(cell1);
            item.appendChild(cell2);
            item.appendChild(cell3);
            item.appendChild(cell4);
            item.appendChild(cell5);
            tabla.appendChild(item);
        }

    }

}
