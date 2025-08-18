/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ferreteria.dao;

import ferreteria.tablas.Ventas;
import java.util.List;

/**
 *
 * @author ERICK PALOMO LAP
 */
public interface IVentasDAO {
    public List<Ventas> listarVentas();
    public boolean agregarVentas(Ventas ventas);
    
    
}
