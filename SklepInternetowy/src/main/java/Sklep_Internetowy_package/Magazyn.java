package Sklep_Internetowy_package;


public class Magazyn {

    private int magazyn_id;
    private double powierzchnia;
    private String miasto;
    private String ulica;
    private int numer;

    public Magazyn(int magazyn_id, double powierzchnia, String miasto, String ulica, int numer) {
        super();
        this.magazyn_id = magazyn_id;
        this.powierzchnia = powierzchnia;
        this.miasto = miasto;
        this.ulica = ulica;
        this.numer = numer;
    }

    public Magazyn() {

    }
    public int getMagazyn_id() {
        return magazyn_id;
    }
    public void setMagazyn_id(int magazyn_id) {
        this.magazyn_id = magazyn_id;
    }
    public double getPowierzchnia() {
        return powierzchnia;
    }
    public void setPowierzchnia(double powierzchnia) {
        this.powierzchnia = powierzchnia;
    }
    public String getMiasto() {
        return miasto;
    }
    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }
    public String getUlica() {
        return ulica;
    }
    public void setUlica(String ulica) {
        this.ulica = ulica;
    }
    public int getNumer() {
        return numer;
    }
    public void setNumer(int numer) {
        this.numer = numer;
    }
    @Override
    public String toString() {
        return "Magazyn [magazyn_id=" + magazyn_id + ", powierzchnia=" + powierzchnia + ", miasto=" + miasto
                + ", ulica=" + ulica + ", numer=" + numer + "]";
    }

}
