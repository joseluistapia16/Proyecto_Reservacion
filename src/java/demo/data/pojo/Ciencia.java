/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jtapia
 */
package demo.data.pojo;

public class Ciencia {

    private Integer idciencia;  
    private String nombreciencia;
    private String fechas;

    public Ciencia(Integer idciencia, String nombreciencia, String fechas) {
        this.idciencia = idciencia;
        this.nombreciencia = nombreciencia;
        this.fechas = fechas;
    }

    public Integer getIdciencia() {
        return idciencia;
    }

    public void setIdciencia(Integer idciencia) {
        this.idciencia = idciencia;
    }

    public String getNombreciencia() {
        return nombreciencia;
    }

    public void setNombreciencia(String nombreciencia) {
        this.nombreciencia = nombreciencia;
    }

    public String getFechas() {
        return fechas;
    }

    public void setFechas(String fechas) {
        this.fechas = fechas;
    }

     
    
     
}
