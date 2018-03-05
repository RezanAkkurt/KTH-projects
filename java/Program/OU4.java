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

    System.out.println("INSERT TWO WHOLE NUMBERS!");
    String number1 = in.next();
    String number2 = in.next();
    in.nextLine();
    System.out.println(); // Tom rad
    System.out.println(number1);
    System.out.println(number2);
    System.out.println();
    // addera heltalen och visa resultatet
    String summa = StringArithmetic.add(number1, number2);
    StringArithmetic.show(number1, number2, summa, '+');
    // subtrahera heltalen och visa resultatet
    String diff = StringArithmetic.sub(number1, number2);
    System.out.println();
    // StringArithmetic.show (number1, number2, summa, '+');
    StringArithmetic.show(number1, number2, diff, '-');

    // koden här
  }
}
