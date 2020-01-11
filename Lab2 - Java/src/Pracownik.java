
public class Pracownik extends Osoba {
    private Stanowisko stanowisko;
    private int Pensja;

    public Pracownik(String imie, String nazwisko, Stanowisko stanowisko, int pensja) {
        super(imie, nazwisko);
        this.stanowisko = stanowisko;
        this.Pensja = pensja;
    }

    public Stanowisko getStanowisko() {
        return stanowisko;
    }

    public int getPensja() {
        return Pensja;
    }
}
