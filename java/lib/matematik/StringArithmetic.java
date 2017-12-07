// StringArithmetic.java

/*
Contains class and methods to use when doing arithmetic operations using strings.

Can also instead use bigInt class in standard library
 */

package lib.matematik;

public class StringArithmetic{

/*
  public static String add (String tal1, String tal2){
    StringBuilder result = new StringBuilder();
    int carry = 0;
    int i;
    int sum = 0;
    if (tal1.length() > tal2.length()){
      i = tal1.length();
      tal2 = sattLen(tal2, tal1.length() - tal2.length());
    }
    else{
      i = tal2.length();
      tal1 = sattLen(tal1, tal2.length() - tal1.length());
    }
    for(int j = i - 1; j >= 0; j--){
      int number1 = Character.getNumericValue(tal1.charAt(j));
      int number2 = Character.getNumericValue(tal2.charAt(j));
      sum = carry + number1 + number2;
      if (sum >= 10){
        carry = 1;
        sum = sum - 10;
      }
      else{
        carry = 0;
      }
      result.insert(0, sum);
    }
    if(carry == 1){
      result.insert(0, carry);
    }
    return result.toString();
  }
*/

  // Add number1 to number2
  public static String add (String tal1, String tal2){
    StringBuilder result = new StringBuilder();
    int sum = 0;
    int carry = 0;
    int pos1 = tal1.length() - 1;
    int pos2 = tal2.length() - 1;

    while(pos1 >= 0 && pos2 >= 0){
      int number1 = tal1.charAt(pos1) - 48;
      int number2 = tal2.charAt(pos2) - 48;
      sum = carry + number1 + number2;
      if(sum >= 10){
        carry = 1;
        sum = sum - 10;
      }
      else{
        carry = 0;
      }
      result.insert(0, sum);
      pos1--;
      pos2--;
    }

    while(pos1 >= 0){
      int number1 = tal1.charAt(pos1) - 48;
      sum = carry + number1;
      if(sum >= 10){
        carry = 1;
        sum = sum - 10;
      }
      else{
        carry = 0;
      }
      result.insert(0, sum);
      pos1--;
    }

    while(pos2 >= 0){
      int number2 = tal2.charAt(pos2) - 48;
      sum = carry + number2;
      if(sum >= 10){
        carry = 1;
        sum = sum - 10;
      }
      else{
        carry = 0;
      }
      result.insert(0, sum);
      pos2--;
    }

    return result.toString();
  }

  // Subtract number1 from number2 - requires number1 to be larger than number2
  public static String sub (String tal1, String tal2){
    StringBuilder result = new StringBuilder();
    int diff = 0;
    int carry = 0;
    int pos1 = tal1.length() - 1;
    int pos2 = tal2.length() - 1;

    while(pos1 >= 0 && pos2 >= 0){
      int number1 = tal1.charAt(pos1) - 48;
      int number2 = tal2.charAt(pos2) - 48;
      diff = carry + number1 - number2;
      if(diff < 0){
        carry = -1;
        diff = diff + 10;
      }
      else{
        carry = 0;
      }
      result.insert(0, diff);
      pos1--;
      pos2--;
    }

    while(pos1 >= 0){
      int number1 = tal1.charAt(pos1) - 48;
      diff = carry + number1;
      if(diff < 0){
        carry = -1;
        diff = diff + 10;
      }
      else{
        carry = 0;
      }
      result.insert(0, diff);
      pos1--;
    }


/*
    while(pos2 >= 0){
      int number2 = tal2.charAt(pos2) - 48;
      diff = carry + number2;
      if(diff < 0){
        carry = -1;
        diff = diff + 10;
      }
      else{
        carry = 0;
      }
      result.insert(0, diff);
      pos2--;
    }

*/
    return result.toString();
  }



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
    System.out.println ("  " + tal1);
    System.out.println ("" + operator + " " + tal2);
    for (int i = 0; i < maxLen + 2; i++){
      System.out.print ("-");
    }
    System.out.println ();
    System.out.println ("  " + resultat + "\n");
  }

  public static String sattLen (String s, int antal){
    StringBuilder sb = new StringBuilder (s);
    for (int i = 0; i < antal; i++){
      sb.insert (0, " ");
    }
    return sb.toString ();
  }
}
