import controlador.*;
import controlador.exceptions.*;
import modelo.*;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;



public class ProductoTest {

    final static Logger log = Logger.getLogger(ProductoTest.class.getName());          // test2.class.getname indica el nombre de la clase.

    private ProductManagerImpl pm;

    String nombreProducto, tipoProducto, descripcionProducto;
    Usuario user;

    List<Producto> listaProductos = new ArrayList<>();

    @Before
    public void SetUp() throws UsuarioYaExisteException {

        this.pm = ProductManagerImpl.getInstance();


        try {
            Producto p1 = new Producto("tomate","verdura","descripcionLarga",0,1);
            Producto p2 = new Producto("jamon","carne","descripcionLarga2",0,5);
            listaProductos.add(p1);
            listaProductos.add(p2);

            user = new Usuario("pol", "1234", 10, 20, 30, 40);
            pm.crearUsuario(user);

        }
        catch (Exception e) {
            //log.fatal(e.getMessage() + e.getCause());
            //e.printStackTrace();
            throw e;
        }

    }



    @Test
    public void realizarPedidoTest() throws UsuarioNoExisteException{



        boolean res = pm.realizarPedido(user.nombre, listaProductos);


    }



}
