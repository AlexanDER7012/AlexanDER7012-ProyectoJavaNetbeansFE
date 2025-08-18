package ferreteria.tablas;

import java.util.Objects;

public class Marcas {
    int id_marca;
    String marca;
    
    public Marcas(){}
    
    public Marcas(int id_marca){
        this.id_marca=id_marca;
    }
    public Marcas(int id_marca, String marca){
        this.id_marca=id_marca;
        this.marca=marca;
    }

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Marcas{" + "id_marca=" + id_marca + ", marca=" + marca + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.id_marca;
        hash = 61 * hash + Objects.hashCode(this.marca);
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
        final Marcas other = (Marcas) obj;
        if (this.id_marca != other.id_marca) {
            return false;
        }
        return Objects.equals(this.marca, other.marca);
    }
    
    
    
}
