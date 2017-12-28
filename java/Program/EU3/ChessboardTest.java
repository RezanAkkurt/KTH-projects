

import lib.chess.Chessboard;
import lib.chess.NotValidFieldException;

public class ChessboardTest{
  public static void main(String[]args){
    Chessboard chessboard = new Chessboard();

    // OuterClass.InnerClass innerObject = outerObject.new InnerClass();

    /*
    ShadowTest outerObjectReference = new ShadowTest();
      ShadowTest.FirstLevel innerObjectReference = outerObject.new FirstLevel();
    */

    Chessboard.Chesspiece p1 = chessboard.new Pawn('w', 'P');
    // Man kan även skriva Chessboard.Pawn p1 = chessboard.new Pawn('w', 'P');
    // Notera skillnaden mellan att skapa en referens-variabel av typen Chesspiece (abstract super class) och en referens-variabel av typen
    // Pawn (non-abstract class). Fråga Fadil vilken som är bäst.

    try{
      p1.moveTo('A', (byte) 2);
    } catch(Exception NotValidFieldException){
      System.out.println(NotValidFieldException);
    }

    System.out.println();
    System.out.println("Added pawn and moved to A2");
    System.out.println(chessboard);

    Chessboard.Pawn p2 = chessboard.new Pawn('b', 'P');
    try{
      p2.moveTo('A', (byte) 7);
    } catch(Exception NotValidFieldException){
      System.out.println(NotValidFieldException);
    }

    System.out.println("Added pawn and moved to A7");
    System.out.println(chessboard);

    System.out.println("Marked pawns reachable fields");
    p1.markReachableFields();
    p2.markReachableFields();
    System.out.println(chessboard);

    p1.unmarkReachableFields();
    p1.moveOut();
    p2.unmarkReachableFields();
    p2.moveOut();


    Chessboard.Rook p4 = chessboard.new Rook('b', 'R');
    try{
      p4.moveTo('E', (byte) 4);
    } catch(Exception NotValidFieldException){
      System.out.println(NotValidFieldException);
    }

    System.out.println("Mark Rook Reachable Fields");
    p4.markReachableFields();
    System.out.println(chessboard);

    System.out.println("Unmark Rook reachable fields");
    p4.unmarkReachableFields();
    System.out.println(chessboard);

    Chessboard.Knight p5 = chessboard.new Knight('w', 'K');
    try{
      p5.moveTo('D', (byte) 4);
    } catch(Exception NotValidFieldException){
      System.out.println(NotValidFieldException);
    }

    p4.moveOut();

    System.out.println("Mark Knight reachable fields");
    p5.markReachableFields();
    System.out.println(chessboard);

    System.out.println("Unmark Knight reachable fields");
    p5.unmarkReachableFields();
    System.out.println(chessboard);

    //Move Knight out of Chessboard
    p5.moveOut();

    Chessboard.Bishop p6 = chessboard.new Bishop('b', 'B');
    try{
      p6.moveTo('E', (byte) 5);
    } catch(Exception NotValidFieldException){
      System.out.println(NotValidFieldException);
    }

    System.out.println("Mark Bishop reachable fields");
    p6.markReachableFields();
    System.out.println(chessboard);

    System.out.println("Unmark Bishop reachable fields");
    p6.unmarkReachableFields();
    System.out.println(chessboard);

    //remove Bishop
    p6.moveOut();

    //Create Queen
    Chessboard.Queen p7 = chessboard.new Queen('w', 'Q');

    try{
      p7.moveTo('B', (byte) 3);
    } catch(Exception NotValidFieldException){
      System.out.println(NotValidFieldException);
    }

    System.out.println("Mark Queen reachable fields");
    p7.markReachableFields();
    System.out.println(chessboard);

    System.out.println("Unmark Queen reachable fields");
    p7.unmarkReachableFields();
    System.out.println(chessboard);

    //remove Queen
    p7.moveOut();

    // Add King
    Chessboard.King p8 = chessboard.new King('b','K');
    try{
      p8.moveTo('D', (byte) 2);
    } catch(Exception NotValidFieldException){
      System.out.println(NotValidFieldException);
    }

    System.out.println("Mark King reachable fields");
    p8.markReachableFields();
    System.out.println(chessboard);

    System.out.println("Unmark King reachable fields");
    p8.unmarkReachableFields();
    System.out.println(chessboard);

  }
}
