// OU3.java - BestamDenKortasteVagen
/*******************************************************************************
--PROBLEM
Ponera att man vill ta sig mellan två stationer (station X i Zon1 och station Y i Zon4).
Mellan dessa två stationer finns ett antal mellanstationer(uppdelade i två zoner; Zon2 och Zon3).
I Zon2 finns stationerna U1, U2, U3, ..., Um (där m är ett positivt heltal). I Zon3 finns
stationerna V1, V2, V3, ..., Vn (där n är ett positivt heltal). Från station X i Zon1
finns det bara en väg till respektive station i Zon2. Från varje station i Zon2 finns det
vägförbindelser till varje station i Zon3 (antal vägar mellan Zon2 och Zon3 = m*n).
Från varje station i Zon3 finns det en väg till stationen Y.

--ALGORITM
FÖRVILLKOR
Förvillkoren som måste vara sanna för att användningen av algoritmen ska fungera
är att det får bara finnas fyra zoner. I Zon1 och Zon4 får det bara finnas en station.
I Zon2 och Zon3 får det finnas ett godtyckligt antal stationer men alla stationer i
de två zonerna måste ha vägförbindelser sinsemellan. Det får inte heller finnas direkta
vägar från Zon1 till Zon3 eller Zon4 utan från Zon1 så måste man åka till Zon2, sen Zon3
för att slutligen nå Zon4 (Y).

EFTERVILLKOR
Den kortaste vägen mellan stationerna X och Y har fastställts.

STEG I ALGORITMEN - ORD
Inledningsvis skapar vi en double variabel som representerar den kortaste vägen.
Vår utgångspunkt är att vägen från X till U1 sen V1 till Y är den kortaste vägen,
således tilldelar vi vår variabel värdet (avståndet) av vägen mellan X och U1, U1 och V1 och V1 och Y.
Sedan jämför vi vår kortaste väg genom att först gå via U1 och respektive station i Zon3 (Vn).
Om vi någon gång hittar en kortare väg så uppdateras vår variabel och tilldelas denna kortare väg samtidigt
som vi i en array lagrar vilka stationer det var som ledde till denna kortare väg.
Sedan fortsätter vi jämförelse och då provar från U2 och respektive station i Zon3 (Vn).
På samma sätt uppdaterar vi variabeln och lagrar stationernas i en array om vi hittar
en kortare väg.

STEG I ALGORITMEN - PSEUDOKOD
mellanstationer(double a[], double b[][], double c[]){
  denKortasteVagen = första kombinationen av vägar
  int[] mellanstationer = new int[2] // skapar lagring av vilka mellanstationer som leder till kortaste väg.

  for(väg1 = 0; väg1 < maxAntalStationerIZon2; väg1++){
    for(väg2 = 0; väg2 < maxAntalStationerIZon3; väg2++){
      if (aktuell kombination av vägar < denKortasteVagen){
        denKortasteVagen = aktuell kombination av vägar;
        mellanstationer[0] = väg1;
        mellanstationer[1] = väg2;
      }
    }
  }

  return mellanstationer;
}
 ******************************************************************************/

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
