import java.io.*; // PrintWriter
import lib.punkt.Punkt;
import lib.punkt.Polylinje;

class PunktTest{
  public static void main (String[] args){

    PrintWriter out = new PrintWriter (System.out, true);
    java.util.Scanner    in = new java.util.Scanner(System.in);
    in.useLocale(java.util.Locale.US);

/*
    // testa en konstruktor och en transformator
    Punkt p1 = new Punkt ("A", 3, 4);
    Punkt p2 = new Punkt ("B", 5, 6);
    out.println (p1 + " " + p2);

    // testa inspektorer
    String n = p1.getNamn ();
    int x = p1.getX ();
    int y = p1.getY ();
    out.println (n + ": " + x + ", " + y);


    // testa en kombinator och en komparator
    double d = p1.avstand (p2);
    out.println (d);
    boolean b = p1.equals (p2);
    out.println ("Is p1 equal to p (true/false) = " + b);


    // testa mutatorer
    p2.setX (1);
    p2.setY (2);
    out.println (p2);


    // testa en konstruktor till
    Punkt p = new Punkt (p1);
    out.println ("p = " + p);
    out.println ("p1 = " + p1);
    out.println ("p2 = " + p2);
    out.println ("Is p1 equal to p (true/false) = " + p1.equals(p));
*/
    System.out.println();
    System.out.println("How many points in polyline?");
    System.out.println("Insert whole number: ");
    int antalPunkter = in.nextInt();
    Punkt[] punkter = new Punkt[antalPunkter];

    for(int i = 0; i < antalPunkter; i++){
      System.out.println("Mata in namn och koordinater pa punkt nr. " + (i+1) + " av " + antalPunkter + " i polylinjen");
      String namn = in.next();
      int xKoordinat = in.nextInt();
      int yKoordinat = in.nextInt();
      in.nextLine();
      punkter[i] = new Punkt(namn, xKoordinat, yKoordinat);
    }

    for (int i = 0; i < antalPunkter; i++) {
      System.out.println("Inmatade punkt nr. " + (i+1) + ": " + punkter[i]);
    }

    Polylinje p1 = new Polylinje(punkter);
    System.out.println("Polylinje:");
    System.out.println(p1);

    System.out.println();
    System.out.println("Polylinjens langd = " + p1.langd());
    System.out.println();

    // Kopiera punkterna i en polylinje -> ändra X-värdet i första punkten och sedan skriv ut den punkten.
    Punkt[] copyPunkter = p1.getHorn();
    copyPunkter[0].setX(12);
    System.out.println(copyPunkter[0]);
    System.out.println();
    System.out.println("p1 = " + p1);
    System.out.println();


    //Skapar ny punkt som ska läggas till i slutet av en  redan skapad Polylinje.
    Punkt test = new Punkt("K", 1, 20);
    //p1.laggTill(test);
    //System.out.println(p1);
    System.out.println("Ny punkt = " + test.toString());
    System.out.println();

    System.out.println("Framfor vilken punkt vill du stoppa in punkten " + test.getNamn() + "?");
    String framforHornNamn = in.next();

    p1.laggTillFramfor(test, framforHornNamn);
    System.out.println(p1);
    System.out.println();

    System.out.println("Vilken punkt vill du ta bort?");
    String taBortPunkt = in.next();
    p1.taBort(taBortPunkt);
    System.out.println("p1 = " + p1);
  }

}
