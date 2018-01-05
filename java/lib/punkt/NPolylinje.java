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
  private Nod horn;
  private String farg = "svart";
  private int bredd = 1; // pixlar

  // null-constructor
  public NPolylinje () {
    this.horn = null;
  }

  // Constructor som skapar en polylinje i form av noder av en array of hörn
  public NPolylinje (Punkt[] horn){
    if (horn.length > 0) {
      Nod nod = new Nod (new Punkt (horn[0]));
      this.horn = nod;
      int pos = 1;
      while (pos < horn.length){
        nod.nastaNod = new Nod (new Punkt (horn[pos++]));
        nod = nod.nastaNod;
      }
    }
  }

  // ytterligare kod här
  public Punkt[] getHorn (){

  }

  public String getFarg (){
    return this.farg;
  }

  public int getBredd (){
    return this.bredd;
  }

  public double langd (){

  }

  public void setFarg (String farg){

  }

  public void setBredd (int bredd){

  }

  public void laggTill (Punkt horn){

  }

  public void laggTillFramfor (Punkt horn, String hornNamn){

  }

  public void taBort (String hornNamn){

  }

  public java.util.Iterator<Punkt> iterator (){
    
  }

}
