// OU4.java

/*******************************************************************************
OU4 - ALGORITMER I SAMBAND MED OBJEKT
- Räkna med teckensträngar

Ett problem: utför aretmetiska operationer i samband med naturliga heltal givna
som teckensträngar.

Två naturliga heltal är givna som teckensträngar av godtycklig längd.

Man ska utföra olika aritmetiska operationer i samband med dessa heltal.
I en operation utgår man ifrån de siffror som finns i givna teckensträngar,
och bestämmer siffrorna i resultatet, en siffra i taget.
På så sätt skapas en ny teckensträng, som representerar resultatet av operationen.

*******************************************************************************/
import lib.matematik.*;

public class OU4{
  public static void main(String[]args){
    // Inmatning av heltal som strings.
    java.util.Scanner in = new java.util.Scanner(System.in);
    in.useLocale(java.util.Locale.US);

    System.out.println("INSERT YOUR WHOLE NUMBERS!");
    String number1 = in.next();
    String number2 = in.next();

  }
}
