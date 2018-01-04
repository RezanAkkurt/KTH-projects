import lib.punkt.PolylinjeInterface;
import lib.punkt.Punkt;

public class NPolylinje implements PolylinjeInterface {

  private static class Nod {
    public Punkt horn;
    public Nod nastaNod;
    public Nod (Punkt horn) {
      this.horn = horn;
      nastaNod = null;
    }
  }

  private Nod horn;
  private String farg = "svart";
  private int bredd = 1; // pixlar

  public NPolylinje () {
    this.horn = null;
  }

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

}
