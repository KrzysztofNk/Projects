import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class LewyPanel {
    public DefaultListModel<String>[] pliki;
    public JList<String> list;
    public static final int FILE_PATH = 0;
    public static final int FILE_NAME = 1;


    public LewyPanel(JFrame okno) {
        JPanel panel = new JPanel();
        panel.setBounds(10,10,200,620);
        panel.setBackground(Color.gray);
        okno.add(panel);
        panel.setLayout( new BorderLayout() );



        pliki = new DefaultListModel[2];
        pliki[FILE_PATH] = new DefaultListModel<>();
        pliki[FILE_NAME] = new DefaultListModel<>();
        pliki[FILE_NAME].addElement("dog.png");
        pliki[FILE_PATH].addElement("dog.png");
        pliki[FILE_NAME].addElement("rubik.mp4");
        pliki[FILE_PATH].addElement("rubik.mp4");
        list = new JList<>(pliki[FILE_NAME]);

        list.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(list.getSelectedValue());
                GUI.srodkowyPanel.play(pliki[FILE_PATH].elementAt(list.getSelectedIndex()));
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        list.setBounds(10,10, 180,300);

        panel.setBorder(BorderFactory.createEmptyBorder(20, 15, 50, 15));

        JScrollPane scrollableArea = new JScrollPane(list);
        scrollableArea.setPreferredSize(new Dimension(150, 450));
        scrollableArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(scrollableArea, "North");

        JButton wczytaj = new JButton("Wczytaj plik");
        panel.add(wczytaj, "Center");

        wczytaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 JFileChooser fc = new JFileChooser();
                 int i = fc.showOpenDialog(null);
                 if(i == JFileChooser.APPROVE_OPTION){
                     File f=fc.getSelectedFile();
                     String filepath=f.getPath();
                     System.out.println(filepath);
                     dodajDoListy(filepath);
                 }
            }
        });

        JButton cofnij = new JButton("cofnij");
       // panel.add(cofnij,"South");
        cofnij.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Stos.cofnijOperacje();
            }
        });


        JPanel jPanel = new JPanel();
        jPanel.add(cofnij);
        jPanel.setLayout(new FlowLayout());
        jPanel.setVisible(true);

        OsCzasu osCzasu = new OsCzasu();

        JButton DodajDoOsiCzasu = new JButton("dodaj do osi czasu");
        JTextField poczatek = new JTextField("0",5);
        jPanel.add(DodajDoOsiCzasu);
        jPanel.add(poczatek);

        DodajDoOsiCzasu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double poczatekFilmu=0.0;

                try {
                    poczatekFilmu= Double.parseDouble(poczatek.getText());


                    if(poczatekFilmu > osCzasu.getDlugosc() )
                    {
                        throw new Exception();
                    }

                }catch(Exception e1) {
                    System.out.println(e);
                }

                Multimedia wideo = new Multimedia(GUI.srodkowyPanel.mediaPlayer.getLength(),poczatekFilmu, GUI.lewyPanel.list.getSelectedValue());
               osCzasu.dodajMultimedia(wideo);
                System.out.println(osCzasu);
//                Stos.stos.push(kopiuj);
            }
        });

        panel.add(jPanel);

    }

    public void dodajDoListy(String filepath) {
        pliki[FILE_PATH].addElement(filepath);
        pliki[FILE_NAME].addElement(getNameOfFile(filepath));
        list.updateUI();
    }

    public void usunZListy(String filepath) {
        pliki[FILE_PATH].removeElement(filepath);
        pliki[FILE_NAME].removeElement(getNameOfFile(filepath));
        list.updateUI();
    }

    private String getNameOfFile(String filepath){
        Path path = Paths.get(filepath);
        return path.getFileName().toString();
    }

}