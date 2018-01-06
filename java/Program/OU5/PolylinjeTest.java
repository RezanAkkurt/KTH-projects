import java.io.*; // PrintWriter
import lib.punkt.Punkt;
import lib.punkt.Polylinje;

class PolylinjeTest{
  public static void main (String[] args){

    PrintWriter out = new PrintWriter (System.out, true);
    java.util.Scanner    in = new java.util.Scanner(System.in);
    in.useLocale(java.util.Locale.US);

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
    System.out.println("Punkten A i kopia av hornen i p1 = " + copyPunkter[0]);
    System.out.println("Punkten A i p1: " + p1.getPunkt(0).toString());
    copyPunkter[0].setX(12);
    System.out.println("Ändrat X-koordinaten i kopian av p1: " + copyPunkter[0]);
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

    p1.laggTillFramfor1(test, framforHornNamn);
    System.out.println(p1);
    System.out.println();

    System.out.println("Vilken punkt vill du ta bort?");
    String taBortPunkt = in.next();
    p1.taBort(taBortPunkt);
    System.out.println("p1 = " + p1);

  }
}
