
package ferreteria.dao;

import ferreteria.tablas.Productos;
import java.util.List;


public interface IProductosDAO {
public List<Productos> listarProductosEscasos ();
public List<Productos> listarProductos ();
public boolean agregarProductos(Productos producto);
public boolean eliminarProducto(Productos producto);
public boolean modificarProductos(Productos producto);
public Productos buscarProducto(int numero);
 public boolean restarCantidadProducto(int idProducto, int cantidadVendida);
}
