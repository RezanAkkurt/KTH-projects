
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
package lib.punkt;

public class Polylinje{
  // Class fields, ie an object of type Polylinje contains an array of Punkt, string farg and int bredd.
  private Punkt[] horn;
  private String farg = "svart";
  private int bredd = 1;

  //Constructor using no sent arguments, creates an object Polylinje without Punkt (zero Punkt in the array)
  public Polylinje () {
    this.horn = new Punkt[0];
  }

  // Constructor using an array of Punkt to construct the object Polylinje. Every Punkt in the array sent as an argument is copied to the
  // Punkt array in the new object Polylinje.
  public Polylinje (Punkt[] horn){
    this.horn = new Punkt[horn.length];
    for (int i = 0; i < horn.length; i++){
      this.horn[i] = new Punkt (horn[i]);
    }
  }

  // toString method that returns a string in order to print the Punkt-array, farg and bredd
  public String toString () {
    StringBuilder s = new StringBuilder();
    s.append("(");
    for(int i = 0; i < horn.length; i++){
      s.append(this.horn[i] + ", ");
    }
    s.append("farg = " + getFarg() + ", bredd = " + getBredd() + ")");
    String string = s.toString();
    return string;
  }

  // getHorn method that returns an array that is a copy of array of Punkt in the this.Polylinje.
  public Punkt[] getHorn () {
    Punkt[] copyPunkter = new Punkt[this.horn.length];
    for(int i = 0; i < this.horn.length; i++){
      copyPunkter[i] = this.horn[i];
    }
    return copyPunkter;
  }

  //return current farg of object
  public String getFarg () {
    return this.farg;
  }

  // returns current bredd of object
  public int getBredd () {
    return this.bredd;
  }

  // Changes the color of the object
  public void setFarg (String farg) {
    this.farg = farg;
  }

  // changes the bredd for the object
  public void setBredd (int bredd) {
    this.bredd = bredd;
  }

//  public double langd () {}

  // Adds a punkt/horn at the end of the Polylinje.
  // The method copies creates an array with room for one more element and then copies the current array of Punkt
  // to the new array. Then it changes the objects current array to this new array (old array is discarded because no reference to it)
  public void laggTill (Punkt horn){
    Punkt[] h = new Punkt[this.horn.length + 1];
    int i = 0; // Genom att skapa referensen i utanför for-loopen kan dess sista värde användas för att stoppa in nya punkten när for-loopen är klar.
    for (i = 0; i < this.horn.length; i++){
      h[i] = this.horn[i];
    }
    h[i] = new Punkt (horn);
    this.horn = h;
  }

  public void laggTillFramfor (Punkt horn, String hornNamn) {}

  public void taBort (String hornNamn) {}

}
