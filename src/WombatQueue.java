import java.util.PriorityQueue;
import java.util.Scanner;

public class WombatQueue {
    private final PriorityQueue<Wombat> wombatQueue = new PriorityQueue<>();

    public void printoutWombatQueue() {
        while (!wombatQueue.isEmpty()) {
            System.out.println(wombatQueue.poll());
        }
    }

    public void addWombat(String input) {
        Scanner in = new Scanner(input);
        try {
            wombatQueue.add(new Wombat(in.next(), in.nextInt(), in.nextDouble()));
        } catch (SeverityOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}


