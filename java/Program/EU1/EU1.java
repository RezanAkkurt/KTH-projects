// EU1.java

import lib.algoritmer.MinstaHeltalet;

class EU1{
  public static void main(String[]args){
    int[] element1 = new int[16];
    int[] element2 = new int[19];

    int minstaHeltalet = MinstaHeltalet.min(element1);

    System.out.println(minstaHeltalet);

  }
}
