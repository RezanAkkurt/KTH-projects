import lib.punkt.Punkt;
import lib.punkt.NPolylinje;
import lib.punkt.PolylinjeInterface;

public class testNode{
  public static void main(String[]args){
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

    NPolylinje polylinje1 = new NPolylinje(punkter);
    System.out.println("polylinje = " + polylinje1);
    System.out.println("polylinje langd = " + polylinje1.langd());

    // Create a new NPolylinje by copying the punkter in polylinje1
    NPolylinje polylinje2 = new NPolylinje(polylinje1.getHorn());
    polylinje2.setFarg("gul");

    System.out.println("polylinje1 = " + polylinje1 + "\npolylinje2 = " + polylinje2);


  }
}
