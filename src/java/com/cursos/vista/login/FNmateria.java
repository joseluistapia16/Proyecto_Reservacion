/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cursos.vista.login;

import com.curso.componentes.Fecha;
import com.cursos.dao.Base;
import com.cursos.dao.Consultas;
import demo.data.pojo.Ciencia;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

/**
 *
 * @author jtapia
 */
public class FNmateria extends GenericForwardComposer {

    Consultas consu = new Consultas();
    Base dao = new Base();
    Textbox nuevamateria;
    Window materia1;
    Combobox combo;
    Button closeBtn, grabar;
    String codigo = "";
    int rep = 0;
    Integer op = 0;
    ArrayList<Ciencia> lista = consu.ConsultaCiencia("cursos", "select * from ciencia order by nombre_ciencia");

    public void onClick$closeBtn() {
        if (rep > 0) {
            String h = nuevamateria.getText();
            record(h);

        }
        materia1.detach();
    }

    public void onClick$combo() {
        llenarCombo();
    }

    public void onOpen$combo() {
        llenarCombo();
    }

    public void onChange$combo() {
        op = lista.get(combo.getSelectedIndex()).getIdciencia();
    }

    public void onClick$grabar() {
        String n=combo.getText(),h = nuevamateria.getText();
        
        
            if (h != null || !"".equals(h) ||  "".equals(n)) {
                nuevamateria.setText(h.toUpperCase());
                if (consu.ConsultaMateria("cursos", "select * from materia where nombre_materia='"
                        + nuevamateria.getText() + "' and id_ciencia='"+op+"'").size() > 0) {
                    Messagebox.show(nuevamateria.getText() + " ! ! " + "\n" + " Ya Existe");
                    rep = 0;
                } else {
                    rep++;

                }
            } else {
                Messagebox.show("Valores Inválidos" + " ! ! " + "\n");
                rep = 0;
            }
        
    }

    public void record(String cadena) {

        String camp = "id_ciencia,nombre_materia,fechas";
        String val = "'" + op + "','" + nuevamateria.getText() + "','" + Fecha.Fecha() + "'";
        try {
            dao.Guardar("cursos", "materia", camp, val);
        } catch (Exception ex) {
            Logger.getLogger(FNmateria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void llenarCombo() {

        if (combo.getItemCount() > 0) {
            combo.getChildren().clear();
        }

        if (lista.size() > 0) {
            Comboitem cmb = null;
            for (int i = 0; i < lista.size(); i++) {
                cmb = new Comboitem(lista.get(i).getNombreciencia());
                combo.appendChild(cmb);
            }
        }
    }
}
