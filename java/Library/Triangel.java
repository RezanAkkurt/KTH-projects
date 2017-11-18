// Triangel.java


public class Triangel{
  public static double omkrets(double a, double b, double c){
    return (a + b + c);
  }
  public static double semiperimeter(double a, double b, double c){
    double s = (1/2)*(Triangel.omkrets(a, b, c));
    return s;
  }
  public static double hojd_a(double a, double b, double c){
    double s = Triangel.semiperimeter(a, b, c);
    double hojd_a = (2/a)*Math.sqrt(s*(s-a)*(s-b)*(s-c));
    return hojd_a;
  }
}
