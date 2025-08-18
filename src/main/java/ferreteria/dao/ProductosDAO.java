
package ferreteria.dao;
import ferreteria.conexion.Conexion;
import ferreteria.tablas.Productos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProductosDAO implements IProductosDAO{
    
    public List<Productos> listarProductos (){
        List<Productos> productos = new ArrayList<>();
     Connection con = Conexion.getConexion();
     PreparedStatement ps;
     ResultSet rs;
     String sql = "SELECT * FROM productos ORDER BY id_producto";
     try {
         
         ps = con.prepareStatement(sql);
         rs = ps.executeQuery();
         while(rs.next()){
             Productos producto = new Productos();
             producto.setIdProductos(rs.getInt("id_producto"));
             producto.setNombreProducto(rs.getString("nombre_producto"));
             producto.setPrecio(rs.getDouble("precio"));
             producto.setCantidad(rs.getInt("cantidad"));
             producto.setId_marca(rs.getInt("id_marca"));
             productos.add(producto);
             
             
         }
     }catch(Exception e){
         System.out.println("Error al encontrar los resultados de los porductos "+ e.getMessage());
     }finally{
         try{
             con.close();
         }catch(Exception e){
             System.out.println("Error al cerrar la conexion"+e.getMessage());
         }
     }
     
        
        return productos;
    }

    @Override
    public boolean agregarProductos(Productos producto) {
        Connection con = Conexion.getConexion();
        PreparedStatement ps;
        
        String sql = "INSERT INTO productos (nombre_producto,precio,cantidad,id_marca)"+ " VALUES(?, ?, ?, ?)";
        try {
         ps = con.prepareStatement(sql);
         ps.setString(1, producto.getNombreProducto());
         ps.setDouble(2, producto.getPrecio());
         ps.setInt(3, producto.getCantidad());
          ps.setInt(4, producto.getId_marca());
         
         ps.execute();
        
             return true;
         
     }catch(Exception e){
         System.out.println("Error al encontrar los resultados de los porductos "+ e.getMessage());
     }finally{
         try{
             con.close();
         }catch(Exception e){
             System.out.println("Error al cerrar la conexion"+e.getMessage());
         }
     }
        
       return false;
    }

    @Override
    public boolean eliminarProducto(Productos producto) {
        PreparedStatement ps;
        Connection con = Conexion.getConexion();
        String sql = "DELETE FROM productos WHERE id_producto = ?";
          try {
         ps = con.prepareStatement(sql);
         ps.setInt(1, producto.getIdProductos());
         int retornar = ps.executeUpdate();
         return retornar>0;
     }catch(Exception e){
         System.out.println("Error al encontrar los resultados de los porductos "+ e.getMessage());
     }finally{
         try{
             con.close();
         }catch(Exception e){
             System.out.println("Error al cerrar la conexion"+e.getMessage());
         }
     }
        
        
        return false;
    }

    @Override
    public boolean modificarProductos(Productos producto) {
         PreparedStatement ps;
        Connection con = Conexion.getConexion();
        String sql = "UPDATE productos SET cantidad= cantidad + ? "+" WHERE id_producto=?";
        
          try {
        ps = con.prepareStatement(sql);
     
         ps.setInt(1, producto.getCantidad());
          ps.setInt(2, producto.getIdProductos());
         int retornar = ps.executeUpdate();
         return retornar>0;
     }catch(Exception e){
         System.out.println("Error al encontrar los resultados de los porductos "+ e.getMessage());
     }finally{
         try{
             con.close();
         }catch(Exception e){
             System.out.println("Error al cerrar la conexion"+e.getMessage());
         }
     }
        return false;
    }
    
    @Override
    public Productos buscarProducto(int numero){
  
        PreparedStatement ps;
        ResultSet rs;
        Connection con = Conexion.getConexion();
        String sql = "SELECT nombre_producto,precio FROM productos WHERE id_producto = ? ";
        Productos productos = null;
          try {
         ps = con.prepareCall(sql);
         ps.setInt(1, numero);
           rs = ps.executeQuery();
            while(rs.next()){
                productos = new Productos();
                productos.setNombreProducto(rs.getString("nombre_producto"));
                productos.setPrecio(rs.getDouble("precio"));
                
                
            }
     }catch(Exception e){
         System.out.println("Error al encontrar los resultados de los productos "+ e.getMessage());
     }finally{
         try{
             con.close();
         }catch(Exception e){
             System.out.println("Error al cerrar la conexion"+e.getMessage());
         }
     }
        return productos;
    
    }
    @Override
    public boolean restarCantidadProducto(int idProducto, int cantidadVendida) {
    Connection con = Conexion.getConexion();
    PreparedStatement ps;
    String sql = "UPDATE productos SET cantidad = cantidad - ? WHERE id_producto = ? AND cantidad >= ?";

    try{
        ps = con.prepareStatement(sql);
        ps.setInt(1, cantidadVendida); 
        ps.setInt(2, idProducto);  
        ps.setInt(3, cantidadVendida);

        int filasAfectadas = ps.executeUpdate();
        return filasAfectadas > 0;
    }catch(Exception e){
        System.out.println("Error al restar cantidad del producto: " + e.getMessage());
    }finally{
        try{
            con.close();
        }catch(Exception e){
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
    return false;
}

    @Override
    public List<Productos> listarProductosEscasos() {
        List<Productos> productos= new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = Conexion.getConexion();
        String sql = "SELECT * FROM productos WHERE cantidad <= 5";
        try {
            
             ps = con.prepareStatement(sql);
         rs = ps.executeQuery();
         while(rs.next()){
             Productos producto = new Productos();
             producto.setIdProductos(rs.getInt("id_producto"));
             producto.setNombreProducto(rs.getString("nombre_producto"));
             producto.setPrecio(rs.getDouble("precio"));
             producto.setCantidad(rs.getInt("cantidad"));
             producto.setId_marca(rs.getInt("id_marca"));
             productos.add(producto);
             
             
         }
            
            }catch(Exception e){
                    System.out.println("Error al encontrar los menores" + e.getMessage());
                    }finally{
            try{
                con.close();
                
            }catch(Exception e){
                System.out.println("Error al cerrar la conexion " +e.getMessage());
            }
        }
        return productos;    
        
    }

}
