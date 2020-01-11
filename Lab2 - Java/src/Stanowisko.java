
public enum Stanowisko {
    DYREKTOR (1, "Dyrektor zakładu"),
    PRACOWNIK (2, "Pracownik zakładu"),
    SEKRETARKA (3, "Sekretarka dyrektora"),
    SPRZĄTACZKA (4, "Sprzątaczka");

    private final int number;
    private final String opis;

    Stanowisko(int number, String opis) {
        this.number = number;
        this.opis = opis;
    }

    public int getNumber() {
        return number;
    }
}
