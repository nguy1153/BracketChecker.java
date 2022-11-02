import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class WombatDriver {

    public static void main(String[] args) throws SeverityOutOfBoundsException {
        //Checkpoint 19
        new ArrayDeque<>();
        PriorityQueue<Wombat> wombatQueue = new PriorityQueue<>();

        wombatQueue.add(new Wombat("Fluffy", 5, 10.5));
        wombatQueue.add(new Wombat("Socks", 10, 11.3));
        wombatQueue.add(new Wombat("Barry", 10, 10.8));
        wombatQueue.add(new Wombat("Jobe", 3, 12.0));
        wombatQueue.add(new Wombat("Ginger", 15, 3.2));

        while (!wombatQueue.isEmpty())
            System.out.println(wombatQueue.poll());
    }
}
