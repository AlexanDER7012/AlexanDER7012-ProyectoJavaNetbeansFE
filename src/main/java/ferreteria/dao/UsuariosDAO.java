package ferreteria.dao;

import ferreteria.conexion.Conexion;
import ferreteria.tablas.Usuarios;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuariosDAO implements IUsuariosDAO{
    
      @Override
     public List<Usuarios> listarUsuarios(){
        List<Usuarios> usuario = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = Conexion.getConexion();
        String sql = "SELECT * FROM usuarios ORDER BY  id_usuario";
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Usuarios usuarios = new Usuarios();
                usuarios.setId_usuario(rs.getInt("id_usuario"));
                usuarios.setNombre_usuario(rs.getString("nombre_usuario"));
                usuarios.setContrasena_usuario(rs.getString("contrasena"));
                usuario.add(usuarios);
            }
        }catch(Exception e){
            System.out.println("Error al encontrar cada usuario: "+e.getMessage());
        } finally{
            try{
                con.close();
            }catch(Exception e){
                System.out.println("Error al cerrar conexion con la base de datos "+e.getMessage());
            }
        }
        return usuario;
        
    }
    @Override
     public boolean registrarUsuario(Usuarios usuario){
         PreparedStatement ps;
         Connection con = Conexion.getConexion();
         String sql = "INSERT INTO Ferreteria_db.usuarios (nombre_usuario, contrasena) "+" VALUES (?,?) ";
         try{
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNombre_usuario());
            ps.setString(2,usuario.getContrasena_usuario());
            ps.execute();
            
            return true;
            
        }catch(Exception e){
            System.out.println("Error al añadir cada usuario: "+e.getMessage());
        } finally{
            try{
                con.close();
            }catch(Exception e){
                System.out.println("Error al cerrar conexion con la base de datos "+e.getMessage());
            }
        }
         return false;
     }
     
      @Override
     public boolean compararUsuario(String nombre, String contrasena){
         PreparedStatement ps;
         ResultSet rs;
         Connection con = Conexion.getConexion();
         String sql = "SELECT * FROM usuarios WHERE nombre_usuario = ? AND contrasena = ?";
         try{
             ps = con.prepareStatement(sql);
             ps.setString(1, nombre);
             ps.setString(2, contrasena);
             rs = ps.executeQuery();
             return rs.next();
         }catch(Exception e){
             System.out.println("Error al encontrar datos similares"+e.getMessage());
         }finally{
             try{
                 con.close();
             }catch(Exception e){
                 System.out.println("Error al cerrar la conexion a la base de datos");
             }
         }
        
         return false;
     }
    
  
}
