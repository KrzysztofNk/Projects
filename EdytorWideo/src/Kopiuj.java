import javax.swing.*;
import java.awt.*;

public class Kopiuj implements Dzialanie {
    private double czasOd;
    private double czasDo;


    public Kopiuj(double czasOd, double czasDo){
        this.czasDo = czasDo;
        this.czasOd = czasOd;
    }

    @Override
    public void cofnij() {
        GUI.lewyPanel.usunZListy(czasOd + "-" + czasDo + ".mp4");
        System.out.println(this);
    }



    @Override
    public void wykonaj() {
    GUI.lewyPanel.dodajDoListy(czasOd + "-" + czasDo + ".mp4");
    }



    @Override
    public String toString() {
        return "cofnięcie kopiowania czas od " + czasOd + "- czas do " + czasDo;
    }
}