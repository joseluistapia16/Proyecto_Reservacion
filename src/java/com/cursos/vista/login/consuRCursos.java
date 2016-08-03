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

public class consuRCursos extends GenericForwardComposer {

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
    String id_profesor;

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
        System.out.println(lista.size() + "  id_ profesor vesa " + clav);
        Tabla1();
    }

    public void onClick$buscar() {
        Tabla1b(filtro.getText());
    }

    public void Tabla1() {
        lista= consu.ConsultaCurso("cursos","select * from cursos where id_profesor="+lista3.get(0).getIdprofesor()+" AND estado='ACTIVO'");       
        tabla.setRows(7);
        for (int i = 0; i < lista.size(); i++) {            
            Listitem item = new Listitem();
            Listcell cell = new Listcell(lista.get(i).getNombre_curso());
            Listcell cell1 = new Listcell(lista.get(i).getFecha_inicio());
            Listcell cell2 = new Listcell(lista.get(i).getFecha_fin());
            Listcell cell3 = new Listcell("" + lista.get(i).getValor());
            Listcell cell4 = new Listcell(lista.get(i).getHorario());
            item.appendChild(cell);
            item.appendChild(cell1);
            item.appendChild(cell2);
            item.appendChild(cell3);
            item.appendChild(cell4);
            tabla.appendChild(item);
        }
    }

    public void Tabla1b(String curso) {
        if (tabla.getRows() > 0) {
            tabla.getChildren().clear();
        }

        lista = consu.ConsultaCurso("Cursos", "Select * from cursosestudiante where nombre_curso LIKE '%" + curso + "%' and estado='ACTIVO' and id_profesor="+lista3.get(0).getIdprofesor()); // aqui falta corregir   
        tabla.setRows(7);

        Listhead cabeza = new Listhead();
        Listheader ti = new Listheader("Curso");
        ti.setAlign("center");
        Listheader to = new Listheader("Fecha Inicio");
        to.setWidth("120px");
        to.setAlign("center");
        Listheader to1 = new Listheader("Fecha Fin");
        to1.setWidth("120px");
        to1.setAlign("center");
        Listheader to2 = new Listheader("Valor");
        to2.setWidth("110px");
        to2.setAlign("center");
        Listheader to3 = new Listheader("Horario");
        to3.setAlign("center");
        tabla.appendChild(cabeza);
        for (int i = 0; i < lista.size(); i++) {
            Listitem item = new Listitem();
            Listcell cell = new Listcell(lista.get(0).getNombre_curso());
            Listcell cell1 = new Listcell(lista.get(0).getFecha_inicio());
            Listcell cell2 = new Listcell(lista.get(0).getFecha_fin());
            Listcell cell3 = new Listcell("" + lista.get(0).getValor());
            Listcell cell4 = new Listcell(lista.get(0).getHorario());
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
