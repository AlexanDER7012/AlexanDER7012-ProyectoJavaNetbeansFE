package ferreteria.dao;

import ferreteria.conexion.Conexion;
import ferreteria.tablas.Marcas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MarcasDAO implements IMarcasDAO {

    @Override
    public List<Marcas> listarAMrcas() {
        List<Marcas> marcas = new ArrayList<>();
        Connection con = Conexion.getConexion();
        ResultSet rs;
        PreparedStatement ps;
        String sql = "SELECT * FROM marcas ORDER BY id_marca";
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Marcas Omarcas = new Marcas(); 
                  Omarcas.setId_marca(rs.getInt("id_marca"));
                Omarcas.setMarca(rs.getString("nombre_marca"));
                marcas.add(Omarcas);
                
            }
        }catch(Exception e){
            System.out.println("Ha ocurrido al ver las marcas"+e.getMessage());
        }finally{
            try{
                
           
                con.close();
                 
        }catch(Exception e){
                System.out.println("Ha ocuurido un error con cerrar la conexion"+e.getMessage());
        }
        
        return marcas;
        
    }
      } 
}
