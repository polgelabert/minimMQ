package modelo;

import javax.ws.rs.Produces;
import java.util.Comparator;

public class Producto {

    public String nombreProducto;
    public String tipoProducto;
    public String descripcionProducto;
    public int numeroVentasProducto;
    public int precioProducto;

    public Producto(String nombreProducto, String tipoProducto, String descripcionProducto, int numeroVentasProducto, int precioProducto){
        this.nombreProducto = nombreProducto;
        this.tipoProducto = tipoProducto;
        this.descripcionProducto = descripcionProducto;
        this.numeroVentasProducto = numeroVentasProducto;
        this.precioProducto = precioProducto;
    }

    public Producto(){}


    public String getNombreProducto() { return nombreProducto; }

    public void setNombreProducto(String nombreProducto) { this.nombreProducto = nombreProducto; }

    public String getTipoProducto() { return tipoProducto; }

    public void setTipoProducto(String tipoProducto) { this.tipoProducto = tipoProducto; }

    public String getDescripcionProducto() { return descripcionProducto; }

    public void setDescripcionProducto(String descripcionProducto) { this.descripcionProducto = descripcionProducto; }

    public int getNumeroVentasProducto() { return numeroVentasProducto; }

    public void setNumeroVentasProducto(int numeroVentasProducto) { this.numeroVentasProducto = numeroVentasProducto; }

    public int getPrecioProducto() { return precioProducto; }

    public void setPrecioProducto(int precioProducto) { this.precioProducto = precioProducto; }


    public class ObjectComparator implements Comparator<Producto> {

        public int compare(Producto p1, Producto p2) {
            //return p1.getPrecioProducto().(p2.getPrecioProducto());
            return 1;
        }

    }


    public boolean objetoEsIgual(Producto o) {

        boolean resp = false;

        if (o.nombreProducto == this.nombreProducto && o.tipoProducto == this.tipoProducto && o.descripcionProducto == this.descripcionProducto && o.numeroVentasProducto == this.numeroVentasProducto && o.precioProducto == this.precioProducto) {
            resp = true;
        }

        return resp;
    }



}
