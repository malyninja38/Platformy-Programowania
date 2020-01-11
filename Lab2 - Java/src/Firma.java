import java.util.*;

public class Firma implements Iterable <Pracownik> {

    ArrayList<Pracownik> hsp = new ArrayList<Pracownik>();

    public Firma() {
        Pracownik p1 = new Pracownik("Ania", "Kowalska", Stanowisko.SEKRETARKA, 3000);
        Pracownik p2 = new Pracownik("Adam", "Nowak", Stanowisko.DYREKTOR, 5000);
        Pracownik p3 = new Pracownik("Julia", "Kot", Stanowisko.SPRZĄTACZKA, 2000);
        Pracownik p4 = new Pracownik("Piotr", "Miły", Stanowisko.PRACOWNIK, 4000);
        Pracownik p5 = new Pracownik("Tomasz", "Laka", Stanowisko.DYREKTOR, 3000);

        hsp.add(p1);
        hsp.add(p2);
        hsp.add(p3);
        hsp.add(p4);
        hsp.add(p5);
    }

    public boolean sprawdz_czy_juz_jest(Pracownik p) {
        for (Pracownik temp : hsp) {
            if (temp.getImie().equals(p.getImie()) && temp.getNazwisko().equals(p.getNazwisko())) {
                return true;
            }
        }
        return false;
    }

    public void dodaj_do_firmy() {
        System.out.println("Podaj dane w kolejnosci imię, nazwisko, stanowisko (jako numer), pensja: ");

        String im, nazw;
        int stan, pensja;
        Stanowisko stanowisko;

        Scanner odczyt = new Scanner(System.in);
        im = odczyt.nextLine();
        nazw = odczyt.nextLine();
        stan = odczyt.nextInt();
        pensja = odczyt.nextInt();

        if (stan == Stanowisko.DYREKTOR.getNumber()) {
            stanowisko = Stanowisko.DYREKTOR;
        } else if (stan == Stanowisko.PRACOWNIK.getNumber()) {
            stanowisko = Stanowisko.PRACOWNIK;
        } else if (stan == Stanowisko.SEKRETARKA.getNumber()) {
            stanowisko = Stanowisko.SEKRETARKA;
        } else if (stan == Stanowisko.SPRZĄTACZKA.getNumber()) {
            stanowisko = Stanowisko.SPRZĄTACZKA;
        } else {
            stanowisko = Stanowisko.PRACOWNIK;
        }

        Pracownik p = new Pracownik(im, nazw, stanowisko, pensja);

        if (sprawdz_czy_juz_jest(p) == true) {
            throw new IllegalStateException("Taka osoba jest juz w bazie!");
        }

        hsp.add(p);
    }

    public void ilosc_pracownikow() {
        System.out.println("Ilosc pracownikow to: " + hsp.size());
    }

    public void wyswietl() {
        for (Pracownik temp : hsp) {
            System.out.println(temp.getImie() + " " + temp.getNazwisko() + " " + temp.getStanowisko() + " " + temp.getPensja());
        }
    }

    @Override public Iterator<Pracownik> iterator() {
        return hsp.iterator();
    }

    public Iterator<Pracownik> iterator(Stanowisko s) {
        return hsp.stream().filter(str -> str.getStanowisko().equals(s)).iterator();
    }

    public int srednia_wszystkich(){

        int srednia = 0;
        for(Pracownik p : hsp){
            srednia = srednia + p.getPensja();
        }
        return srednia = srednia / hsp.size();
    }

    public int srednia_stanowiska(Stanowisko s){
        int srednia = 0;
        int i = 0;
        Iterator<Pracownik> it = this.iterator(s);
        while(it.hasNext()){
            Pracownik p = it.next();
            i++;
            srednia = srednia + p.getPensja();
        }
        return srednia = srednia / i;
    }
}
