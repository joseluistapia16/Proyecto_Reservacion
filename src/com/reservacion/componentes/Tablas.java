package com.reservacion.componentes;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class Tablas {
    public static DefaultTableModel VaciarTabla(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        return modelo;
    }
}
