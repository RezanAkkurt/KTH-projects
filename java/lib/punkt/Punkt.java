// Declaring class for Punkt.

package lib.punkt;

public class Punkt{

  // Private field variables so that one cannot change x and y coordinates in
  // main method by writing p.koordinater[0] = 12;
  private String namn;
  private int[] koordinater = new int[2];

  // Constructor that creates an object Punkt but doesnt initizialize it.
  // namn = null, koordinater[0] = 0 and koordinater[1] = 0;
  public Punkt(){}

  // Constructor using variables as arguments
  public Punkt(String sNamn, int x, int y){
    namn = sNamn;
    koordinater[0] = x;
    koordinater[1] = y;
  }

  // Constructor using another Punkt as argument
  public Punkt(Punkt p){
    namn = p.namn;
    koordinater[0] = p.koordinater[0];
    koordinater[1] = p.koordinater[1];
  }

  public String toString(){
    String s = "(" + getNamn() + ": " + getX() + ", " + getY() + ")";

    return s;
  }

  public String getNamn(){
    return this.namn;
  }

  public int getX(){
    return this.koordinater[0];
  }

  public int getY(){
    return this.koordinater[1];
  }

  public double avstand(Punkt p){

    double d = Math.sqrt((this.getX() - p.getX()) * (this.getX()-p.getX())
                       + (this.getY() - p.getY()) * (this.getY() - p.getY()));

    return d;
  }

  public boolean equals(Punkt p){
    boolean b = (getX() == p.getX()) && (getY() == p.getY());

    return b;
  }

  public void setX(int x){
    koordinater[0] = x;
  }

  public void setY(int y){
    koordinater[1] = y;
  }

}
