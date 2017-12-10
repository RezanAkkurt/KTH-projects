
/*
1. Komplettera definitionsklassen Polylinje: implementera metoderna och kommentera klassen samt dess medlemmar.
I metoden laggTillFramfor ska det hörn som parameterreferensen refererar till kopieras. I metoden getHorn ska
en vektor som innehåller kopior av polylinjens hörn skapas, och en referens till denna vektor ska returneras.

2. Skapa en definitionsklass till: Polylinje1. I denna klass ska parameterreferenser kopieras, i stället för
de refererade resurserna. I metoden getHorn ska referensen till egna hörn returneras.

Vilken strategi är bättre: att kopiera resurser (som i klassen Polylinje) eller bara referenser (som i klassen Polylinje1)?

3. Skapa ett enkelt testprogram, PolylinjeTest, som använder konstruktorerna och metoderna i klassen Polylinje.

4. Skapa en bild som representerar ett objekt av typen Polylinje. Bland annat ska bilden innehålla objektet och
dess referenser, den refererade vektorn och dess referenser, samt de hörn som refereras ifrån vektorn. Bilden ska
förses med rätta beteckningar.

5. Åskådliggör den algoritm som används i metoden laggTillFramfor. Man ska rita en serie bilder som visar hur det
givna hörnet så småningom förs in på rätt ställe i den aktuella polylinjen. Bilderna ska förses med rätta beteckningar.

6. Ett objekt av typen Polylinje har sin egen vektor, där polylinjens hörn lagras. Är denna strategi minneseffektiv?
Är den tidseffektiv? Vad händer om man ofta lägger till eller tar bort hörn?

*/

public class Polylinje {
  private Punkt[] horn;
  private String farg = "svart";
  private int bredd = 1;

  public Polylinje () {
    this.horn = new Punkt[0];
  }

  public Polylinje (Punkt[] horn){
    this.horn = new Punkt[horn.length];
    for (int i = 0; i < horn.length; i++){
      this.horn[i] = new Punkt (horn[i]);
    }
  }

  public String toString () {}

  public Punkt[] getHorn () {}

  public String getFarg () {}

  public int getBredd () {}

  public void setFarg (String farg) {}

  public void setBredd (int bredd) {}

  public double langd () {}

  public void laggTill (Punkt horn){
    Punkt[] h = new Punkt[this.horn.length + 1];
    int i = 0;
    for (i = 0; i < this.horn.length; i++){
      h[i] = this.horn[i];
    }
    h[i] = new Punkt (horn);
    this.horn = h;
  }

  public void laggTillFramfor (Punkt horn, String hornNamn) {}

  public void taBort (String hornNamn) {}
}
