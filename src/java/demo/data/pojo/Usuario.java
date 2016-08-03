/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.data.pojo;

/**
 *
 * @author mayra
 */
public class Usuario {

    private Integer idusuario;
    private String nombrerol;
    private Integer idrol;
    private String cedula;
    private String nombreusuario;
    private String apellido;
    private String telefono;
    private String direccion;
    private String Correo;
    private String fecha;
    private String usuario;
    private String clave;

    public Usuario(Integer idusuario, String nombrerol, Integer idrol, String cedula, String nombreusuario, String apellido, String telefono, String direccion, String Correo, String fecha, String usuario, String clave) {
        this.idusuario = idusuario;
        this.nombrerol = nombrerol;
        this.idrol = idrol;
        this.cedula = cedula;
        this.nombreusuario = nombreusuario;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.Correo = Correo;
        this.fecha = fecha;
        this.usuario = usuario;
        this.clave = clave;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombrerol() {
        return nombrerol;
    }

    public void setNombrerol(String nombrerol) {
        this.nombrerol = nombrerol;
    }

    public Integer getIdrol() {
        return idrol;
    }

    public void setIdrol(Integer idrol) {
        this.idrol = idrol;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
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
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    
}
