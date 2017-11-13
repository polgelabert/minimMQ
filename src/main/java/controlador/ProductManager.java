package controlador;

import controlador.exceptions.*;
import modelo.*;

import java.util.List;
import java.util.Queue;

public interface ProductManager {


    public List<Producto> listaOrdenadaAscPrecio ();

    public boolean realizarPedido (String nombreUsuario, List<Producto> listProductos) throws UsuarioNoExisteException;

    public boolean servirPedido (Queue<Producto> queuePedido);

    //public boolean listaPedidosRealizados (List<Producto> listaPedidosEntregados);

   // public List<Producto> listaOrdenadaDescVentas();






/*
    public boolean crearUsuario(Usuario usuario) throws UsuarioYaExisteException;

    public Usuario consultarUsuario(String nombre) throws UsuarioNoExisteException;

    public List<Usuario> consultarListaUsuarios() throws ListaUsuariosVaciaException;

    public void añadirObjetoAUsuario(String nombre, Producto objeto) throws UsuarioNoExisteException, UsuarioSinObjetosException, ObjetoNoEncontradoException;

    public List<Producto> consultarObjetosDeUsuario(String nombre) throws UsuarioNoExisteException, UsuarioSinObjetosException;

    public void modificarUsuario(Usuario user) throws UsuarioNoExisteException;

    public void reset();


    public modelo.Producto consultarObjetoDeUsuario(String nombre, String nombreProducto) throws UsuarioNoExisteException, UsuarioSinObjetosException, ObjetoNoEncontradoException;

   // public boolean eliminarUsuario (String nombre);

   // public boolean eliminarObjetosDeUsuario(String nombre);

*/





}
