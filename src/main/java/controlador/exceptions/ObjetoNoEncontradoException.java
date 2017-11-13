package controlador.exceptions;

public class ObjetoNoEncontradoException extends Exception {

    //public ObjetoNoEncontradoException(){ super("Nombre de objeto mal introuducido. modelo.Producto no encontrado."); }

    public ObjetoNoEncontradoException(){ super(String.valueOf(-3)); }

}