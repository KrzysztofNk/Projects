import javax.swing.*;
import java.awt.*;

public class DodajTekst implements Dzialanie {
    private int x;
    private int y;
    private double czasTrwania;
    private String st;
    private long poczatek = 0;
    private final int KONWERTER = 1000;


    public DodajTekst(int x, int y,double czasTrwania,JTextField st){
        this.x = x;
        this.y = y;
        this.czasTrwania = czasTrwania;
        this.st = st.getText();
    }

    @Override
    public void cofnij() { System.out.println(this); }

    @Override
    public void wykonaj() {
        poczatek = GUI.srodkowyPanel.mediaPlayer.getTime();
        GUI.srodkowyPanel.mediaPlayer.setMarqueeText(st);
        GUI.srodkowyPanel.mediaPlayer.setMarqueeSize(60);
        GUI.srodkowyPanel.mediaPlayer.setMarqueeOpacity(70);
        GUI.srodkowyPanel.mediaPlayer.setMarqueeColour(Color.green);
        GUI.srodkowyPanel.mediaPlayer.setMarqueeTimeout((int)(czasTrwania* KONWERTER));
        GUI.srodkowyPanel.mediaPlayer.setMarqueeLocation(x, y);
        GUI.srodkowyPanel.mediaPlayer.enableMarquee(true);
    }

    @Override
    public String toString() {
        return "cofnięto dodanie tekstu    x - " + x  + "   y - " + y + "    tekst - " + st +
                "   początek - " + poczatek + "ms "+"   czas trwania - " + czasTrwania* KONWERTER +"ms ";
    }
}