// OU1.java
/*
Obligatorisk uppgift 1.
Uppgiften innefattar att skapa ett program där man matar in antal veckor och antal mätningar per vecka. Sedan ska man kunna
mata in temperaturen för varje mätning för att sedan få ut olika data för varje vecka samt hela mätperioden.
*/
import java.util.*; //import java.util. library. Dont have to write java.util. to use.

import static java.lang.System.out;

class OU1{
    public static void main(String[]args){

        System.out.println("Temperaturmatning!");
        System.out.println();

        java.util.Scanner    in = new java.util.Scanner(System.in);
        in.useLocale(java.util.Locale.US);

        // Mata in antal veckor och antal mätningar per vecka, lagra detta i heltalsvariabler
        System.out.println("Mata in antal veckor:");
        int antalVeckor = in.nextInt();
        in.nextLine();
        System.out.println("Mata in antal matningar per vecka");
        int antalMatningarPerVecka = in.nextInt();
        in.nextLine();
        System.out.println();

        // Skapa en tvådimensionell array vars storlek beror på antalVeckor och antalMatningarPerVecka
        double[][] t = // Deklarerar en array av datatyper double med två dimensioneller med referensen t
          new double[antalVeckor+1][antalMatningarPerVecka+1]; // Skapar själva arrayen med referensen t och specificerar hur stort minne som ska reserveras

        // Mata in temperaturerna
        for(int vecka=1; vecka < t.length; vecka++){
            System.out.println("Mata in " + antalMatningarPerVecka + " temperaturerna for vecka: " + vecka);
            for(int matning=1; matning < t[vecka].length; matning++){
              t[vecka][matning] = in.nextDouble();
            }
            if(in.hasNextLine()){ // Metod som förhindrar att ifall man matar in för många temperaturer en vecka så lagras de i nästa vecka.
                in.nextLine();
            }
        }

        System.out.println();

        // Räkna ut varje veckas lägsta temperatur
        double[] minT =
          new double[antalVeckor+1]; // Skapa en array med lika många platser som antal veckor. Denna array ska lagra varje veckas lägsta temperatur

        for(int vecka = 1; vecka < t.length; vecka++){
            minT[vecka] = t[vecka][1];
            for(int matningar = 2; matningar < t[vecka].length; matningar++){
                if (t[vecka][matningar] < minT[vecka]){
                    minT[vecka] = t[vecka][matningar];
                }
            }
            System.out.println("Lagsta Temperatur for vecka " + vecka + " ar " + minT[vecka]);
        }

        System.out.println();

        // Räkna ut varje veckas högsta temperatur
        double[] maxT =
          new double[antalVeckor+1]; // Skapar en array med lika många platser som det finns veckor. Här lagras varje veckas högsta temperatur.

        for(int vecka = 1; vecka < t.length; vecka++){
            maxT[vecka] = t[vecka][1];
            for(int matningar = 2; matningar < t[vecka].length; matningar++){
                if(t[vecka][matningar] > maxT[vecka]){
                    maxT[vecka] = t[vecka][matningar];
                }
            }
            System.out.println("Hogsta Temperatur for vecka " + vecka + " ar " + maxT[vecka]);
        }

        System.out.println();

        // Räkna ut varje veckas medeltemperatur
        double[] medT =
          new double[antalVeckor+1];

        for(int vecka = 1; vecka < t.length; vecka++){
            double sumT = t[vecka][1];
            for(int matningar = 2; matningar < t[vecka].length; matningar++){
                sumT = sumT + t[vecka][matningar];
            }
            medT[vecka] = sumT/antalMatningarPerVecka;
            System.out.println("Medeltemperatur for vecka " + vecka + " ar " + medT[vecka]);
        }

        System.out.println();


        // Räkna ut lägsta temperaturen under hela mätperioden
        double minTemp = minT[1];
        for(int vecka = 1; vecka < minT.length; vecka++){
            if(minTemp > minT[vecka]){
                minTemp = minT[vecka];
          }
        }
        System.out.println("Lagsta temperaturen under hela matperioden ar: " + minTemp);


        // Räkna ut högsta temperaturen under hela mätperioden
        double maxTemp = maxT[1];
        for(int vecka = 1; vecka < maxT.length; vecka++){
            if(maxTemp < maxT[vecka]){
                maxTemp = maxT[vecka];
          }
        }
        System.out.println("Hogsta temperaturen under hela matperioden ar: " + maxTemp);


        // Räkna ut medeltemperaturen av alla mätningar under mämatperioden
        double medTemp = 0;
        double sumMedTemp = medT[1];
        for(int vecka = 2; vecka < medT.length; vecka++){
            sumMedTemp = sumMedTemp + medT[vecka];
        }
        medTemp = sumMedTemp/antalVeckor;
        System.out.println("Medeltemperaturen under hela matperioder ar: " + medTemp);

    }


}
