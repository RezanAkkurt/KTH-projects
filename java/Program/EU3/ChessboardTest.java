

import lib.chess.Chessboard;
import lib.chess.NotValidFieldException;

public class ChessboardTest{
  public static void main(String[]args){
    Chessboard chessboard = new Chessboard();

    System.out.println();
    System.out.println("Print entire board");
    System.out.println(chessboard);

    // OuterClass.InnerClass innerObject = outerObject.new InnerClass();

    /*
    ShadowTest st = new ShadowTest();
      ShadowTest.FirstLevel fl = st.new FirstLevel();
    */

    Chessboard.Pawn p1 = chessboard.new Pawn('b', 'P');

    try{
      p1.moveTo('A', (byte) 2);
    } catch(Exception NotValidFieldException){
      System.out.println(NotValidFieldException);
    }

    System.out.println("Added chesspiece and moved to A2");
    System.out.println(chessboard);

    Chessboard.Pawn p2 = chessboard.new Pawn('w', 'P');
    try{
      p2.moveTo('A', (byte) 7);
    } catch(Exception NotValidFieldException){
      System.out.println(NotValidFieldException);
    }

    System.out.println("Added chesspiece and moved to A7");
    System.out.println(chessboard);

    p1.moveOut();

    System.out.println("removed bP");
    System.out.println(chessboard);

    System.out.println("Is bP on board?");
    System.out.println(p1.isOnBoard());

    Chessboard.Pawn p3 = chessboard.new Pawn('w', 'P');
    try{
      p3.moveTo('A', (byte) 6);
    } catch(Exception NotValidFieldException){
      System.out.println(NotValidFieldException);
    }

    System.out.println("Added wP to A6");
    System.out.println(chessboard);

    try{
      p2.moveTo('A', (byte) 6);
    } catch(Exception NotValidFieldException){
      System.out.println(NotValidFieldException);
    }

    System.out.println("Moved second wP to A6");
    System.out.println(chessboard);

    try{
      p2.moveTo('A', (byte) 5);
    } catch(Exception NotValidFieldException){
      System.out.println(NotValidFieldException);
    }

    System.out.println("Moved second wP to A5");
    System.out.println(chessboard);
    p2.moveOut();

    Chessboard.Rook p4 = chessboard.new Rook('b', 'R');
    try{
      p4.moveTo('E', (byte) 4);
    } catch(Exception NotValidFieldException){
      System.out.println(NotValidFieldException);
    }

    p2.markReachableFields();
    p4.markReachableFields();

    System.out.println("Mark Rook Reachable Fields");
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
  }
}
