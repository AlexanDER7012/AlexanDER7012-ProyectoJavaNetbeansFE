package ferreteria.dao;

import ferreteria.tablas.Clientes;
import java.util.List;

public interface IClientesDAO {
    
    public List<Clientes> listarClientes ();
    public boolean agregarClientes (Clientes cliente);
    public String generarIdentificadorCliente(String nombre, String apellido,String telefono);
    public boolean agregarPunto(int id_cliente);
    public Integer obtenerIdPorIdentificacion(String identificacion);
    public Clientes buscarClientes(Integer id_cliente);
    
}
