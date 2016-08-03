/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.data.pojo;

/**
 *
 * @author TapiaSoftware
 */
public class Materia {

    private Integer idmateria; 
    private Integer idciencia;
    private String nombremateria;
    private String fechas;

    public Materia(Integer idmateria, Integer idciencia, String nombremateria, String fechas) {
        this.idmateria = idmateria;
        this.idciencia = idciencia;
        this.nombremateria = nombremateria;
        this.fechas = fechas;
    }

    public Integer getIdmateria() {
        return idmateria;
    }

    public void setIdmateria(Integer idmateria) {
        this.idmateria = idmateria;
    }

    public Integer getIdciencia() {
        return idciencia;
    }

    public void setIdciencia(Integer idciencia) {
        this.idciencia = idciencia;
    }

    public String getNombremateria() {
        return nombremateria;
    }

    public void setNombremateria(String nombremateria) {
        this.nombremateria = nombremateria;
    }

    public String getFechas() {
        return fechas;
    }

    public void setFechas(String fechas) {
        this.fechas = fechas;
    }

    
    

}