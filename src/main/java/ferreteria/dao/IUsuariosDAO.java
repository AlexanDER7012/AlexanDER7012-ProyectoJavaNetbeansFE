package ferreteria.dao;

import ferreteria.tablas.Usuarios;
import java.util.List;


public interface IUsuariosDAO {
    public  List<Usuarios> listarUsuarios();
    public boolean registrarUsuario(Usuarios usuario);
    public boolean compararUsuario(String nombre, String contrasena);
}
