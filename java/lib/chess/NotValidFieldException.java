package lib.chess;

@SuppressWarnings("serial") //Gör att programmet ignorerar varning om serializable

public class NotValidFieldException extends Exception { // Exception av typen checked (RuntimeException t.ex. är unchecked (try-catch behövs inte))
    public NotValidFieldException(){}
    public NotValidFieldException(String s) {
        super(s);
    }
}
