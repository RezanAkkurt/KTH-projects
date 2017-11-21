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
    double langd = 0;
    double kortasteVagen = a[1] + b[1][1] + c[1];
    int[] mellanstationer = new int[3];

    /*
    Skapa en for-loop(j) som går igenom och sedan en inre for-loop (j) och adderar alla
    längder och if kortasteVagen > a[i] + b[i][j] + c[i](
    så uppdatera mellanstationer[1] = i och mellanstationer[2] = j;
    )
     */
    return mellanstationer;
  }
}
