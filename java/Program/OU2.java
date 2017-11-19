// OU2.java
// Detta program motsvarar programmet EnTriangelOchDessCirklar i uppgiften

import Library.Triangel;
import java.util.Scanner;

class OU2{
  public static void main(String[]args){
    // Skapar inmatningsobjekt av typen Scanner
    java.util.Scanner    in = new java.util.Scanner(System.in);
    in.useLocale(java.util.Locale.US);
    // Skapar variabler som motsvarar sidorna av en triangel
    double a = 0;
    double b = 0;
    double c = 0;

    // while-loop för att kontrollera att inmatningen av triangelns sidor skapar en giltig triangel
    boolean giltigTriangel = false;
    while(giltigTriangel == false){

      System.out.println("Mata in sida a:s langd (cm):");
      a = in.nextDouble();

      if(in.hasNextLine()){ // Metod som förhindrar att ifall man matar in för många temperaturer en vecka så lagras de i nästa vecka.
        in.nextLine();
      }

      System.out.println("Mata in sida b:s langd (cm):");
      b = in.nextDouble();

      if(in.hasNextLine()){ // Metod som förhindrar att ifall man matar in för många temperaturer en vecka så lagras de i nästa vecka.
        in.nextLine();
      }

      System.out.println("Mata in sida c:s langd (cm):");
      c = in.nextDouble();

      if(in.hasNextLine()){ // Metod som förhindrar att ifall man matar in för många temperaturer en vecka så lagras de i nästa vecka.
        in.nextLine();
      }

      System.out.println("Langden a ar: " + a + " cm");
      System.out.println("Langden b ar: " + b + " cm");
      System.out.println("Langden c ar: " + c + " cm");
      System.out.println();

      if((a+b)>c && (b+c)>a && (a+c)>b){
        System.out.println("Inmatade langder skapar en giltig triangel!");
        System.out.println();
        giltigTriangel = true;
      }
      else{
        System.out.println("Inmatade langder skapar inte en giltig triangel!");
        System.out.println("Programmet startas om.");
        System.out.println();
      }
    }

    System.out.println("Vi ar utanfor loopen!");
    System.out.println("Langden a ar: " + a + " cm");
    System.out.println("Langden b ar: " + b + " cm");
    System.out.println("Langden c ar: " + c + " cm");
    System.out.println();

    double radieAvOmskrivenCirkel = Triangel.omskrivenCirkel(a, b, c);
    double radieAvInskrivenCirkel = Triangel.inskrivenCirkel(a, b, c);

    System.out.println("Den omskrivna cirkelns radie ar: " + radieAvOmskrivenCirkel);
    System.out.println("Den inskrivna cirkelns radie ar: " + radieAvInskrivenCirkel);

  }
}
