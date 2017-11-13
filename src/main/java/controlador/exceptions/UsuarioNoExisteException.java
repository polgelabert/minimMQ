package controlador.exceptions;

//public class UsuarioNoExisteException extends MyException {
public class UsuarioNoExisteException extends Exception {

    public UsuarioNoExisteException() {
        super(String.valueOf(-4));
    }


/*
public UsuarioNoExisteException() {
    super ("El usuario no existe.");
}
*/

/*
    public UsuarioNoExisteException() {
        super ("El usuario no existe.", 3);
    }
*/


}
