import java.io.*; // PrintWriter
import lib.punkt.Punkt;
import lib.punkt.Polylinje;

class PunktTest{
  public static void main (String[] args){

    PrintWriter out = new PrintWriter (System.out, true);
    java.util.Scanner    in = new java.util.Scanner(System.in);
    in.useLocale(java.util.Locale.US);

    // testa en konstruktor och en transformator
    Punkt p1 = new Punkt ("A", 2, 3);
    Punkt p2 = new Punkt ("B", -1, -1);
    out.println("p1 = " + p1);
    out.println("p2 = " + p2);

    // testa inspektorer
    String n = p1.getNamn ();
    int x = p1.getX ();
    int y = p1.getY ();
    out.println (n + ": " + x + ", " + y);

    // testa en kombinator och en komparator
    double d = p1.avstand (p2);
    out.println ("Avstand mellan p1 och p2 = " + d);
    System.out.println();
    boolean b = p1.equals (p2);
    out.println ("Is p1 equal to p2 (true/false) = " + b);
    System.out.println();

    // testa mutatorer
    p2.setX (1);
    p2.setY (2);
    out.println ("p2 = " + p2);

    // testa en konstruktor till
    Punkt p = new Punkt (p1);
    out.println ("p = " + p);
    out.println ("p1 = " + p1);
    out.println ("p2 = " + p2);
    out.println ("Is p1 equal to p (true/false) = " + p1.equals(p));

    p.setX(15);
    out.println ("p = " + p);
    out.println ("p1 = " + p1);
    out.println ("Is p1 equal to p2 (true/false) = " + p1.equals(p));

  }
}
