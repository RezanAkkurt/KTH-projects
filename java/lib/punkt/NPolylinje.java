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
    StringBuilder s = new StringBuilder();
    if(this.horn != null){
      s.append("[");
      Nod currentNode = this.horn; // currentNode = first Node in NPolylinje
      while(currentNode.nastaNod != null){
        s.append(currentNode.horn + ", ");
        currentNode = currentNode.nastaNod;
      }
      s.append(currentNode.horn + ", "); // Add the last node since the while-loop does not cover this node (because the nastaNod of the last node is = null)
      s.append("farg = " + this.farg + ", bredd = " + this.bredd + "]");
    } else {
      s.append("Det finns inga horn i polylinjen!");
    }

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

  // Remove a given node
  public void taBort (String hornNamn){
    // Detta går även att göra på annat sätt genom amountOfNodes metoden(genom for-loop?)

    Nod currentNode = this.horn; // currentNode = first Node in NPolylinje / De pekar till samma objekt

    if(currentNode.horn.getNamn().equals(hornNamn)){ // Kollar första noden i polylinjen som ska tas bort
      this.horn = currentNode.nastaNod; // I så fall sätts polylinjens första nod till att vara den andra noden. (om det inte finns en andra så blir this.horn = null)
    }

    while(currentNode.nastaNod != null){ // While-loopen körs så länge det finns en nästa nod i polylinjen

      if(currentNode.nastaNod.horn.getNamn().equals(hornNamn)){
        if(currentNode.nastaNod.nastaNod == null){ //Kollar om noden som ska tas bort är den sista Noden i polylinjen
          currentNode.nastaNod = null; // Om det är den sista noden i polylinjen som ska tas bort så sätts den nästsista nodens nastaNod = null;
        } else{
          currentNode.nastaNod = currentNode.nastaNod.nastaNod; // Hoppar över den Nod som ska tas bort.
        }
      }
      if(currentNode.nastaNod != null){ //Kollar så att det finns en nästa nod så att vi inte får NullPointerException
        currentNode = currentNode.nastaNod; // Om det finns en nästa nod i polylinjen så ska currentNode uppdateras till den nästa noden i linjen.
      }
    }

  }

//  public java.util.Iterator<Punkt> iterator (){

//  }

}
