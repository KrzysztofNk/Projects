import java.util.ArrayList;

public class OsCzasu {
    ArrayList<Multimedia> listaMultimediów;
    private double dlugosc;

    public OsCzasu ()
    {
        listaMultimediów = new ArrayList();
        dlugosc = 0.0;
    }

    public void dodajMultimedia(Multimedia multimedia)
    {
        dlugosc+= multimedia.getDlugosc();
        listaMultimediów.add(multimedia);
        listaMultimediów.sort((o1, o2) -> {
           if(o1.getPoczatek() < o2.getPoczatek()) return -1;
           else if (o1.getPoczatek() > o2.getPoczatek()) return 1;
           else return 0;
        });
    }


    public double getDlugosc() {
        return dlugosc;
    }

    @Override
    public String toString() {
        return listaMultimediów.get(0).toString();
    }
}
