// OU3.java - BestamDenKortasteVagen
/*
Skapa två variabler som representerar antalet mellanstationer i Zon2 och Zon3. Zon2 = int U, Zon3 = int V.
Skapa tre arrays (doubls) som representerar längderna mellan X, Y och mellanstationerna.
a[U] = längderna mellan X och mellanstationerna U
b[U][V] = längderna mellan U och V, varje mellanstation U har vägar till varje mellanstation V.
c[V] = längderna mellan mellanstationerna V och Y.
- inmatning av antal mellanstationer i Zon2 - lagras i int variabel U
- inmatning av antal mellanstationer i Zon3 - lagras i int variabel V
- inmatning av väglängder mellan X och mellanstationerna i Zon2 - lagras i array a[],
  antalet platser beror på int variabeln U, a[U] när du skapar den.
- inmatning av väglängder mellan mellanstationerna i Zon2 och mellanstationerna i Zon3 - lagras i array b[][],
  antal element i b[][] beror på b[U][V] (+1 om du inte vill använda index 0)
- inmatning av väglängder mellan mellanstationerna i Zon3 och Y - lagras i array c[],
  antal platser beror på int variabel V, c[V] när du skapar den.

- skicka sedan alla tre vektorer till metoden mellanstationer i classen DenKortasteVagen
  (lib.algoritmer.DenKortasteVagen.mellanstationer)
  int mellanstationer[] = lib.algoritmer.DenKortasteVagen.mellanstationer (a, b, c);
  (Det som returneras är referensen till den vektor som du skapar i metoden (int[] mellanstationer = new int[3]))
 */

public class OU3{
  public static void main(String[] args){
    java.util.Scanner in = new java.util.Scanner(System.in);

    int mellanstationerZon2;
    double[] a = new double[mellanstationerZon2];

    for(int i = 1; i <= a.length; i++){
      System.out.println("Mata in langden mellan X och U" + i);
      a[i] = in.nextDouble();
    }

  }
}
