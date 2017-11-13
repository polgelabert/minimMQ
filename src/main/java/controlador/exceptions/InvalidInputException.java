package controlador.exceptions;

public class InvalidInputException extends Exception{

   // public InvalidInputException(){ super ("Input no válido."); }

    public InvalidInputException(){ super(String.valueOf(-1)); }

}
