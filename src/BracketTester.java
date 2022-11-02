import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
public class BracketTester {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Starting Bracket Checker application");

        //Checkpoint 16
        //        Scanner in = new Scanner(System.in);
//        BracketChecker checker = new BracketChecker();
//        String text = in.nextLine();
//
//        while (!text.isEmpty()) {
//            if (checker.check(text))
//                System.out.println("Syntax Correct");
//            else
//                System.out.println("Syntax Error");
//            text = in.nextLine();
//        }

        //Checkpoint 17
        //        String filePath = "/Users/Gill/Desktop/Study/MIT/CP2/Practical/practical-4-nguy1153-master/practical-4-nguy1153-master/assets/brackets01.txt";
//        Scanner in = new Scanner(new FileReader(filePath));
//        BracketChecker checker = new BracketChecker();
//
//        Queue<String> line = new LinkedList<>();
//        while (in.hasNextLine()) {
//            line.offer(in.nextLine());
//        }
//
//        while (!line.isEmpty()) {
//            String text = line.poll();
//            System.out.println(text);
//            if (checker.check(text))
//                System.out.println("Syntax Correct");
//            else {
//                for (int i = 0; i < checker.getPosition(); i++) {
//                    System.out.print(" ");
//                }
//                System.out.println("|");
//                System.out.println("Syntax Error at position " + checker.getPosition());
//            }
//        }
//
        // Checkpoint 18
        char[] opening = {'{', '(', '[', '"', '\'', '|'};
        char[] closing = {'}', ')', ']', '"', '\'', '|'};

        BracketChecker checker = new BracketChecker(opening, closing);

        String filePath = "/Users/Gill/Desktop/Study/MIT/CP2/Practical/practical-4-nguy1153-master/practical-4-nguy1153-master/assets/brackets02.txt";
        Scanner in = new Scanner(new FileReader(filePath));

        Queue<String> line = new ArrayDeque<>();
        while (in.hasNextLine()) {
            line.offer(in.nextLine());
        }

        while (!line.isEmpty()) {
            String text = line.poll();
            System.out.println(text);
            if (checker.checkGeneral(text))
                System.out.println("Syntax Correct");
            else {
                for (int i = 0; i < checker.getPosition(); i++) {
                    System.out.print(" ");
                }
                System.out.print("|");
                System.out.println(" Syntax Error at position " + checker.getPosition());
            }
        }

        System.out.println("\nExisting Checker");
    }
}