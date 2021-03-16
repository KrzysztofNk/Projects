import uk.co.caprica.vlcj.filter.VideoFileFilter;
import uk.co.caprica.vlcj.test.basic.PlayerVideoAdjustPanel;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

public class PrawyPanel<f> extends JFrame  {
    public PrawyPanel(JFrame okno) {
//tu jest sekcja paneli
        JPanel panel = new JPanel();
        panel.setBounds(975, 10, 200, 620);
        panel.setBackground(Color.gray);
        okno.add(panel);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton Przytnij = new JButton("Przytnij");
        panel.add(Przytnij);
//przycisk przytnij
        Przytnij.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUI.srodkowyPanel.cut();
            }
        });
// przyciski efekty, zatwierdź, do efektów (w prawym panelu)
        JToggleButton efekty = new JToggleButton("Efekty");
        panel.add(efekty);
        PlayerVideoAdjustPanel plVid = new PlayerVideoAdjustPanel(GUI.srodkowyPanel.mediaPlayer);
        JButton zatwierdz = new JButton("zatwierdz");
        zatwierdz.setSize(40,40);
        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());
        plVid.setBorder( BorderFactory.createEmptyBorder(0,0,-90,0) );
        jp.add(plVid,BorderLayout.NORTH);
        jp.add(zatwierdz,BorderLayout.SOUTH);
        panel.add(jp);
        jp.setVisible(false);

        efekty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(efekty.isSelected()){

                    jp.setVisible(true);

                }
                else{
                    jp.setVisible(false);

                }
            }
        });
//Przyciski dodaj, cofnij, do wstawiania tekstu
        JButton dodaj = new JButton("dodaj");
        JTextField x = new JTextField("300",3);
        JTextField y = new JTextField("400",3);
        JTextField czasTrwania = new JTextField("5",3);
        JTextField textWPoluTekstowym;
        text tekstDowyswietlenia = new text();
        dodaj.addActionListener(tekstDowyswietlenia);
        textWPoluTekstowym = new JTextField("dodaj tekst",16);
        textWPoluTekstowym.setBounds(10,50,180,30);
        dodaj.setBounds(10,90,180,30);
        panel.add(textWPoluTekstowym);
        panel.add(x);
        panel.add(y);
        panel.add(czasTrwania);
        panel.add(dodaj);


        dodaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int X = 0;
                int Y = 0;
                double czTrwania = 0;
                try {
                    X = Integer.parseInt(x.getText());
                    Y = Integer.parseInt(y.getText());
                    czTrwania = Double.parseDouble(czasTrwania.getText());
                }catch(Exception e1) {
                    System.out.println(e);
                }
                DodajTekst dodTekst = new DodajTekst(X,Y,czTrwania,textWPoluTekstowym);
                dodTekst.wykonaj();
                Stos.stos.push(dodTekst);
            }
        });


        JButton kopiujWideo = new JButton("kopiuj");
        JTextField czasOdPole = new JTextField("od",5);
        JTextField czasDoPole = new JTextField("do",5);
        panel.add(czasOdPole);
        panel.add(czasDoPole);
        panel.add(kopiujWideo);

        kopiujWideo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double czasOd=0.0;
                double czasDo=0.0;
                int konwerter =1000;

                try {
                    czasOd = Double.parseDouble(czasOdPole.getText());
                    czasDo = Double.parseDouble(czasDoPole.getText());

                    if(czasDo <= czasOd || GUI.srodkowyPanel.mediaPlayer.getLength() < czasDo*konwerter )
                    {
                        throw new Exception();
                    }

                }catch(Exception e1) {
                    System.out.println(e);
                }

                Kopiuj kopiuj = new Kopiuj(czasOd,czasDo);
                kopiuj.wykonaj();
                Stos.stos.push(kopiuj);
            }
        });


    }
}