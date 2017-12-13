// EU1.java

/*******************************************************************************
Uppgifter i samband med problemet och lösningen
1. Spåra metoden min i fallet att sekvensen innehåller sexton element.
Använd papper och penna: rita en serie bilder som visar hur talsekvensen transformeras.
Analysera transformationer av talsekvensen, och hitta det första felet i metoden. Rätta detta fel.

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
    int[] element1 = new int[16];
    int[] element2 = new int[19];

    int minstaHeltalet = MinstaHeltalet.min(element1);

    System.out.println(minstaHeltalet);

  }
}
