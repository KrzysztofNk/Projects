import java.util.Stack;

public class Stos {

    public static Stack<Dzialanie> stos = new Stack<>();

    public static void cofnijOperacje(){
        if(!stos.isEmpty()) {
            Dzialanie dzialanie = stos.pop();
            dzialanie.cofnij();
        }else System.out.println("\n Stos jest pusty! ");
    }
}



