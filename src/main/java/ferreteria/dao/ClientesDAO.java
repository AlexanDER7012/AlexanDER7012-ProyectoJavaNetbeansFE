/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ferreteria.dao;

import ferreteria.conexion.Conexion;
import ferreteria.tablas.Clientes;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author ERICK PALOMO LAP
 */
public class ClientesDAO implements IClientesDAO{

    @Override
    public List<Clientes> listarClientes() {
        List<Clientes> clientes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = Conexion.getConexion();
        String sql = "SELECT * FROM clientes ORDER BY id_cliente";
        try{
          ps = con.prepareCall(sql);
          rs = ps.executeQuery();
            while(rs.next()){
                Clientes ClienteO = new Clientes(); 
                ClienteO.setIdCliente(rs.getInt("id_cliente"));
                ClienteO.setNombre(rs.getString("nombre"));
                ClienteO.setApellido(rs.getString("apellido"));
                ClienteO.setTelefono(rs.getString("telefono"));
                ClienteO.setCorreoElectonico(rs.getString("correoElectronico"));
                ClienteO.setFechaRegistro(rs.getDate("fecha_registro"));
                ClienteO.setIdentificacion(rs.getString("identificacion"));
                ClienteO.setPuntos(rs.getInt("puntos"));
                clientes.add(ClienteO);
                
            }
            
        }catch(Exception e){
            System.out.println("Ocurrio un error "+e);
        }finally{
            try{
                con.close();
            }catch(Exception e){
                System.out.println("Error al cerrar conexion "+e);
            }
        }
        return clientes;
    }

    @Override
    public boolean agregarClientes(Clientes cliente) {
        Connection con = Conexion.getConexion();
        PreparedStatement ps;
        
        String sql = "INSERT INTO clientes (nombre, apellido, telefono, correoElectronico, fecha_registro, identificacion, puntos) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
         ps = con.prepareStatement(sql);
         ps.setString(1, cliente.getNombre());
         ps.setString(2, cliente.getApellido());
         ps.setString(3, cliente.getTelefono());
         ps.setString(4,cliente.getCorreoElectonico());
          ps.setDate(5, cliente.getFechaRegistro());
          ps.setString(6, cliente.getIdentificacion());
         ps.setInt(7,0);
         ps.execute();
        
             return true;
         
     }catch(Exception e){
         System.out.println("Error al insertar los resultados de los clientes "+ e.getMessage());
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
    public String generarIdentificadorCliente(String nombre, String apellido, String telefono) {
        
        Random numeroR = new Random();

        var subTelefono =telefono.substring(4);
        var subNombre =nombre.substring(0,2);
        var subApellido =apellido.substring(0,2);
        
        var Numero = numeroR.nextInt(10000);
        String numeroFormateado = String.format("%03d", Numero);

        var ID = subNombre+subApellido+subTelefono;
        ID = ID.toUpperCase();
        var IDcompleto = ID+numeroFormateado;
       
  
        return IDcompleto;

    }
    @Override
    public boolean agregarPunto(int id_cliente) {
    Connection con = Conexion.getConexion();
    PreparedStatement ps;
    String sql = "UPDATE clientes SET puntos = puntos + 1 WHERE id_cliente = ?";
    try {
        ps = con.prepareStatement(sql);
        ps.setInt(1, id_cliente);
        int filasAfectadas = ps.executeUpdate();
        return filasAfectadas > 0; 
    }catch (Exception e) {
        System.out.println("Error al agregar punto: " + e.getMessage());
    }finally {
        try {
            con.close();
        }catch (Exception e) {
            System.out.println("Error al cerrar conexión: " + e.getMessage());
        }
    }
    return false;
}
@Override
    public Integer obtenerIdPorIdentificacion(String identificacion) {
       Connection con = Conexion.getConexion();
       PreparedStatement ps;
       ResultSet rs;
       String sql = "SELECT id_cliente FROM clientes WHERE identificacion = ?";
       try {
       ps = con.prepareStatement(sql);
        ps.setString(1, identificacion);
       rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt("id_cliente");
        }
    }catch (Exception e) {
        System.out.println("Error al buscar cliente: " + e.getMessage());
    }finally {
        try{
            con.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar conexión: " + e.getMessage());
        }
    }
    return null; 
}

    
    @Override
    public Clientes buscarClientes(Integer idCliente) {
        Connection con = Conexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        String sql = "SELECT nombre, apellido, telefono, correoElectronico, fecha_registro FROM clientes WHERE id_cliente = ?";
        try{
            ps = con.prepareCall(sql);
            ps.setInt(1, idCliente);
            rs = ps.executeQuery();
            if (rs.next()) {
            Clientes cliente = new Clientes();
            
            cliente.setNombre(rs.getString("nombre"));
            cliente.setApellido(rs.getString("apellido"));
            cliente.setTelefono(rs.getString("telefono"));
            cliente.setCorreoElectonico(rs.getString("correoElectronico"));
            cliente.setFechaRegistro(rs.getDate("fecha_registro"));
            
          
            return cliente;
        }
        }catch(Exception e){
            System.out.println("No se pudo encontrar el cliente "+ e);
        }finally{
            try{
                con.close();
            }catch(Exception e){
                System.out.println("No se pudo cerrar la conexion "+ e);
            }
        }
        
        return null;
    }
    

    }
    

