package controlador;

import controlador.exceptions.*;
import modelo.*;
import org.apache.log4j.Logger;

import javax.ws.rs.Produces;
import java.util.*;

public class ProductManagerImpl implements ProductManager {

    final static Logger log = Logger.getLogger(ProductManagerImpl.class.getName());

    private static ProductManagerImpl instance;
    private Map < String, Producto> map;
    private Map < String, Usuario> users;
    Queue<Producto> queuePedido = new Queue<Producto>() {
        @Override
        public boolean add(Producto producto) {
            return false;
        }

        @Override
        public boolean offer(Producto producto) {
            return false;
        }

        @Override
        public Producto remove() {
            return null;
        }

        @Override
        public Producto poll() {
            return null;
        }

        @Override
        public Producto element() {
            return null;
        }

        @Override
        public Producto peek() {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Producto> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Producto> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }
    };

    private ProductManagerImpl(){ this.map = new HashMap(); this.users = new HashMap(); }

    public static ProductManagerImpl getInstance(){                 // Tiene que ser estático ??
        if(instance == null) {
            instance = new ProductManagerImpl();
            log.info("Se ha instanciado controlador.ProductManagerImpl por primera vez.");
        }
        return  instance;
    }

    public boolean crearUsuario(Usuario user) throws UsuarioYaExisteException {

        log.info("Inicio crearUsuario: " + user.nombre + " " + user.password + " " + user.nivel + " " + user.ataque + " " + user.defensa + " " + user.resistencia);
        if(isUser(user.nombre)) throw new UsuarioYaExisteException();          // lanza excepcion si isUser== true (lo contiene)
        users.put(user.nombre, user);

        log.info("Fin crearUsuario: " + user.nombre + " con éxito.");
        return true;                                                        // return true ya que operacion ok
    }

    private boolean isUser (String nombre) { return (map.containsKey(nombre)); }

    private Usuario getUser(String nombre) throws UsuarioNoExisteException{

        if (!users.containsKey(nombre)) throw new UsuarioNoExisteException();
        return users.get(nombre);
    }






    public boolean realizarPedido (String nombreUsuario, List<Producto> listaProductos) throws UsuarioNoExisteException{

        Usuario user = getUser(nombreUsuario);

        queuePedido.addAll(listaProductos);

        for(Producto p : listaProductos) {
            user.listaPedidosPedidos.add(queuePedido.poll(p));
        }


        return true;

    }

    public boolean servirPedido (Queue<Producto> queuePedido) {

        

        return true;
    }


    public List<Producto> listaOrdenadaAscPrecio (){

        log.info("Inicio listaOrdenadaAscPrecio");
        List<Producto> listaProductosOrdAscPrecio = new ArrayList<>();

        //if (!listaProductosOrdAscPrecio.addAll(map.values()));

        listaProductosOrdAscPrecio.addAll(map.values());

       // listaProductosOrdAscPrecio.stream().sorted((producto1, producto2) -> producto1.precioProducto.compareTo(producto2.precioProducto()));



/*
        for (Producto p: map.values()) {


            boolean enc = false;
            int i = 0;

            while (!enc){
                if(p.precioProducto > map.get(i).precioProducto) {
                    listaProductosOrdAscPrecio.add(p);
                }
            }

        }
*/


        log.info("Fin listaOrdenadaAscPrecio con éxito.");
        return listaProductosOrdAscPrecio;



    }


    private List<Producto> ordenarAscPrecio(){

        List<Producto> listaProductosOrdAscPrecio = new ArrayList<>();

        listaProductosOrdAscPrecio.addAll(map.values());





        //List<Producto> listaProductos = new List<Producto>;


        return listaProductosOrdAscPrecio;
    }



/*
    // CREAR USUARIO
    public boolean crearUsuario(Usuario user) throws UsuarioYaExisteException {

        log.info("Inicio crearUsuario: " + user.nombre + " " + user.password + " " + user.nivel + " " + user.ataque + " " + user.defensa + " " + user.resistencia);
        if(isUser(user.nombre)) throw new UsuarioYaExisteException();          // lanza excepcion si isUser== true (lo contiene)
        map.put(user.nombre, user);

        log.info("Fin crearUsuario: " + user.nombre + " con éxito.");
        return true;                                                        // return true ya que operacion ok
    }

    public Usuario consultarUsuario (String nombre) throws UsuarioNoExisteException {

        log.info("Inicio consultarUsuario: " + nombre);
        Usuario usuario = getUser(nombre);
        if( usuario == null) throw new UsuarioNoExisteException();

        log.info("Fin consultarUsuario: " + nombre + " con éxito.");
        return usuario;
    }

    public void modificarUsuario (Usuario user) throws UsuarioNoExisteException{

        log.info("Inicio modificarUsuario: " + user);
        Usuario user2 = getUser(user.nombre);
        user2.modificarUsuario(user);
    }

    public List<Usuario> consultarListaUsuarios() throws ListaUsuariosVaciaException {

        log.info("Inicio consultarListaUsuarios");
        List<Usuario> listaUsers = new ArrayList<>();
        if (!listaUsers.addAll(map.values())) throw new ListaUsuariosVaciaException();
        log.info("Fin consultarListaUsuarios con éxito.");
        return listaUsers;
    }

    public void añadirObjetoAUsuario (String nombre, Producto producto) throws UsuarioNoExisteException {

        log.info("Inicio añadirObjetoAUsuario: " + nombre + " " + producto.nombreProducto + " " + producto.descripcionProducto + " " + producto.tipoProducto + " " + producto.numeroVentasProducto + " " + producto.precioProducto);
        Usuario usuario = getUser(nombre);
        usuario.insertarObjeto(producto);
        log.info("Fin añadirObjetoAUsuario con éxito.");
    }

    public Producto consultarObjetoDeUsuario(String nombre, String nombreObjeto) throws UsuarioNoExisteException, UsuarioSinObjetosException, ObjetoNoEncontradoException {

        log.info("Inicio consultarObjetoDeUsuario: " + nombre + " " + nombreObjeto);
        Usuario usuario = getUser(nombre);
        Producto producto = usuario.getObjeto(nombreObjeto);
        log.info("Fin consultarObjetoDeUsuario con éxito.");
        return producto;

    }

    public List<Producto> consultarObjetosDeUsuario (String nombre) throws UsuarioSinObjetosException, UsuarioNoExisteException {

        log.info("Inicio consultarObjetosDeUsuario: " + nombre);
        Usuario usuario = getUser(nombre);
        List<Producto> listaProductos = usuario.getListaObjetos(nombre);
        if (listaProductos == null || listaProductos.size() == 0) throw new UsuarioSinObjetosException();
        log.info("Fin ocnsultarObjetosDeUsuario con éxito.");
        return listaProductos;
    }




    private Usuario getUser(String nombre) throws UsuarioNoExisteException{

        if (!map.containsKey(nombre)) throw new UsuarioNoExisteException();
        return map.get(nombre);
    }

    private boolean isUser (String nombre) { return (map.containsKey(nombre)); }

    public void reset() {
        this.instance = null;
    }
*/


}
