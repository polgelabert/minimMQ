package modelo;

import controlador.exceptions.ObjetoNoEncontradoException;
import controlador.exceptions.UsuarioSinObjetosException;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


public class Usuario {

    public String nombre;
    public String password;
    public int nivel;
    public int ataque;
    public int defensa;
    public int resistencia;
    public List<Producto> listaPedidosEntregados;
    public List<Queue> listaPedidosPedidos;


    public Usuario(){}

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public int getNivel() { return nivel; }

    public void setNivel(int nivel) { this.nivel = nivel; }

    public int getAtaque() { return ataque; }

    public void setAtaque(int ataque) { this.ataque = ataque; }

    public int getDefensa() { return defensa; }

    public void setDefensa(int defensa) { this.defensa = defensa; }

    public int getResistencia() { return resistencia; }

    public void setResistencia(int resistencia) { this.resistencia = resistencia; }

    public List<Producto> getListaPedidosEntregados() { return listaPedidosEntregados; }

    public void setListaPedidosEntregados(List<Producto> listaPedidosEntregados) { this.listaPedidosEntregados = listaPedidosEntregados; }

    public List<Queue> getListaPedidosPedidos() { return listaPedidosPedidos; }

    public void setListaPedidosPedidos(List<Queue> listaPedidosPedidos) { this.listaPedidosPedidos = listaPedidosPedidos; }





    @Override
    public String toString() {
        return "modelo.Usuario [nombre=" + nombre + ", password=" + password + ", nivel=" + nivel + ", ataque=" + ataque + ", defensa=" + defensa + ", resistencia=" + resistencia + "]";
    }



    public Usuario(String nombre, String password, int nivel, int ataque, int defensa, int resistencia, List<Producto> listaPedidosEntregados) {
        this.nombre = nombre;
        this.password = password;
        this.nivel = nivel;
        this.ataque = ataque;
        this.defensa = defensa;
        this.resistencia = resistencia;
        this.listaPedidosEntregados = listaPedidosEntregados;
    }


    public Usuario(String nombre, String password, int nivel, int ataque, int defensa, int resistencia) {
        this(nombre,password, nivel, ataque, defensa, resistencia, new ArrayList<Producto>());
    }




    public boolean usuarioEsIgual(Usuario player) {

        if (player.nombre == this.nombre && player.password == this.password && player.nivel == this.nivel && player.ataque == this.ataque && player.defensa == this.defensa && player.resistencia == this.resistencia) {

            for(Producto o : player.listaPedidosEntregados) {
                if (o.nombreProducto == this.listaPedidosEntregados.get(0).nombreProducto && o.tipoProducto == this.listaPedidosEntregados.get(0).tipoProducto && o.descripcionProducto == this.listaPedidosEntregados.get(0).descripcionProducto && o.numeroVentasProducto == this.listaPedidosEntregados.get(0).numeroVentasProducto && o.precioProducto == this.listaPedidosEntregados.get(0).precioProducto) return true;
            }
            return false;

        } else {
            return false;
        }
    }

    public void modificarUsuario(Usuario user) {

            this.nombre = user.nombre;
            this.password = user.password;
            this.nivel = user.nivel;
            this.ataque = user.ataque;
            this.defensa = user.defensa;
            this.resistencia = user.resistencia;
    }

    public boolean listaEsIgual (List<Producto> lobj_consult){

        boolean resp = false;
        int m = 0;
        for (int n = 0; n< lobj_consult.size(); n++) {

            if (lobj_consult.get(m).nombreProducto == this.listaPedidosEntregados.get(m).nombreProducto && lobj_consult.get(m).tipoProducto == this.listaPedidosEntregados.get(m).tipoProducto && lobj_consult.get(m).descripcionProducto == this.listaPedidosEntregados.get(m).descripcionProducto && lobj_consult.get(m).numeroVentasProducto == this.listaPedidosEntregados.get(m).numeroVentasProducto && lobj_consult.get(m).precioProducto == this.listaPedidosEntregados.get(m).precioProducto) {
                resp = true;
            } else {
                m = m+1;
            }
        }

        return resp;
    }

    public void insertarObjeto(Producto o) {
        this.listaPedidosEntregados.add(o);
    }

    public Producto getObjeto(String nombreObjeto) throws UsuarioSinObjetosException, ObjetoNoEncontradoException {

        for (Producto o: this.listaPedidosEntregados) {
            if (o.nombreProducto.equals(nombreObjeto)) {
                return o;
            }
        }

        if (this.listaPedidosEntregados.size() != 0) throw new ObjetoNoEncontradoException();
        throw new UsuarioSinObjetosException();
    }

    public List<Producto> getListaObjetos(String nombre) {

        return this.listaPedidosEntregados;
    }
}