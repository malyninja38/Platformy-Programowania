import java.util.Iterator;

public class Lab2 {

    public static void main(String[] args)
    {
        Firma fi = new Firma();

        System.out.println();
        fi.ilosc_pracownikow();
        System.out.println();

        //fi.dodaj_do_firmy();

        //System.out.println();
        //fi.ilosc_pracownikow();
        //System.out.println();

        System.out.println("Wypisywanie przy użyciu funkcji: ");
        fi.wyswietl();
        System.out.println();

        System.out.println("Wypisywanie przy użyciu iteratora: ");
        for(Pracownik p : fi){
            System.out.println(p.getImie() + " " + p.getNazwisko() + " " + p.getStanowisko() + " " + p.getPensja());
        }
        System.out.println();

        System.out.println("Wypisywanie przy użyciu iteratora wszystkich dyrektorów: ");
        Iterator<Pracownik> it = fi.iterator(Stanowisko.DYREKTOR);
        while(it.hasNext()){
            Pracownik p = it.next();
            System.out.println(p.getImie() + " " + p.getNazwisko() + " " + p.getStanowisko() + " " + p.getPensja());
        }
        System.out.println();

        System.out.println("Srednia pensja wszystkich pracowników: " + fi.srednia_wszystkich());
        System.out.println();

        System.out.println("Srednia pensja wszystkich dyrektorów: " + fi.srednia_stanowiska(Stanowisko.DYREKTOR));
        System.out.println();
    }

}
