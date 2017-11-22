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
    // Skapar ett inmatningsverktyg
    java.util.Scanner in = new java.util.Scanner(System.in);
    in.useLocale(java.util.Locale.US);

    // Mata in antalet mellanstationer i Zon2 och Zon3
    System.out.println("Mata in antalet mellanstationer i Zon2");
    int mellanstationerZon2 =  in.nextInt();
    if(in.hasNextLine()){
      in.nextLine();
    }
    System.out.println("Mata in antalet mellanstationer i Zon3");
    int mellanstationerZon3 = in.nextInt();
    if(in.hasNextLine()){
      in.nextLine();
    }

    // Skapa tre arrayer som ska innehålla alla vaglangder. Arrayernas storlek beror på antalet mellanstationer i Zon2 och Zon3.
    double[] a = new double[mellanstationerZon2]; // Arrayen ska innehålla väglängderna mellan X och respektive mellanstation i Zon2
    double[][] b = new double[mellanstationerZon2][mellanstationerZon3]; // Arrayen ska innehålla väglängderna mellan respektive mellanstationer i Zon2 och Zon3
    double[] c = new double[mellanstationerZon3]; // Arrayen ska innehålla väglängderna mellan respektive mellanstationer i Zon3 och Y

    // Användaren matar in vaglangderna mellan stationerna.
    for(int i = 0; i < a.length; i++){
      System.out.println("Mata in langden mellan X och U" + (i+1));
      a[i] = in.nextDouble();
      if(in.hasNextLine()){
        in.nextLine();
      }
    }


    for(int i = 0; i < b.length; i++){
      System.out.println("Mata in langderna mellan stationerna U" + (i+1) + " och V1-" + mellanstationerZon3 + " (dvs totalt " + mellanstationerZon3 + " vaglangder ska matas in)");
      for(int j = 0; j < b[i].length; j++){
        b[i][j] = in.nextDouble();
      }
      if(in.hasNextLine()){
        in.nextLine();
      }
    }

    for (int j = 0; j < c.length; j++){
      System.out.println("Mata in vaglangderna mellan V" + (j+1) + " och Y");
      c[j] = in.nextDouble();
      if(in.hasNextLine()){
        in.nextLine();
      }
    }


    // Skapar en array som ska innehålla vilka mellanstationer som innefattar den kortaste vägen mellan X och Y.
    // Innehållet i arrayen returneras från vår metod i classen DenKortasteVagen. Denna metoden
    // använder sig av en algoritm för att beräkna den kortaste vägen och returnerar vilka stationer det är.
    int[] mellanstationer = lib.algoritmer.DenKortasteVagen.mellanstationer(a, b, c);
    double langd = lib.algoritmer.DenKortasteVagen.langd(a, b, c);

    // Utmatning av vilka stationer som leder till den kortaste vägen. Notera att programmet lägger till +1
    System.out.println("Den kortaste vagen gar igenom U" + (mellanstationer[0]+1) + " och V" + (mellanstationer[1]+1));
    System.out.println("Den kortaste vagen ar " + langd + "m lang");
  }

}
