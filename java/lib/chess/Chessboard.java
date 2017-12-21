
package lib.chess;

import lib.chess.NotValidFieldException;

public class Chessboard {

  // Every square on the Chessboard is an object of the type Field.
  // An object of the type Field has a name (row+column), can have a Chesspiece on it, and can be marked by other Chesspieces.
  public static class Field{
    private char row;
    private byte column;
    private Chesspiece piece = null;
    private boolean marked = false;

    public Field (char row, byte column) {
      this.row = row;
      this.column = column;
    }

    public void put (Chesspiece piece) {
      this.piece = piece;
    }

    public Chesspiece take () {
      Chesspiece temp = this.piece;
      this.piece = null;
      return temp;
    }

    public void mark () {
      this.marked = true;
    }

    public void unmark () {
      this.marked = false;
    }

    public String toString (){
      String s = (marked)? "xx" : "--"; //s depends on if the field is marked.
      return (piece == null)? s : piece.toString (); //if there is a piece on the field.
    }

  }

  public static final int NUMBER_OF_ROWS = 8;
  public static final int NUMBER_OF_COLUMNS = 8;
  public static final int FIRST_ROW = 'A'; // 'A' = 65
  public static final int FIRST_COLUMN = 1;

  private Field[][] fields; // Skapar en variabel av typen Field.

  // Constructor
  public Chessboard (){
    fields = new Field[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
    char row = 0;
    byte column = 0;
    for (int r = 0; r < NUMBER_OF_ROWS; r++){
      row = (char) (FIRST_ROW + r);
      column = FIRST_COLUMN;
      for (int c = 0; c < NUMBER_OF_COLUMNS; c++){
        fields[r][c] = new Field (row, column);
        column++;
      }
    }
  }

  public String toString () {
    StringBuilder string = new StringBuilder();
    System.out.println("  A  B  C  D  E  F  G  H");
    for(int column = 0; column < NUMBER_OF_COLUMNS; column++){
      string.append((column+1) + " ");
      for(int row = 0; row < NUMBER_OF_ROWS; row++){
        string.append(this.fields[row][column] + " ");//System.out.println(this.fields[row][column]);
      }

      string.append("\n");
    }
    return string.toString();

  }

  public boolean isValidField (char row, byte column) {
    int num = (int) row - FIRST_ROW;
    int num2 = (int) column - FIRST_COLUMN;
    if(num > -1 && num < 8 && num2 > -1 && num < 8){
      return true;
    } else {
      return false;
    }
  }

  public abstract class Chesspiece{
    private char color;
    // w - white, b - black
    private char name;
    // K - King, Q - Queen, R - Rook, B - Bishop, N - Knight,
    // P – Pawn
    protected char row = 0;
    protected byte column = -1;
    protected Chesspiece (char color, char name) {
      this.color = color;
      this.name = name;
    }

    public String toString (){
      //"" + color + name;
      String s = String.valueOf(this.color) + String.valueOf(this.name);
      return s;
    }

    public boolean isOnBoard (){
      return Chessboard.this.isValidField (row, column);
    }

    public void moveTo (char row, byte column) throws NotValidFieldException {
      if (!Chessboard.this.isValidField (row, column)){
        throw new NotValidFieldException ("bad field: " + row + column );
      }
      this.row = row;
      this.column = column;
      int r = row - FIRST_ROW;
      int c = column - FIRST_COLUMN;
      Chessboard.this.fields[r][c].put (this);
    }

    public void moveOut () {}
    public abstract void markReachableFields ();
    public abstract void unmarkReachableFields ();
  }

  public class Pawn extends Chesspiece{

    public Pawn (char color, char name){
      super (color, name);
    }

    public void markReachableFields (){
      byte col = (byte) (column + 1);
      if (Chessboard.this.isValidField (row, col)){
        int r = row - FIRST_ROW;
        int c = col - FIRST_COLUMN;
        Chessboard.this.fields[r][c].mark ();
      }
    }

    public void unmarkReachableFields (){
      byte col = (byte) (column + 1);
      if (Chessboard.this.isValidField (row, col)){
        int r = row - FIRST_ROW;
        int c = col - FIRST_COLUMN;
        Chessboard.this.fields[r][c].unmark ();
      }
    }
  }

  public class Rook extends Chesspiece {

    public Rook (char color, char name){
      super (color, name);
    }

    public void markReachableFields (){
      byte col = (byte) (column + 1);
      if (Chessboard.this.isValidField (row, col)){
        int r = row - FIRST_ROW;
        int c = col - FIRST_COLUMN;
        Chessboard.this.fields[r][c].mark ();
      }
    }

    public void unmarkReachableFields (){
      byte col = (byte) (column + 1);
      if (Chessboard.this.isValidField (row, col)){
        int r = row - FIRST_ROW;
        int c = col - FIRST_COLUMN;
        Chessboard.this.fields[r][c].unmark ();
      }
    }
  }

  public class Knight extends Chesspiece {

    public Knight (char color, char name){
      super (color, name);
    }

    public void markReachableFields (){
      byte col = (byte) (column + 1);
      if (Chessboard.this.isValidField (row, col)){
        int r = row - FIRST_ROW;
        int c = col - FIRST_COLUMN;
        Chessboard.this.fields[r][c].mark ();
      }
    }

    public void unmarkReachableFields (){
      byte col = (byte) (column + 1);
      if (Chessboard.this.isValidField (row, col)){
        int r = row - FIRST_ROW;
        int c = col - FIRST_COLUMN;
        Chessboard.this.fields[r][c].unmark ();
      }
    }
  }

  public class Bishop extends Chesspiece {

    public Bishop (char color, char name){
      super (color, name);
    }

    public void markReachableFields (){
      byte col = (byte) (column + 1);
      if (Chessboard.this.isValidField (row, col)){
        int r = row - FIRST_ROW;
        int c = col - FIRST_COLUMN;
        Chessboard.this.fields[r][c].mark ();
      }
    }

    public void unmarkReachableFields (){
      byte col = (byte) (column + 1);
      if (Chessboard.this.isValidField (row, col)){
        int r = row - FIRST_ROW;
        int c = col - FIRST_COLUMN;
        Chessboard.this.fields[r][c].unmark ();
      }
    }
  }

  public class Queen extends Chesspiece {

    public Queen (char color, char name){
      super (color, name);
    }

    public void markReachableFields (){
      byte col = (byte) (column + 1);
      if (Chessboard.this.isValidField (row, col)){
        int r = row - FIRST_ROW;
        int c = col - FIRST_COLUMN;
        Chessboard.this.fields[r][c].mark ();
      }
    }

    public void unmarkReachableFields (){
      byte col = (byte) (column + 1);
      if (Chessboard.this.isValidField (row, col)){
        int r = row - FIRST_ROW;
        int c = col - FIRST_COLUMN;
        Chessboard.this.fields[r][c].unmark ();
      }
    }
  }

  public class King extends Chesspiece {

    public King (char color, char name){
      super (color, name);
    }

    public void markReachableFields (){
      byte col = (byte) (column + 1);
      if (Chessboard.this.isValidField (row, col)){
        int r = row - FIRST_ROW;
        int c = col - FIRST_COLUMN;
        Chessboard.this.fields[r][c].mark ();
      }
    }

    public void unmarkReachableFields (){
      byte col = (byte) (column + 1);
      if (Chessboard.this.isValidField (row, col)){
        int r = row - FIRST_ROW;
        int c = col - FIRST_COLUMN;
        Chessboard.this.fields[r][c].unmark ();
      }
    }
  }

}
