package ferreteria.tablas;

import java.sql.Timestamp;
import java.util.Objects;

public class Ventas {
    private int idVenta;
    private Integer idCliente;
     private Timestamp fechaHora;
    private double totalVentas;

    public Ventas(){}
    
    public Ventas(int idVenta, Integer idCliente, Timestamp fechaHora, double totalVentas) {
        this.idVenta = idVenta;
        this.idCliente = idCliente;
        this.fechaHora = fechaHora;
        this.totalVentas = totalVentas;
    }

    public Ventas(Integer idCliente, Timestamp fechaHora, double totalVentas) {
        this.idCliente = idCliente;
        this.fechaHora = fechaHora;
        this.totalVentas = totalVentas;
    }
    

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
    }

    public double getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(double totalVentas) {
        this.totalVentas = totalVentas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.idVenta;
        hash = 37 * hash + this.idCliente;
        hash = 37 * hash + Objects.hashCode(this.fechaHora);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.totalVentas) ^ (Double.doubleToLongBits(this.totalVentas) >>> 32));
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
        final Ventas other = (Ventas) obj;
        if (this.idVenta != other.idVenta) {
            return false;
        }
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if (Double.doubleToLongBits(this.totalVentas) != Double.doubleToLongBits(other.totalVentas)) {
            return false;
        }
        return Objects.equals(this.fechaHora, other.fechaHora);
    }

    @Override
    public String toString() {
        return "Ventas{" + "idVenta=" + idVenta + ", idCliente=" + idCliente + ", fechaHora=" + fechaHora + ", totalVentas=" + totalVentas + '}';
    }
    
    
}
