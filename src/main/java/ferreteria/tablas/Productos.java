
package ferreteria.tablas;

import java.util.Objects;

public class Productos {
    int idProductos;
    String nombreProducto;
    double precio;
    int cantidad;
    int id_marca;
    
    public Productos(){}
    
     public Productos(int idProductos){
         this.idProductos=idProductos;
     }
     
      public Productos(String nombreProducto, double precio, int cantidad, int id_marca){
      this.nombreProducto = nombreProducto;
      this.precio = precio;
      this.cantidad = cantidad;
      this.id_marca= id_marca;
      
      }
      
public Productos(String nombreProducto, double precio, int cantidad){
      this.nombreProducto = nombreProducto;
      this.precio = precio;
      this.cantidad = cantidad;
      
      
      }
public Productos(String nombreProducto, double precio){
      this.nombreProducto = nombreProducto;
      this.precio = precio;
 }

    public Productos(int idProductos, String nombreProducto, double precio, int cantidad, int id_marca) {
        this.idProductos = idProductos;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.id_marca = id_marca;
    }
    
      public Productos(int cantidad, int idProductos) {
        
        this.cantidad = cantidad;
        this.idProductos = idProductos;
    }

    public int getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(int idProductos) {
        this.idProductos = idProductos;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    @Override
    public String toString() {
        return "Productos{" + "idProductos=" + idProductos + ", nombreProducto=" + nombreProducto + ", precio=" + precio + ", cantidad=" + cantidad + ", id_marca=" + id_marca + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.idProductos;
        hash = 83 * hash + Objects.hashCode(this.nombreProducto);
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        hash = 83 * hash + this.cantidad;
        hash = 83 * hash + this.id_marca;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Productos other = (Productos) obj;
        if (this.idProductos != other.idProductos) {
            return false;
        }
        if (Double.doubleToLongBits(this.precio) != Double.doubleToLongBits(other.precio)) {
            return false;
        }
        if (this.cantidad != other.cantidad) {
            return false;
        }
        if (this.id_marca != other.id_marca) {
            return false;
        }
        return Objects.equals(this.nombreProducto, other.nombreProducto);
    }
      
    
     
   
    
    
    
    
    
    
}
