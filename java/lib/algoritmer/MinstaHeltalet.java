// MinstaHeltalet.java

package lib.algoritmer;

public class MinstaHeltalet{
  // min returnerar det minsta elementet i en sekventiell samling.
  // Om samlingen är tom, kastas ett undantag av typen IllegalArgumentException.
  public static int min (int[] element) throws IllegalArgumentException {
    if (element.length == 0) {
      throw new IllegalArgumentException ("tom samling, din idiot!");
    }
    // hör ihop med spårutskriften 2:
    // int antalVarv = 1;
    int[] sekvens = element;
    int antaletPar = sekvens.length / 2;
    int antaletOparadeElement = sekvens.length % 2;
    int antaletTankbaraElement = antaletPar + antaletOparadeElement;
    int[] delsekvens = new int[antaletTankbaraElement];
    int i = 0;
    int j = 0;

    while (antaletPar >= 1) {
      // skilj ur en delsekvens med de tänkbara elementen
      i = 0;
      j = 0;

      while (j < antaletPar) {
        /* boolean statement ? true result : false result;
           Nedan betyder om sekvens[i] är mindre än sekvens[i+1] -> delsekvens[j++] = sekvens[i]
           om sekvens[i] inte är mindre än sekvens[i+1] -> delsekvens[j++] = sekvens[i+1] */
        delsekvens[j++] = (sekvens[i] < sekvens[i + 1])? sekvens[i] : sekvens[i + 1];
        i += 2;
      }

      if (antaletOparadeElement == 1){
        delsekvens[j] = sekvens[sekvens.length - 1]; // istället för i sekvens.length - 1
      }

      // utgå nu ifrån delsekvensen
      sekvens = delsekvens;
      antaletPar = antaletTankbaraElement / 2;
      antaletOparadeElement = antaletTankbaraElement % 2;
      antaletTankbaraElement = antaletPar + antaletOparadeElement;
      /* delsekvens = new int[antaletTankbaraElement]; */

      // spårutskrift 1 – för att följa sekvensen
      System.out.println();
      System.out.println (java.util.Arrays.toString (sekvens));

      // spårutskrift 2 - för att avsluta loopen i förväg
      // (för att kunna se vad som händer i början)
      // if (antalVarv++ == 10)
      // System.exit (0);

    }

    // sekvens[0] är det enda återstående tänkbara elementet
    // - det är det minsta elementet
    return sekvens[0];

  }

  public static int minUpdateStrat(int[] element) throws IllegalArgumentException {
    if (element.length == 0) {
      throw new IllegalArgumentException ("tom samling, din idiot!");
    }

    int minstaHeltalet = element[0];

    for(int i = 1; i < element.length; i++){
      if(element[i] < minstaHeltalet){
        minstaHeltalet = element[i];
      }
    }

    return minstaHeltalet;
  }

}
