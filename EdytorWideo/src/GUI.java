import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;


public class GUI{
    public  static SrodkowyPanel srodkowyPanel;
    public  static LewyPanel lewyPanel;
    public  static PrawyPanel prawyPanel;
    public  static Menu menu;

    public GUI() throws IOException {
        JFrame okno = new JFrame();

        menu = new Menu(okno);
        lewyPanel = new LewyPanel(okno);

        srodkowyPanel = new SrodkowyPanel(okno);
        prawyPanel = new PrawyPanel(okno);

        okno.setSize(1200,700);
        okno.setLayout(null);
        okno.setVisible(true);

        okno.setResizable(false);
        okno.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                srodkowyPanel.mediaPlayer.release();
                srodkowyPanel.component.release();
                srodkowyPanel.mediaPlayerFactory.release();
                System.exit(0);
            }
        });



    }

    public static void main(String[] args) throws IOException {
        GUI gui = new GUI();


    }
}