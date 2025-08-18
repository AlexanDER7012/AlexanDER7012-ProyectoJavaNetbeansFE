/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ferreteria.tablas;

import java.sql.Date;
import java.util.Objects;
public class Clientes {
    private int idCliente;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correoElectonico;
    private Date  fechaRegistro;
    private String identificacion;
    private int puntos;
    
    public Clientes (){}

    public Clientes(int idCliente, String nombre, String apellido, String telefono,String correoElectonico, Date fechaRegistro, String identificacion, int puntos) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correoElectonico=correoElectonico;
        this.fechaRegistro = fechaRegistro;
        this.identificacion = identificacion;
        this.puntos = puntos;
    }
    public Clientes( String nombre, String apellido, String telefono,String correoElectonico, Date fechaRegistro, String identificacion, int puntos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correoElectonico=correoElectonico;
        this.fechaRegistro = fechaRegistro;
        this.identificacion = identificacion;
        this.puntos = puntos;
    }
     public Clientes( String nombre, String apellido, String telefono,String correoElectonico, Date fechaRegistro, String identificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correoElectonico=correoElectonico;
        this.fechaRegistro = fechaRegistro;
        this.identificacion = identificacion;
       
    }
     public Clientes( String nombre, String apellido, String telefono,String correoElectonico, Date fechaRegistro) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correoElectonico=correoElectonico;
        this.fechaRegistro = fechaRegistro;
     
       
    }

    public String getCorreoElectonico() {
        return correoElectonico;
    }

    public void setCorreoElectonico(String correoElectonico) {
        this.correoElectonico = correoElectonico;
    }
     

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
   
    public Clientes(int idCliente){
        this.idCliente=idCliente;
    }

    public int getIdCliente() {
        return idCliente;
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

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return "Clientes{" + "idCliente=" + idCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", fechaRegistro=" + fechaRegistro + ", identificacion=" + identificacion + ", puntos=" + puntos + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.idCliente;
        hash = 79 * hash + Objects.hashCode(this.nombre);
        hash = 79 * hash + Objects.hashCode(this.apellido);
        hash = 79 * hash + Objects.hashCode(this.telefono);
        hash = 79 * hash + Objects.hashCode(this.correoElectonico);
        hash = 79 * hash + Objects.hashCode(this.fechaRegistro);
        hash = 79 * hash + Objects.hashCode(this.identificacion);
        hash = 79 * hash + this.puntos;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Clientes other = (Clientes) obj;
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if (this.puntos != other.puntos) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.correoElectonico, other.correoElectonico)) {
            return false;
        }
        if (!Objects.equals(this.identificacion, other.identificacion)) {
            return false;
        }
        return Objects.equals(this.fechaRegistro, other.fechaRegistro);
    }

    
    
    
    
    
}
