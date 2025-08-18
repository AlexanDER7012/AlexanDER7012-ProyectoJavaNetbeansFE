/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ferreteria.dao;

import ferreteria.conexion.Conexion;
import ferreteria.tablas.Ventas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ERICK PALOMO LAP
 */
public class VentasDAO implements IVentasDAO{

    @Override
    public List<Ventas> listarVentas() {
        List<Ventas> ventas = new ArrayList<>();
        Connection con = Conexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        String sql = "SELECT * FROM ventas ORDER BY id_venta";
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){
                Ventas venta = new Ventas();
                venta.setIdVenta(rs.getInt("id_venta"));
                venta.setIdCliente(rs.getInt("id_cliente"));
                venta.setFechaHora(rs.getTimestamp("fecha_venta"));
                venta.setTotalVentas(rs.getDouble("total"));
                ventas.add(venta);
            }
        }catch(Exception e) {
            System.out.println("Error al listar ventas: " + e.getMessage());
        }finally{
            try {
                con.close();
            }catch(Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        return ventas;
            }

    @Override
    public boolean agregarVentas(Ventas ventas) {
        Connection con = Conexion.getConexion();
        PreparedStatement ps;
        String sql = "INSERT INTO ventas (id_cliente, fecha_venta, total) VALUES (?, ?, ?)";

        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, ventas.getIdCliente());
            ps.setTimestamp(2, ventas.getFechaHora());
            ps.setDouble(3, ventas.getTotalVentas());
            ps.execute();
            return true;
        }catch (Exception e) {
            System.out.println("Error al agregar venta: " + e.getMessage());
        }finally{
            try{
                con.close();
            }catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        return false;
    }
          }
    

