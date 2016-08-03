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
import demo.data.pojo.Profesor;
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

public class CProfesor extends GenericForwardComposer {

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
    List<Profesor> lista = new ArrayList<Profesor>();

    public void onClick$closeBtn() {
        consuprofe.detach();
    }

    public void onClick$tabla() {
        try {
            if (lista.size() > 0) {
                int id = tabla.getSelectedIndex();
                Integer iden = lista.get(id).getIdprofesor();
                parametro.put("id_profesor", iden);
                Archivo.crearArchivo("curso", iden.toString());
                Window window = (Window) Executions.createComponents("/EditarProfesor.zul", null, null);
                window.doModal();
                consuprofe.detach();
            }
        } catch (Exception e) {

        }
    }

    public void onClick$buscar() {
        Tabla1b(filtro.getText());
    }

    public void onCreate$consuprofe() {  // Ejecuta los procesos al arrancar la pagina

        Tabla1();

    }

    public void Tabla1() {

        lista = consu.ConsultaProfesor("cursos", "select * from profesor WHERE estado='ACTIVO' order by nombre_profesor");// aqui falta corregir   
        tabla.setRows(7);
        for (int i = 0; i < lista.size(); i++) {
            Listitem item = new Listitem();
            Listcell cell = new Listcell(lista.get(i).getCedula());
            Listcell cell1 = new Listcell(lista.get(i).getNombreprofesor() + " " + lista.get(i).getApellido());
            item.appendChild(cell);
            item.appendChild(cell1);
            tabla.appendChild(item);
        }
    }

    public void Tabla1b(String cedula) {
        if (tabla.getRows() > 0) {
            tabla.getChildren().clear();
        }

        lista = consu.ConsultaProfesor("Cursos", "Select * from profesor where cedula LIKE '%" + cedula + "%' AND estado='ACTIVO' order by nombre_profesor"); // aqui falta corregir   
        tabla.setRows(7);
        Listhead cabeza = new Listhead();
        Listheader ti = new Listheader("Cedula");
        ti.setWidth("100px");
        Listheader to = new Listheader("Nombre");
        tabla.appendChild(cabeza);
        for (int i = 0; i < lista.size(); i++) {
            Listitem item = new Listitem();
            Listcell cell = new Listcell(lista.get(i).getCedula());
            Listcell cell1 = new Listcell(lista.get(i).getNombreprofesor() + " " + lista.get(i).getApellido());
            cabeza.appendChild(ti);
            cabeza.appendChild(to);
            item.appendChild(cell);
            item.appendChild(cell1);
            tabla.appendChild(item);
        }
    }

}
