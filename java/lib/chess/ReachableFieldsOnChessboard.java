import lib.chess.Chessboard;
import lib.chess.NotValidFieldException;
import java.util.Random;

public class ReachableFieldsOnChessboard{
  public static void main(String[] args){

    // Create new chessboard(name = chessBoard)
    Chessboard chessBoard = new Chessboard ();

    // Print out to terminal the chessboard
    System.out.println (chessBoard + "\n");

    // Create an array of chesspieces (one of each chesspiece). In order to store different types of pieces the array is an array of the type of Chesspiece,
    // which is the abstract super class to the different types of pieces.
    Chessboard.Chesspiece[] pieces = new Chessboard.Chesspiece[6];

    // Each index stores a reference to different created objects (different chesspieces)
    pieces[0] = chessBoard.new Pawn ('w', 'P');
    pieces[1] = chessBoard.new Rook ('b', 'R');
    pieces[2] = chessBoard.new Queen ('w', 'Q');
    pieces[3] = chessBoard.new Bishop ('w', 'B');
    pieces[4] = chessBoard.new King ('b', 'K');
    pieces[5] = chessBoard.new Knight ('w', 'N');

    // ToDo: Create a for-loop that 1. Randomly positions a chesspiece each time it is placed on the chessboard. 2. Presents the chesspieces (Enter chessboard,
    // mark reachable fields, unmark reachable fields and then step off chessboard so that next chesspiece can present itself).

    Random rand = new Random();

    System.out.println("Pawn: " + pieces[0] +
                        "\nRook: " + pieces[1] +
                          "\nQueen: " + pieces[2] +
                            "\nBishop: " + pieces[3] +
                              "\nKing: " + pieces[4] +
                                "\nKnight: " + pieces[5] + "\n");

    for (int i = 0; i < pieces.length; i++) {
      char row = (char) (65 + rand.nextInt(8));
      byte column = (byte) (rand.nextInt(8));
      try{
        pieces[i].moveTo(row, column);
        pieces[i].markReachableFields(); // Polymorfism - när den vet vet vilken som ska användas om king så anropas den metoden i king klassen
                                        // Fungerar bara om metoden finns i root-metoden (i superklassen)
        System.out.println(chessBoard.toString());
        pieces[i].unmarkReachableFields();
        pieces[i].moveOut();

      } catch(Exception e){
        System.out.println(e);
      }
    }
  }
}
