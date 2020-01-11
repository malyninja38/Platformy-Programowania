/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.util.ArrayList;
        import java.util.*;
        import java.math.BigInteger;
        import java.lang.Object;
        import java.nio.file.Files;
        import java.nio.file.Path;
        import java.nio.file.Paths;
        import java.util.stream.Collectors;
        import java.util.Random;


public class Lab1 {

    public static void zad1(){

        int n = 1000000;

        long czasRozpoczecia = System.currentTimeMillis();

        //int[] tab = new int[n];   // zad 1a
        //ArrayList<Integer> tab2 = new ArrayList<Integer>();  // zad 1b
        //ArrayList<Integer> tab3 = new ArrayList<Integer>(n);  // zad 1c
        //LinkedList<Integer> tab4 = new LinkedList<Integer>();  // zad 1d

        for(int i=0; i<n; i++){
            //tab[i] = i+1;      // zad 1a
            //tab2.add(i+1);     // zad 1b
            //tab3.add(i+1);     // zad 1c
            //tab4.add(i+1);     // zad 1d
        }

        long czasZakonczenia = System.currentTimeMillis();
        long czasTrwania = czasZakonczenia - czasRozpoczecia;
        System.out.println("Czas trwania: " + czasTrwania);
    }



    public static BigInteger silnia_rekurencyjna (BigInteger n) {
        BigInteger zero = new BigInteger("0");
        BigInteger one = new BigInteger("1");
        if (n.equals(zero)){
            return one;
        }
        else {
            return  n.multiply(silnia_rekurencyjna(n.subtract(one)));
        }
    }

    public static void zad2(){

        long czasRozpoczecia = System.currentTimeMillis();

        BigInteger bigNumber = new BigInteger("8000");    // 5k - 134s
        System.out.println("Wynik: " + silnia_rekurencyjna(bigNumber));

        long czasZakonczenia = System.currentTimeMillis();
        long czasTrwania = czasZakonczenia - czasRozpoczecia;
        System.out.println("Czas trwania: " + czasTrwania);
    }

    public static void zad2iteracyjnie(){
        BigInteger number = new BigInteger("5");
        BigInteger res = new BigInteger("1");
        BigInteger incr = new BigInteger("1");
        BigInteger k = new BigInteger("0");
        BigInteger zero = new BigInteger("0");

        long timeStart = System.nanoTime();

        if(!number.equals(zero)) {
            do {
                k = k.add(incr);
                res = res.multiply(k);
            }
            while (!k.equals(number));
        }

        long timeStop = System.nanoTime() - timeStart;
        System.out.println(number + "!= " + res);
        System.out.println("Czas: " + timeStop);
    }



    public static Map <String, Integer> sortByValue (Map <String, Integer> unsortMap) {
        List < Map.Entry<String, Integer> > list =  new LinkedList <Map.Entry<String, Integer> >(unsortMap.entrySet());

        // Map.Entry  to klucz i wartość połączone razem w klasę, bo można było umieścić je np. w liście
        //entrySet to "jednostka" tej klasy -> zamiast używać osobno key i value używamy entrySet

        Collections.sort (list, new Comparator<Map.Entry<String, Integer>>() {
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2)
                    {  return (o2.getValue()).compareTo(o1.getValue());  }                                       // posortowane malejąco, jeśli najpierw o1 a potem o2 to posortowane rosnąco
                }
        );

        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    public static void zad3() {
        try {
            Map<String, Integer> uwords = new HashMap<>();

            List<String> fileLines =  Files.readAllLines(new File("Macbeth.txt").toPath());
            ArrayList<String> words = new ArrayList<>();

            for (String line : fileLines) {

                line = line.toLowerCase();
                String[] lineWords = line.split("\\W+");

                for (String word : lineWords) {

                    if (word.length() >= 3)
                    {
                        if (!uwords.containsKey(word)) { uwords.put(word, 1); }
                        else
                        {
                            Integer integer = uwords.get(word);                       // ilość wystąpień
                            uwords.replace(word, integer, integer+1);       // zwieksza ilosc wystąpień o jeden
                        }
                    }
                }
            }

            System.out.println("Ilość wszystkich słów: " + fileLines.size());
            System.out.println("Ilość unikalnych słów: " + uwords.size());

            // ZADANIE 4

            Map<String, Integer> sortedMap = sortByValue(uwords);                               // <--- wywołuje funkcję sortującą mapę według wartości

            System.out.println("Najczesciej wystepujace slowa to: ");

            int i = 0;
            for (Map.Entry<String, Integer> entry : sortedMap.entrySet())
            {
                System.out.println("Słowo: " + entry.getKey() + ", ilość wystąpień: " + entry.getValue());
                i ++;
                if(i == 8) break;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }



    public static int randomNumber(){
        Random rand = new Random();
        int n = rand.nextInt(50);
        return n;
    }

    public static void insertSort (int[] wejscie){
        for (int i = 1; i < wejscie.length; i++) {              // pobieramy elementy z części nieposortowanej tablicy
            int liczba = wejscie[i];                            // zapisujemy element w zmiennej
            int j = i;                                          // oraz jego indeks w tablicy
            while (( j > 0) && (wejscie[j-1] > liczba)) {       // w pętli "robimy" dla niego miejsce w nieposortowanej tablicy
                wejscie[j] = wejscie[j-1];
                j--;
            }
            wejscie[j] = liczba;                               // wstawiamy go na odpowiednie miejsce
        }
    }

    private static void merge(int[] tab, int[]t, int pocz, int sr, int kon) {
        int i,j,q;
        for (i=pocz; i<=kon; i++) { t[i]=tab[i]; }    // Skopiowanie danych do tablicy pomocniczej
        i=pocz; j=sr+1; q=pocz;                       // Ustawienie wskaźników tablic
        while (i<=sr && j<=kon) {                     // Przenoszenie danych z sortowaniem ze zbiorów pomocniczych do tablicy głównej
            if (t[i]<t[j])
                tab[q++]=t[i++];
            else
                tab[q++]=t[j++];
        }
        while (i<=sr) tab[q++]=t[i++];                // Przeniesienie nie skopiowanych danych ze zbioru pierwszego w przypadku, gdy drugi zbiór się skończył
    }

    public static void mergesort(int[] tab, int[]t, int pocz, int kon) {
        int sr;
        if (pocz < kon) {
            sr = (pocz+kon)/2;
            mergesort(tab, t, pocz, sr);           // Dzielenie lewej części
            mergesort(tab, t, sr+1, kon);    // Dzielenie prawej części
            merge(tab, t, pocz, sr, kon);          // Łączenie części lewej i prawej
        }
    }

    public static void zad5(){

        long czasRozpoczecia = System.currentTimeMillis();

        int[] tablica = new int[500];
        int[] pomocnicza = new int[500];
        
        for(int i=0; i < 500; i++){
            tablica[i] = randomNumber();
        }

        //insertSort(tablica);
        //mergesort(tablica, pomocnicza, 0, 499);

        for(int x : tablica) System.out.print (x + " ");
        System.out.println ();

        long czasZakonczenia = System.currentTimeMillis();
        long czasTrwania = czasZakonczenia - czasRozpoczecia;
        System.out.println("Czas trwania: " + czasTrwania);
    }




    public static void main(String[] args) {
        // TODO code application logic here

        // ZADANIE 1
        //zad1();

        // ZADANIE 2
        // zad2();
         //zad2iteracyjnie();

        // ZADANIE 3 i 4
        //zad3();

        // ZADANIE 5
        zad5();

    }
}




