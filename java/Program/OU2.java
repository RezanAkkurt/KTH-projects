// OU2.java
// Detta program motsvarar programmet EnTriangelOchDessCirklar i uppgiften

class OU2{
  public static void main(String[]args){
    java.util.Scanner    in = new java.util.Scanner(System.in);
    in.useLocale(java.util.Locale.US);
    double a = 0;
    double b = 0;
    double c = 0;

    int giltigTriangel = 0;
    while(giltigTriangel == 0){

      System.out.println("Mata in triangelns tre langder (cm):");
      System.out.println();

      a = in.nextDouble();
      b = in.nextDouble();
      c = in.nextDouble();

      if(in.hasNextLine()){ // Metod som förhindrar att ifall man matar in för många temperaturer en vecka så lagras de i nästa vecka.
        in.nextLine();
      }

      System.out.println("Langden a ar: " + a + " cm");
      System.out.println("Langden b ar: " + b + " cm");
      System.out.println("Langden c ar: " + c + " cm");
      System.out.println();

      if((a+b)>c && (b+c)>a && (a+c)>b){
        System.out.println("Inmatade langder skapar en giltig triangel!");
        System.out.println();
        giltigTriangel = 1;
      }
      else{
        System.out.println("Inmatade langder skapar inte en giltig triangel!");
        System.out.println("Programmet startas om.");
        System.out.println();
        giltigTriangel = 0;
      }
    }

    System.out.println("Vi ar utanfor loopen!");
    System.out.println("Triangelns langder ar: " + a + " cm " + b + " cm " + c + " cm");

  }
}
