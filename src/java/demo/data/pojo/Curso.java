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
public class Curso {

    private Integer id_curso;
    private Integer id_ciencia;
    private String nombre_curso;
    private Integer id_materia;
    private Integer id_profesor;
    private double valor;
    private String fecha_inicio;
    private String fecha_fin;
    private String horario;

    public Curso(Integer id_curso, Integer id_ciencia, String nombre_curso, Integer id_materia, Integer id_profesor, double valor, String fecha_inicio, String fecha_fin, String horario) {
        this.id_curso = id_curso;
        this.id_ciencia = id_ciencia;
        this.nombre_curso = nombre_curso;
        this.id_materia = id_materia;
        this.id_profesor = id_profesor;
        this.valor = valor;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.horario = horario;
    }

    public Integer getId_curso() {
        return id_curso;
    }

    public void setId_curso(Integer id_curso) {
        this.id_curso = id_curso;
    }

    public Integer getId_ciencia() {
        return id_ciencia;
    }

    public void setId_ciencia(Integer id_ciencia) {
        this.id_ciencia = id_ciencia;
    }

    public String getNombre_curso() {
        return nombre_curso;
    }

    public void setNombre_curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }

    public Integer getId_materia() {
        return id_materia;
    }

    public void setId_materia(Integer id_materia) {
        this.id_materia = id_materia;
    }

    public Integer getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(Integer id_profesor) {
        this.id_profesor = id_profesor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    
    
}
