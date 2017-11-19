// Triangel.java
//
package Library.Matematik;

public class Triangel{
  public static double omkrets(double a, double b, double c){
    return (a + b + c);
  }
  public static double area(double a, double b, double c){
    double area = (a*hojd_a(a, b, c))/2;
    return area;
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
  public static double bisektris(double b, double c, double alfa){
    double p = 2 * b * c * Math.cos(alfa/2);
    double bis = p / (b + c);
    return bis;
  }
  public static double omskrivenCirkel(double a, double b, double c){
    double t = a * b * c;
    double s = Triangel.semiperimeter(a, b, c);
    double radie = t / (4 * Math.sqrt(s*(s - a)*(s - b)*(s - c)));
    return radie;
  }
  public static double inskrivenCirkel(double a, double b, double c){
    double s = Triangel.semiperimeter(a, b, c);
    double t = ((s - a)*(s - b)*(s - c))/s;
    double radie = Math.sqrt(t);
    return radie;
  }
}
