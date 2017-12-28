
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
      this.piece = null;
      return null;
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
    int rowInt = row - FIRST_ROW;
    int columnInt = column - FIRST_COLUMN;
    if(rowInt >= 0 && rowInt <= 7 && columnInt >= 0 && columnInt <= 7){
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

    // isOnBoard works by if Chesspiece is on board then its' row and column are within isValidField parameters. If the Chesspiece is not on board then
    // the Chesspieces' row = 0 (within) and column = -1 (not within) = isValidField method returns false!
    public boolean isOnBoard (){
      return Chessboard.this.isValidField (row, column);
    }

    public void moveTo (char row, byte column) throws NotValidFieldException {
      if (!Chessboard.this.isValidField (row, column)){
        throw new NotValidFieldException ("bad field: " + row + column );
      }

      // First the piece is removed if it is already on the board, then it is put where it is moved to.
      if(this.column != -1){
        int rowInt = this.row - FIRST_ROW;
        int columnInt = this.column - FIRST_COLUMN;
        Chessboard.this.fields[rowInt][columnInt].take();
      }
      //Chessboard.this.fields[this.row][this.column].take();

      this.row = row;
      this.column = column;
      int r = row - FIRST_ROW;
      int c = column - FIRST_COLUMN;
      Chessboard.this.fields[r][c].put (this);

    }

    // The piece is moved out from the board, position becomes then row = 0, column = -1 (which is outside of the array).
    public void moveOut () {
      int r = this.row - FIRST_ROW;
      int c = this.column - FIRST_COLUMN;
      Chessboard.this.fields[r][c].take();
      this.row = 0;
      this.column = -1;
    }

    public abstract void markReachableFields ();
    public abstract void unmarkReachableFields ();

    public void markyMark(char newRow, byte newColumn){
      if(Chessboard.this.isValidField(newRow, newColumn)){
        int r = newRow - FIRST_ROW;
        int c = newColumn - FIRST_COLUMN;
        Chessboard.this.fields[r][c].mark();
      }
    }

    public void unmarkyMark(char newRow, byte newColumn){
      if(Chessboard.this.isValidField(newRow, newColumn)){
        int r = newRow - FIRST_ROW;
        int c = newColumn - FIRST_COLUMN;
        Chessboard.this.fields[r][c].unmark();
      }
    }


    public char getColor(){
      return this.color;
    }

  }

  public class Pawn extends Chesspiece{

    public Pawn (char color, char name){
      super (color, name);
    }

    public void markReachableFields (){
      byte newColumn;
      if(getColor() == 'w'){
        newColumn = (byte) (column + 1);
      } else{
        newColumn = (byte) (column - 1);
      }

      if (Chessboard.this.isValidField (row, newColumn)){
        int r = row - FIRST_ROW;
        int c = newColumn - FIRST_COLUMN;
        Chessboard.this.fields[r][c].mark ();
      }
    }

    public void unmarkReachableFields (){
      byte newColumn;
      if(getColor() == 'w'){
        newColumn = (byte) (column + 1);
      } else{
        newColumn = (byte) (column - 1);
      }

      if (Chessboard.this.isValidField (row, newColumn)){
        int r = row - FIRST_ROW;
        int c = newColumn - FIRST_COLUMN;
        Chessboard.this.fields[r][c].unmark ();
      }
    }
  }

  public class Rook extends Chesspiece {

    public Rook (char color, char name){
      super (color, name);
    }

    public void markReachableFields (){

      //for loop must be <= NUMBER_OF_COLUMNS because FIRST_COLUMN is always 1 so when we subtract on the last loop-run it becomes c = 7-1 = 6 when we want c = 7 (last array index);
      for(int i = 0; i <= NUMBER_OF_COLUMNS; i++){
        byte newColumn = (byte) i; // pointer for the columns to be marked.
        if(Chessboard.this.isValidField(row, newColumn)){
          int r = row - FIRST_ROW;
          int c = newColumn - FIRST_COLUMN;
          Chessboard.this.fields[r][c].mark();
        }
      }

      for(int i = 0; i < NUMBER_OF_ROWS; i++){
        char newRow = (char) (FIRST_ROW + i); // pointer for the rows to be marked.
        if(Chessboard.this.isValidField(newRow, column)){
          int r = newRow - FIRST_ROW;
          int c = column - FIRST_COLUMN;
          Chessboard.this.fields[r][c].mark();
        }

      }

    }

    public void unmarkReachableFields (){

      //unmarking column by fixating the row but iterate column through variable i and pointer newColumn.
      for(int i = 0; i <= NUMBER_OF_COLUMNS; i++){
        byte newColumn = (byte) i; // pointer for the columns to be unmarked.
        if(Chessboard.this.isValidField(row, newColumn)){
          int r = row - FIRST_ROW;
          int c = newColumn - FIRST_COLUMN;
          Chessboard.this.fields[r][c].unmark();
        }
      }

      //unmarking row by fixating the column but iterate row through variable i and newRow.
      for(int i = 0; i < NUMBER_OF_ROWS; i++){
        char newRow = (char) (FIRST_ROW + i); // pointer for the rows to be unmarked.
        if(Chessboard.this.isValidField(newRow, column)){
          int r = newRow - FIRST_ROW;
          int c = column - FIRST_COLUMN;
          Chessboard.this.fields[r][c].unmark();
        }
      }
    }
  }

  //Create a definition-class to store every possible Knight movement
  public class KnightMove{
    public final char row;
    public final byte column;
    public KnightMove(char row, byte column){
      this.row = row;
      this.column = column;
    }

  }

  public class Knight extends Chesspiece {

    public Knight (char color, char name){
      super (color, name);
    }

    //Create a private method that creates an array of every possible Knight movement relative to the chesspiece. The method then returns the array.
    private KnightMove[] getReachableCoords(){
      char tempRow;
      KnightMove[] coords = new KnightMove[8];

      tempRow = (char) (this.row-2);
      coords[0] = new KnightMove(tempRow, (byte) (this.column-1));
      coords[1] = new KnightMove(tempRow, (byte) (this.column+1));

      tempRow = (char) (this.row-1);
      coords[2] = new KnightMove(tempRow, (byte) (this.column-2));
      coords[3] = new KnightMove(tempRow, (byte) (this.column+2));

      tempRow = (char) (this.row+1);
      coords[4] = new KnightMove(tempRow, (byte) (this.column-2));
      coords[5] = new KnightMove(tempRow, (byte) (this.column+2));

      tempRow = (char) (this.row+2);
      coords[6] = new KnightMove(tempRow, (byte) (this.column-1));
      coords[7] = new KnightMove(tempRow, (byte) (this.column+1));

      return coords;
    }

    public void markReachableFields (){

      /*
      char newRow = (char) (this.row + 1);
      byte newColumn = (byte) (this.column - 2);
      markyMark(newRow, newColumn);

      newRow = (char) (this.row+2);
      newColumn = (byte) (this.column-1);
      markyMark(newRow, newColumn);

      newRow = (char) (this.row+2);
      newColumn = (byte) (this.column+1);
      markyMark(newRow, newColumn);

      newRow = (char) (this.row+1);
      newColumn = (byte) (this.column+2);
      markyMark(newRow, newColumn);

      newRow = (char) (this.row-1);
      newColumn = (byte) (this.column+2);
      markyMark(newRow, newColumn);

      newRow = (char) (this.row-2);
      newColumn = (byte) (this.column+1);
      markyMark(newRow, newColumn);

      newRow = (char) (this.row-2);
      newColumn = (byte) (this.column-1);
      super.markyMark(newRow, newColumn);

      newRow = (char) (this.row-1);
      newColumn = (byte) (this.column-2);
      markyMark(newRow, newColumn);
      */

      KnightMove[] coords = getReachableCoords();
      for(int i = 0; i < 8; i++){
        markyMark(coords[i].row, coords[i].column);
      }
    }

    public void unmarkReachableFields (){
      /*
      char newRow = (char) (this.row + 1);
      byte newColumn = (byte) (this.column - 2);
      super.unmarkyMark(newRow, newColumn);

      newRow = (char) (this.row+2);
      newColumn = (byte) (this.column-1);
      super.unmarkyMark(newRow, newColumn);

      newRow = (char) (this.row+2);
      newColumn = (byte) (this.column+1);
      super.unmarkyMark(newRow, newColumn);

      newRow = (char) (this.row+1);
      newColumn = (byte) (this.column+2);
      super.unmarkyMark(newRow, newColumn);

      newRow = (char) (this.row-1);
      newColumn = (byte) (this.column+2);
      super.unmarkyMark(newRow, newColumn);

      newRow = (char) (this.row-2);
      newColumn = (byte) (this.column+1);
      super.unmarkyMark(newRow, newColumn);

      newRow = (char) (this.row-2);
      newColumn = (byte) (this.column-1);
      super.unmarkyMark(newRow, newColumn);

      newRow = (char) (this.row-1);
      newColumn = (byte) (this.column-2);
      super.unmarkyMark(newRow, newColumn);
      */

      KnightMove[] coords = getReachableCoords();
      for(int i = 0; i < 8; i++){
        super.unmarkyMark(coords[i].row, coords[i].column);
      }
    }
  }

  public class Bishop extends Chesspiece {

    public Bishop (char color, char name){
      super (color, name);
    }

    public void markReachableFields (){
      char rowTemp;
      byte columnTemp;

      for(int i = 1; i < 8; i++){
        rowTemp = (char) (this.row + i);
        columnTemp = (byte) (this.column + i);
        if(isValidField(rowTemp, columnTemp)){
          markyMark(rowTemp, columnTemp);
        }
      }

      for(int i = 1; i < 8; i++){
        rowTemp = (char) (this.row + i);
        columnTemp = (byte) (this.column - i);
        if(isValidField(rowTemp, columnTemp)){
          markyMark(rowTemp, columnTemp);
        }
      }

      for(int i = 1; i < 8; i++){
        rowTemp = (char) (this.row - i);
        columnTemp = (byte) (this.column - i);
        if(isValidField(rowTemp, columnTemp)){
          markyMark(rowTemp, columnTemp);
        }
      }

      for(int i = 1; i < 8; i++){
        rowTemp = (char) (this.row - i);
        columnTemp = (byte) (this.column + i);
        if(isValidField(rowTemp, columnTemp)){
          markyMark(rowTemp, columnTemp);
        }
      }
    }

    public void unmarkReachableFields (){
      char rowTemp;
      byte columnTemp;

      for(int i = 1; i < 8; i++){
        rowTemp = (char) (this.row + i);
        columnTemp = (byte) (this.column + i);
        if(isValidField(rowTemp, columnTemp)){
          unmarkyMark(rowTemp, columnTemp);
        }
      }

      for(int i = 1; i < 8; i++){
        rowTemp = (char) (this.row + i);
        columnTemp = (byte) (this.column - i);
        if(isValidField(rowTemp, columnTemp)){
          unmarkyMark(rowTemp, columnTemp);
        }
      }

      for(int i = 1; i < 8; i++){
        rowTemp = (char) (this.row - i);
        columnTemp = (byte) (this.column - i);
        if(isValidField(rowTemp, columnTemp)){
          unmarkyMark(rowTemp, columnTemp);
        }
      }

      for(int i = 1; i < 8; i++){
        rowTemp = (char) (this.row - i);
        columnTemp = (byte) (this.column + i);
        if(isValidField(rowTemp, columnTemp)){
          unmarkyMark(rowTemp, columnTemp);
        }
      }
    }
  }

  public class Queen extends Chesspiece {

    public Queen (char color, char name){
      super (color, name);
    }

    public void markReachableFields (){

      //for loop must be <= NUMBER_OF_COLUMNS because FIRST_COLUMN is always 1 so when we subtract on the last loop-run it becomes c = 7-1 = 6 when we want c = 7 (last array index);
      for(int i = 0; i <= NUMBER_OF_COLUMNS; i++){
        byte newColumn = (byte) i; // pointer for the columns to be marked.
        if(Chessboard.this.isValidField(row, newColumn)){
          int r = row - FIRST_ROW;
          int c = newColumn - FIRST_COLUMN;
          Chessboard.this.fields[r][c].mark();
        }
      }

      for(int i = 0; i < NUMBER_OF_ROWS; i++){
        char newRow = (char) (FIRST_ROW + i); // pointer for the rows to be marked.
        if(Chessboard.this.isValidField(newRow, column)){
          int r = newRow - FIRST_ROW;
          int c = column - FIRST_COLUMN;
          Chessboard.this.fields[r][c].mark();
        }

      }

      char rowTemp;
      byte columnTemp;

      for(int i = 1; i < 8; i++){
        rowTemp = (char) (this.row + i);
        columnTemp = (byte) (this.column + i);
        if(isValidField(rowTemp, columnTemp)){
          markyMark(rowTemp, columnTemp);
        }
      }

      for(int i = 1; i < 8; i++){
        rowTemp = (char) (this.row + i);
        columnTemp = (byte) (this.column - i);
        if(isValidField(rowTemp, columnTemp)){
          markyMark(rowTemp, columnTemp);
        }
      }

      for(int i = 1; i < 8; i++){
        rowTemp = (char) (this.row - i);
        columnTemp = (byte) (this.column - i);
        if(isValidField(rowTemp, columnTemp)){
          markyMark(rowTemp, columnTemp);
        }
      }

      for(int i = 1; i < 8; i++){
        rowTemp = (char) (this.row - i);
        columnTemp = (byte) (this.column + i);
        if(isValidField(rowTemp, columnTemp)){
          markyMark(rowTemp, columnTemp);
        }
      }

    }

    public void unmarkReachableFields (){

      //unmarking column by fixating the row but iterate column through variable i and pointer newColumn.
      for(int i = 0; i <= NUMBER_OF_COLUMNS; i++){
        byte newColumn = (byte) i; // pointer for the columns to be unmarked.
        if(Chessboard.this.isValidField(row, newColumn)){
          int r = row - FIRST_ROW;
          int c = newColumn - FIRST_COLUMN;
          Chessboard.this.fields[r][c].unmark();
        }
      }

      //unmarking row by fixating the column but iterate row through variable i and newRow.
      for(int i = 0; i < NUMBER_OF_ROWS; i++){
        char newRow = (char) (FIRST_ROW + i); // pointer for the rows to be unmarked.
        if(Chessboard.this.isValidField(newRow, column)){
          int r = newRow - FIRST_ROW;
          int c = column - FIRST_COLUMN;
          Chessboard.this.fields[r][c].unmark();
        }
      }

      char rowTemp;
      byte columnTemp;

      for(int i = 1; i < 8; i++){
        rowTemp = (char) (this.row + i);
        columnTemp = (byte) (this.column + i);
        if(isValidField(rowTemp, columnTemp)){
          unmarkyMark(rowTemp, columnTemp);
        }
      }

      for(int i = 1; i < 8; i++){
        rowTemp = (char) (this.row + i);
        columnTemp = (byte) (this.column - i);
        if(isValidField(rowTemp, columnTemp)){
          unmarkyMark(rowTemp, columnTemp);
        }
      }

      for(int i = 1; i < 8; i++){
        rowTemp = (char) (this.row - i);
        columnTemp = (byte) (this.column - i);
        if(isValidField(rowTemp, columnTemp)){
          unmarkyMark(rowTemp, columnTemp);
        }
      }

      for(int i = 1; i < 8; i++){
        rowTemp = (char) (this.row - i);
        columnTemp = (byte) (this.column + i);
        if(isValidField(rowTemp, columnTemp)){
          unmarkyMark(rowTemp, columnTemp);
        }
      }
    }
  }

  public class King extends Chesspiece {

    public King (char color, char name){
      super (color, name);
    }

    public void markReachableFields (){

      for(int i = 1; i <= 3; i++){
        byte newColumn = (byte) ((column + 2) - i); // pointer for the columns to be marked.
        char newRow = (char) (row-1);
        super.markyMark(newRow, newColumn);
        newRow = (char) (row+1);
        super.markyMark(newRow, newColumn);
      }

      markyMark(row, (byte)(column+1));
      markyMark(row, (byte)(column-1));

    }

    public void unmarkReachableFields (){

      for(int i = 1; i <= 3; i++){
        byte newColumn = (byte) ((column + 2) - i); // pointer for the columns to be marked.
        char newRow = (char) (row-1);
        super.unmarkyMark(newRow, newColumn);
        newRow = (char) (row+1);
        super.unmarkyMark(newRow, newColumn);
      }

      super.unmarkyMark(row, (byte)(column+1));
      super.unmarkyMark(row, (byte)(column-1));

    }
  }

}
