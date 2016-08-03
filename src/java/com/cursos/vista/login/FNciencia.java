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
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

/**
 *
 * @author jtapia
 */
public class FNciencia extends GenericForwardComposer {

    Consultas consu = new Consultas();
    Base dao = new Base();
    Textbox nuevaciencia;
    Window ciencia1;
    Button closeBtn, grabar;
    String codigo = "";
    int rep = 0;

    public void onClick$closeBtn() {
        if (rep > 0) {
            String h = nuevaciencia.getText();
            record(h);
            
        }
       ciencia1.detach();rep=0;
    }

    public void onClick$grabar() {
        String h = nuevaciencia.getText();
      
        if (h != null || !"".equals(h)) {
            nuevaciencia.setText(h.toUpperCase());
             ArrayList<Ciencia> lista= consu.ConsultaCiencia("cursos", "select * from ciencia where nombre_ciencia='"
             +nuevaciencia.getText()+"'");
            if (lista.size() < 1) {
                rep++;
            } else {
                 Messagebox.show(" "+nuevaciencia.getText() + " ! ! " + "\n" + " Ya Existe");
                rep=0;

            }
        } else {
            rep = 0;
            Messagebox.show(" Valor Invàlido!!" + " ! ! " + "\n" + " Ya Existe");
        }
    }

    public void record(String cadena) {
        String camp = "nombre_ciencia,fechas";
        String val = "'" + nuevaciencia.getText() + "','" + Fecha.Fecha() + "'";
        try {
            dao.Guardar("cursos", "ciencia", camp, val);
        } catch (Exception ex) {
            Logger.getLogger(FNciencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
