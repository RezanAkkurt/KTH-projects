package lib.punkt;

import lib.punkt.PolylinjeInterface;
import lib.punkt.Punkt;

public class NPolylinje implements PolylinjeInterface {

  private static class Nod {
    public Punkt horn;
    public Nod nastaNod;
    public Nod (Punkt horn) {
      this.horn = horn; // Nodens hörn i form av punkt
      nastaNod = null; // nastaNod är en länk till nästa noden (nästa hörn)
    }
  }

  // Private parameters
  private Nod horn; // Bara en, ingen array, så i polylinjen lagras bara en referens till första Noden(hörnet) sedan hänvisar den till nästa osv.
  private String farg = "svart";
  private int bredd = 1; // pixlar

  // null-constructor
  public NPolylinje () {
    this.horn = null;
  }

  // Constructor som skapar en polylinje i form av noder från en array of hörn som argument
  public NPolylinje (Punkt[] horn){
    if (horn.length > 0) {
      Nod nod = new Nod (new Punkt (horn[0])); // create a Node from the first element in the array that was sent to the constructor
      this.horn = nod; // set the first Node in the NPolylinje as the newly created Node (see comment above).
      int pos = 1;
      while (pos < horn.length){ // While-loop that uses the nod reference (not the this.horn reference!) to create new Nodes and put these to in nastaNod variable.
        nod.nastaNod = new Nod (new Punkt (horn[pos++]));
        nod = nod.nastaNod;
      }
    }
  }

  public String toString(){
//    StringBuilder s = new StringBuilder();
//    s.append("[");
//    for(int i = 0; i < horn.length; i++){
//      s.append(this.horn[i] + ", ");
//    }
//    s.append("farg = " + getFarg() + ", bredd = " + getBredd() + "]");
//    String string = s.toString();
//    return string;
    StringBuilder s = new StringBuilder();
    s.append("[");
    Nod currentNode = this.horn; // currentNode = first Node in NPolylinje
    while(currentNode.nastaNod != null){
      s.append(currentNode.horn + ", ");
      currentNode = currentNode.nastaNod;
    }
    s.append("farg = " + this.farg + ", bredd = " + this.bredd + "]");

    return s.toString();
  }

  // ytterligare kod här
  public int amountOfNodes(){
    int antalNoder = 0;
    Nod currentNode = this.horn; // currentNode = first Node in NPolylinje
    while(currentNode.nastaNod != null){
      antalNoder++;
      currentNode = currentNode.nastaNod;
    }
    antalNoder++;
    return antalNoder;
  }

  // deep-copy method of returning array of Punkter
  public Punkt[] getHorn (){
    Punkt[] copyPunkter = new Punkt[amountOfNodes()];
    Nod currentNode = this.horn; // currentNode = first Node in NPolylinje
//    copyPunkter[0] = new Punkt (currentNode.horn);
    for(int i = 0; i < amountOfNodes(); i++){
      copyPunkter[i] = new Punkt (currentNode.horn);
      currentNode = currentNode.nastaNod;
    }
    return copyPunkter;
  }

  public String getFarg (){
    return this.farg;
  }

  public int getBredd (){
    return this.bredd;
  }

  public double langd (){
    double langd = 0; // = 0;
    Nod currentNode = this.horn; // currentNode = first Node in NPolylinje
    while(currentNode.nastaNod != null){
      // currentNode.horn + currentNode.nastaNod.horn == punkterna i två efterföljande noder.
      langd = langd + currentNode.horn.avstand(currentNode.nastaNod.horn);
      currentNode = currentNode.nastaNod;
    }
    return langd;
  }

  public void setFarg (String farg){
    this.farg = farg;
  }

  public void setBredd (int bredd){
    this.bredd = bredd;
  }

  // Add a node in the beginning of NPolylinje using a new Punkt.
  public void laggTill (Punkt horn){

  }

  // Add a node in front of a specified Punkt (ie a Node)
  public void laggTillFramfor (Punkt horn, String hornNamn){

  }

  // Remove a certain node
  public void taBort (String hornNamn){

  }

//  public java.util.Iterator<Punkt> iterator (){

//  }

}
