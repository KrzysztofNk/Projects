package Sklep_Internetowy_package;

public class Produkt {

    private int produkt_id;
    private String nazwa;
    private String opis;
    private int ilosc;
    private Integer magazyn_id;

    public Produkt() {

    }

    public Produkt(int produkt_id, String nazwa, String opis, int ilosc, Integer magazyn_id) {
        super();
        this.produkt_id = produkt_id;
        this.nazwa = nazwa;
        this.opis = opis;
        this.ilosc = ilosc;
        this.magazyn_id = magazyn_id;
    }

    public int getProdukt_id() {
        return produkt_id;
    }

    public void setProdukt_id(int produkt_id) {
        this.produkt_id = produkt_id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    public Integer getMagazyn_id() {
        return magazyn_id;
    }

    public void setMagazyn_id(Integer magazyn_id) {
        this.magazyn_id = magazyn_id;
    }

    @Override
    public String toString() {
        return "Produkt [produkt_id=" + produkt_id + ", nazwa=" + nazwa + ", opis=" + opis + ", ilosc=" + ilosc
                + ", magazyn_id=" + magazyn_id + "]";
    }

}
