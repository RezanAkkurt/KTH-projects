

import lib.chess.Chessboard;
import lib.chess.NotValidFieldException;

public class ChessboardTest{
  public static void main(String[]args){
    Chessboard chessboard = new Chessboard();

    System.out.println(chessboard);

    // OuterClass.InnerClass innerObject = outerObject.new InnerClass();

    /*
    ShadowTest st = new ShadowTest();
      ShadowTest.FirstLevel fl = st.new FirstLevel();
    */

    Chessboard.Pawn p1 = chessboard.new Pawn('b', 'B');

    try{
      p1.moveTo('A', (byte) 1);
    } catch(Exception NotValidFieldException){

    }

    System.out.println(chessboard);

  }
}
