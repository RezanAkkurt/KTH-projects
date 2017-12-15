// EU1.java

/*******************************************************************************
Uppgifter i samband med problemet och lösningen
1. Spåra metoden min i fallet att sekvensen innehåller sexton element.
Använd papper och penna: rita en serie bilder som visar hur talsekvensen transformeras.
Analysera transformationer av talsekvensen, och hitta det första felet i metoden. Rätta detta fel.

- Algoritmen fungerar på sådant sätt att den skapar (utöver arrayen som skickas till metoden) en ytterligare
  array (referens: delsekvensen) som är ungefär hälften så stor som sekvensen.
  Sedan jämförs varje par i sekvensen. Det minsta talet i varje par placeras i delsekvensen.
  Sedan pekar man referensen sekvensen till delsekvensen. Så att båda referenser pekar till samma array.
  Sedan uppdateras antalet par som algoritmen ska analysera (halveras). Vid detta skede analyseras alla delsekvensens par och de minsta talen
  i varje par placeras i början av delsekvensen. Sedan halveras antalet par igen och de tal som förra gången placerades i början av
  arrayen analyeras och de minsta heltalen i dessa par placeras i början av arrayen. På så sätt går det tills det inte finns något
  par kvar att analysera (dvs ingen jämförelse mellan två tal). På så sätt har programmet placerat det minsta heltalet i början av vår del-
  sekvens (som också vår sekvens-referens pekar till).

  Problemet med koden i uppgiften är att även om programmet blir klar med den inre while-loopen när antaletPar = 0 (och då har placerat
  minsta talet i position 0 i sekvensen) så lämnas aldrig den yttre while-loopen. Detta är för att efter den första gången som vi
  ändrar vad referensen sekvens ska peka till (den ändras till att peka till vår delsekvens-array) så är dess length alltid 8 (om
  ursprungliga sekvensen är 16). Således blir while-loopens boolean condition (sekvens.length > 1) alltid sann då (8>1) alltid är sant.

  Lösningen på problemet är att ändra den yttre while-loopens condition till antaletPar >= 1. Detta är för att vi vill att programmets
  algoritm ska köras så länge det finns ett par tal att jämföra.

2. För att hitta det andra felet spåra den korrigerade varianten av metoden min.
Använd en sekvens som innehåller nitton element med det minsta elementet på den sjuttonde positionen.
Rita en serie bilder som visar hur det minsta heltalet bestäms. Varför erhålls ett felaktigt svar?
Hitta det andra felet i metoden och rätta det.

3. Spåra den variant av metoden min som innehåller två fel med datorns hjälp.
Skapa ett testprogram som anropar metoden min. Använd en sekvens med sexton element.
Aktivera först spårutskriften 1 och följ utvecklingen. Aktivera sedan även spårutskriften 2.
Analysera de uppgifter som erhålls och hitta det första felet. Korrigera detta fel.

4. Spåra med datorns hjälp den variant av metoden min som enbart innehåller det andra felet.
Använd en sekvens som innehåller nitton element med det minsta elementet på den sjuttonde positionen.
Man ska aktivera bara spårutskriften 1. Analysera de data som erhålls och hitta felet. Korrigera felet.

5. Lös problemet på ett annat sätt: skapa en ny metod min som bestämmer det minsta elementet i samlingen.
I denna metod ska inte urskiljningsstrategin användas, utan en minneseffektivare och enklare strategi: uppdateringsstrategin.

*******************************************************************************/

import lib.algoritmer.MinstaHeltalet;

class EU1{
  public static void main(String[]args){
    int[] element1 = {5, 2, 7, 4, 8, 4, 5, 3, 6, 5, 1, 8, 3, 5, 7, 8};
    int[] element2 = {10, 7, 2, 5, 10, 6, 8, 7, 10, 9, 8, 7, 1, 7, 4, 3, 0, 4, 9};

    int minstaHeltalet = MinstaHeltalet.min(element2);

    System.out.println();
    System.out.println("Det minsta heltalet ar: " + minstaHeltalet);

    int minstaHeltalet1 = MinstaHeltalet.minUpdateStrat(element2);

    System.out.println();
    System.out.println("Det minsta heltalet ar: " + minstaHeltalet1);

    /*
    int i = 0;
    while(i < 10){
      System.out.println(i++);
    }
    */

  }

}
