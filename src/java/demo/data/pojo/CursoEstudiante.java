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
public class CursoEstudiante {
    private Integer idcursoestudiante;
    private Integer idcurso;
    private Integer idalumno;
    private String estado;
    private String nombrecursosestudiante;
    private String cedulaestudiante;
    private Integer idprofesor;

    public CursoEstudiante(Integer idcursoestudiante, Integer idcurso, Integer idalumno, String estado, String nombrecursosestudiante, String cedulaestudiante, Integer idprofesor) {
        this.idcursoestudiante = idcursoestudiante;
        this.idcurso = idcurso;
        this.idalumno = idalumno;
        this.estado = estado;
        this.nombrecursosestudiante = nombrecursosestudiante;
        this.cedulaestudiante = cedulaestudiante;
        this.idprofesor = idprofesor;
    }

    public Integer getIdcursoestudiante() {
        return idcursoestudiante;
    }

    public void setIdcursoestudiante(Integer idcursoestudiante) {
        this.idcursoestudiante = idcursoestudiante;
    }

    public Integer getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(Integer idcurso) {
        this.idcurso = idcurso;
    }

    public Integer getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(Integer idalumno) {
        this.idalumno = idalumno;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombrecursosestudiante() {
        return nombrecursosestudiante;
    }

    public void setNombrecursosestudiante(String nombrecursosestudiante) {
        this.nombrecursosestudiante = nombrecursosestudiante;
    }

    public String getCedulaestudiante() {
        return cedulaestudiante;
    }

    public void setCedulaestudiante(String cedulaestudiante) {
        this.cedulaestudiante = cedulaestudiante;
    }

    public Integer getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(Integer idprofesor) {
        this.idprofesor = idprofesor;
    }

    
    
    
}
