// ValjPolylinje.java

import lib.punkt.Punkt;
import lib.punkt.Polylinje;
import java.util.*;

class ValjPolylinje{
  public static final Random    rand = new Random();
  public static final int ANTAL_POLYLINJER = 10;
  public static final String[] FARGER = {"bla", "rod", "gul"};

  public static void main(String[]args){

    // skapa ett antal slumpmässiga polylinjer
    Polylinje[] polylinjer = new Polylinje[ANTAL_POLYLINJER];
    for (int i = 0; i < ANTAL_POLYLINJER; i++){
      polylinjer[i] = slumpPolylinje ();
    }

    // visa polylinjerna
    System.out.println();
    for (int i = 0; i < ANTAL_POLYLINJER; i++ ) {
      System.out.println(polylinjer[i]);
    }
    System.out.println();

    // bestäm den kortaste av de polylinjer som är gula
    // Hitta den första gula polylinjen. Sätt denna som den kortaste.
    double kortasteLangden = 0;
    int kortasteIndex = -1;
    for(int i = polylinjer.length-1; i >= 0; i--){
      if(polylinjer[i].getFarg().equals("gul")){
        kortasteLangden = polylinjer[i].langd();
        kortasteIndex = i;
      }
    }

    //int kortasteIndex = -1; // Start värde på vilken plats som den kortaste gula linjen ligger på (-1 ligger utanför arrayen)
    //loopa igenom varje polylinje med färgen gul och ta reda på den kortaste polylinjen med hjälp av en uppdaterinsstrategi
    for(int i = 0; i < ANTAL_POLYLINJER; i++){
        if(polylinjer[i].getFarg().equals("gul")){
          System.out.println("Gul polylinje: " + polylinjer[i].toString() + " och dess langd = " + polylinjer[i].langd());
          if (polylinjer[i].langd() < kortasteLangden){
              kortasteLangden = polylinjer[i].langd();
              //kortasteGulaPolylinjen = polylinjer[i];
              kortasteIndex = i;
          }
        }
    }

    if(kortasteLangden == 0 && kortasteIndex == -1){ // om kortasteLangden == 0 && kortasteIndex == -1 -> finns ingen gul polylinje.
      System.out.println("Det finns ingen gul polylinje!");
    } else {
      // visa den valda polylinjen
      System.out.println("\nDen kortaste gula polylinjen:\n" + polylinjer[kortasteIndex].toString());
      System.out.println("Dess langd = " + polylinjer[kortasteIndex].langd());
      System.out.println();
    }

    //OuterClass.InnerClass innerObject = outerObject.new InnerClass();
    //Iteratorn körs bara om det finns en kortaste gul polylinje
    if(kortasteIndex != -1){
      Polylinje.PolylinjeIterator iterator = polylinjer[kortasteIndex].new PolylinjeIterator();

      for (int i = 0; i < polylinjer[kortasteIndex].getHorn().length; i++) {
        System.out.println(iterator.horn());
        iterator.gaFram();
      }
      iterator.gaFram();
      System.out.println(iterator.horn()); // Exception: slut av iterationen
    }
  }

  // slumpPunkt returnerar en punkt med ett slumpmässigt namn, som är en stor bokstav i
  // det engelska alfabetet, och slumpmässiga koordinater.
  public static Punkt slumpPunkt () {
    String n = "" + (char) (65 + rand.nextInt (26));
    int x = rand.nextInt (11);
    int y = rand.nextInt (11);
    return new Punkt (n, x, y);
  }

  // slumpPolylinje returnerar en slumpmässig polylinje, vars färg är antingen blå, eller röd
  // eller gul. Namn på polylinjens hörn är stora bokstäver i det engelska alfabetet. Två hörn
  // kan inte ha samma namn.
  public static Polylinje slumpPolylinje () {
    // skapa en tom polylinje, och lägg till hörn till den
    Polylinje polylinje = new Polylinje ();
    int antalHorn = 2 + rand.nextInt (7);
    int antalValdaHorn = 0;
    boolean[] valdaNamn = new boolean[26];
    // ett och samma namn kan inte förekomma flera gånger
    Punkt valdPunkt = null;
    char valtChar = 0;
    while (antalValdaHorn < antalHorn) {

      valdPunkt = slumpPunkt(); // Skapa slumpPunkt
      //String namn = valdPunkt.getNamn(); // Lagra slumpPunktens namn som string.
      valtChar = valdPunkt.getNamn().charAt(0); //Lagrat slumpPunktens namn som char.
      int valtCharSomInt = (int) valtChar - 65; // Konverterar slumpPunktens namn som int.
      while(valdaNamn[valtCharSomInt] == true){
        valdPunkt = slumpPunkt();
        valtChar = valdPunkt.getNamn().charAt(0);
        valtCharSomInt = (int) valtChar - 65;
      }
      valdaNamn[valtCharSomInt] = true; // Sätter slumpPunktens namn som true i boolean array.
      polylinje.laggTill(valdPunkt);
      antalValdaHorn++;

    }

    // sätt färg
    polylinje.setFarg(FARGER[rand.nextInt(FARGER.length)]);

    return polylinje;
  }

}
