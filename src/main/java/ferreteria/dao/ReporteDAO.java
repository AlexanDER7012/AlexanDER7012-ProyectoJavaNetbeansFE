/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ferreteria.dao;

import ferreteria.conexion.Conexion;
import ferreteria.tablas.Productos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReporteDAO {
    
  public boolean enviarReporte(List<Productos> productosEscasos,String enviadoPor){
        Connection con= Conexion.getConexion();
        PreparedStatement ps;
        String sql = "INSERT INTO reportes (id_producto, nombre_producto, cantidad, enviado_por) " +
             "SELECT ?, ?, ?, ? " +
             "WHERE NOT EXISTS (SELECT 1 FROM reportes WHERE id_producto = ? AND estado = 'pendiente')";
        try {
            ps =con.prepareStatement(sql);
           for(Productos p : productosEscasos) {
    ps.setInt(1, p.getIdProductos());
    ps.setString(2, p.getNombreProducto());
    ps.setInt(3, p.getCantidad());
    ps.setString(4, enviadoPor);
    ps.setInt(5, p.getIdProductos());
    ps.addBatch();
}
            ps.executeBatch();
            return true;
        }catch(Exception e) {
            System.out.println("Error al enviar reporte: " + e.getMessage());
        }finally{
            try{ 
                con.close(); 
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexion "+ e.getMessage());
            }
        }
        return false;
    }

    public List<Productos> listarReportesPendientes(){
        List<Productos> productos = new ArrayList<>();
        Connection con=Conexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        String sql= "SELECT id_reporte, id_producto, nombre_producto, cantidad FROM reportes WHERE estado = 'pendiente'";

        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Productos p = new Productos();
                p.setIdProductos(rs.getInt("id_producto"));
                p.setNombreProducto(rs.getString("nombre_producto"));
                p.setCantidad(rs.getInt("cantidad"));
                productos.add(p);
            }
        }catch(Exception e){
            System.out.println("Error al listar reportes: " + e.getMessage());
        }finally{
            try{ 
                con.close(); 
            }catch(Exception e) {
                System.out.println("Error al cerrar la conexion");
            }
        }
        return productos;
    }

    public boolean marcarReporteListo(int idProducto) {
        Connection con = Conexion.getConexion();
        PreparedStatement ps;
        String sql = "UPDATE reportes SET estado = 'listo' WHERE id_producto = ? AND estado = 'pendiente'";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idProducto);
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            System.out.println("Error al marcar reporte como listo: " + e.getMessage());
        } finally {
            try { con.close(); } catch (Exception e) {}
        }
        return false;
    }
    
}
