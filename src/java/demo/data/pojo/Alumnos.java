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
public class Alumnos {

    private Integer idealumno;
    private String cedula;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private String correo;
    private String fechas;
    private String nombre_rol;
    private Integer id_rol;
   private String nombreusuario;

    public Alumnos(Integer idealumno, String cedula, String nombre, String apellido, String telefono, String direccion, String correo, String fechas, String nombre_rol, Integer id_rol, String nombreusuario) {
        this.idealumno = idealumno;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.fechas = fechas;
        this.nombre_rol = nombre_rol;
        this.id_rol = id_rol;
        this.nombreusuario = nombreusuario;
    }

    public Integer getIdealumno() {
        return idealumno;
    }

    public void setIdealumno(Integer idealumno) {
        this.idealumno = idealumno;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFechas() {
        return fechas;
    }

    public void setFechas(String fechas) {
        this.fechas = fechas;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }

    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }

    public Integer getId_rol() {
        return id_rol;
    }

    public void setId_rol(Integer id_rol) {
        this.id_rol = id_rol;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }
    
   
}
