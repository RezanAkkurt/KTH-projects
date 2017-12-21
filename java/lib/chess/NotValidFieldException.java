package lib.chess;

@SuppressWarnings("serial") //Gör att programmet ignorerar varning om serializable

public class NotValidFieldException extends Exception{
  public NotValidFieldException(String message){
    super(message);
  }
}
