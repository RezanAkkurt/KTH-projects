// DenKortasteVagen.java
/*
Skapa en metod som tar emot tre arrays (referenserna till dessa tre arrays).
Denna metod ska returnera en referens till en ny array som har lagrat två element som representerar
de mellanstationer man ska ta för att ta den snabbaste vägen. t.ex. om mellanstationer U2 och V4 leder till
de kortaste vägarna så lagras 2 och 4 i olika element i en array mellanstationer med minst 2 platser.
 */
package lib.algoritmer;

public class DenKortasteVagen{
  public static int[] mellanstationer(double a[], double b[][], double c[]){

    double langd = 0; // Variabel langd som representerar den totala längden mellan X och Y vid varje genomfart.
    double kortasteVagen = a[0] + b[0][0] + c[0]; // Variabel kortasteVagen som inledningsvis anses vara genom U1 sen V1.
    int[] mellanstationer = new int[2]; // En endimensionell vektor med plats för två element. I dessa platser ska vilka stationer som leder till den kortaste vägen lagras.

    for(int i = 0; i < a.length; i++){
      for (int j = 0; j < b[i].length; j++){
        if(a[i] + b[i][j] + c[j] < kortasteVagen){
          kortasteVagen = a[i] + b[i][j] + c[j];
          mellanstationer[0] = i;
          mellanstationer[1] = j;
        }
      }
    }

    return mellanstationer;
  }

  public static double langd(double a[], double b[][], double c[]){
    double langd = a[0] + b[0][0] + c[0];
    //double kortasteVagen = a[0] + b[0][0] + c[0];

    for(int i = 1; i < a.length; i++){
      for(int j = 1; j < b[i].length; j++){
        if(a[i] + b[i][j] + c[j] < langd){
          langd = a[i] + b[i][j] + c[j];
        }
      }
    }

    return langd;
  }
}
