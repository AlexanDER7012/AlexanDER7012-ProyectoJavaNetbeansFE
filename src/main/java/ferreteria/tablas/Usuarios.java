package ferreteria.tablas;

import java.util.Objects;

public class Usuarios {
private  int id_usuario;
private String nombre_usuario;
private String contrasena_usuario;

public Usuarios(){}

public Usuarios(int id_usuario){
    this.id_usuario=id_usuario;
}
public Usuarios (String nombre_usuario, String contrasena_usuario ){
    this.nombre_usuario = nombre_usuario;
    this.contrasena_usuario = contrasena_usuario;
}

public Usuarios (int id_usuario,String nombre_usuario, String contrasena_usuario){
    this.id_usuario=id_usuario;
     this.nombre_usuario = nombre_usuario;
    this.contrasena_usuario = contrasena_usuario;
}
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }


    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContrasena_usuario() {
        return contrasena_usuario;
    }

    public void setContrasena_usuario(String contrasena_usuario) {
        this.contrasena_usuario = contrasena_usuario;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "id_usuario=" + id_usuario + ", nombre_usuario=" + nombre_usuario + ", contrasena_usuario=" + contrasena_usuario + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.id_usuario;
        hash = 31 * hash + Objects.hashCode(this.nombre_usuario);
        hash = 31 * hash + Objects.hashCode(this.contrasena_usuario);
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
        final Usuarios other = (Usuarios) obj;
        if (this.id_usuario != other.id_usuario) {
            return false;
        }
        if (!Objects.equals(this.nombre_usuario, other.nombre_usuario)) {
            return false;
        }
        return Objects.equals(this.contrasena_usuario, other.contrasena_usuario);
    }

    





}
