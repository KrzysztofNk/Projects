import javax.swing.*;

public class Menu {
    private JMenu otworz, zapisz, pomoc, cofnij;
    private JMenuBar mb;
    private JMenuItem zapisProjektu, eksportWideo;
    public Menu(JFrame okno){
        mb = new JMenuBar();


        otworz =  new JMenu("Otwórz");

        zapisz =  new JMenu("Zapisz");

        zapisProjektu = new JMenuItem("Zapis Projektu");
        eksportWideo = new JMenuItem("Eksport Wideo");

        pomoc =  new JMenu("Pomoc");

        cofnij = new JMenu("Cofnij");





        mb.add(otworz);mb.add(zapisz);mb.add(pomoc);mb.add(cofnij);

        zapisz.add(zapisProjektu);zapisz.add(eksportWideo);

        okno.add(mb);

        okno.setJMenuBar(mb);
    }
}