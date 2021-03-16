package Sklep_Internetowy_package;

import java.sql.Date;


public class Pracownik {

    private int pracownik_id;
    private String imie;
    private String nazwisko;
    private String email;
    private String telefon;
    private String stanowisko;
    private Date data_urodzenia;
    private double pensja;
    private String nr_konta;
    private Integer magazyn_id;



    public Pracownik(int pracownik_id, String imie, String nazwisko, String email, String telefon, String stanowisko,
                     Date data_urodzenia, double pensja, String nr_konta, Integer magazyn_id) {
        super();
        this.pracownik_id = pracownik_id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.telefon = telefon;
        this.stanowisko = stanowisko;
        this.data_urodzenia = data_urodzenia;
        this.pensja = pensja;
        this.nr_konta = nr_konta;
        this.magazyn_id = magazyn_id;
    }



    public Pracownik() {

    }


    public int getPracownik_id() {
        return pracownik_id;
    }



    public void setPracownik_id(int pracownik_id) {
        this.pracownik_id = pracownik_id;
    }



    public String getImie() {
        return imie;
    }



    public void setImie(String imie) {
        this.imie = imie;
    }



    public String getNazwisko() {
        return nazwisko;
    }



    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }



    public String getTelefon() {
        return telefon;
    }



    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }



    public String getStanowisko() {
        return stanowisko;
    }



    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }



    public Date getData_urodzenia() {
        return data_urodzenia;
    }



    public void setData_urodzenia(Date data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }



    public double getPensja() {
        return pensja;
    }



    public void setPensja(double pensja) {
        this.pensja = pensja;
    }



    public String getNr_konta() {
        return nr_konta;
    }



    public void setNr_konta(String nr_konta) {
        this.nr_konta = nr_konta;
    }



    public Integer getMagazyn_id() {
        return magazyn_id;
    }



    public void setMagazyn_id(Integer magazyn_id) {
        this.magazyn_id = magazyn_id;
    }



    @Override
    public String toString() {
        return "Pracownik [pracownik_id=" + pracownik_id + ", imie=" + imie + ", nazwisko=" + nazwisko + ", email="
                + email + ", telefon=" + telefon + ", stanowisko=" + stanowisko + ", data_urodzenia=" + data_urodzenia
                + ", pensja=" + pensja + ", nr_konta=" + nr_konta + ", magazyn_id=" + magazyn_id + "]";
    }



}
