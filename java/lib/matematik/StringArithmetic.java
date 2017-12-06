// StringArithmetic.java

/*
Contains class and methods to use when doing arithmetic operations using strings.
 */

package lib.matematik;

public class StringArithmetic{

  public static String add (String tal1, String tal2){
    StringBuilder sb1 = new StringBuilder(tal1); //tal1
    StringBuilder sb2 = new StringBuilder(tal2); //tal2
    StringBuilder sb3 = new StringBuilder(); // resultatet av additionen
    int maxLength = Math.max(sb1.length(), sb2.length());
    for(int i = maxLength; i >= maxLength; i--){
      
    }
    return sb3.toString();
  }

//  public static String div (String tal1, String tal2){

//  }

  // show visar två givna naturliga heltal, och resultatet av en aritmetisk operation
  // utförd i samband med hetalen
  public static void show (String tal1, String tal2, String resultat, char operator){

    // sätt en lämplig längd på heltalen och resultatet
    int len1 = tal1.length ();
    int len2 = tal2.length ();
    int len = resultat.length ();
    int maxLen = Math.max (Math.max (len1, len2), len);
    tal1 = sattLen (tal1, maxLen - len1);
    tal2 = sattLen (tal2, maxLen - len2);
    resultat = sattLen (resultat, maxLen - len);
    // visa heltalen och resultatet
    System.out.println (" " + tal1);
    System.out.println ("" + operator + " " + tal2);
    for (int i = 0; i < maxLen + 2; i++){
      System.out.print ("-");
    }
    System.out.println ();
    System.out.println (" " + resultat + "\n");
  }

  public static String sattLen (String s, int antal){
    StringBuilder sb = new StringBuilder (s);
    for (int i = 0; i < antal; i++){
      sb.insert (0, " ");
    }
    return sb.toString ();
  }
}
