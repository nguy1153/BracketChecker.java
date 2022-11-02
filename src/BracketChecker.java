import java.util.Stack;

public class BracketChecker {

    private final Stack<Character> s = new Stack<>();
    private char[] opening;
    private char[] closing;
    private int position;

    public BracketChecker(char[] opening, char[] closing) {
        this.opening = opening;
        this.closing = closing;
    }

    public BracketChecker() {
    }

    private int isOpening(char in) {
        for (int ci = 0; ci < opening.length; ci++) {
            if (in == opening[ci]) {
                return ci;
            }
        }
        return -1;
    }

    private int isClosing(char in) {
        for (int ci = 0; ci < closing.length; ci++) {
            if (in == closing[ci]) {
                return ci;
            }
        }
        return -1;
    }

    public boolean check(String text) {
        stack.clear();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '{')
                stack.push('{');
            else if (text.charAt(i) == '}')
                if (stack.isEmpty()) {
                    position = i;
                    return false;
                } else
                    stack.pop();
        }

        if (stack.isEmpty())
            return true;
        else {
            position = text.length() - 1;
            return false;
        }
    }

    public boolean checkGeneral(String line) {
        stack.clear();
        for (int i = 0; i < line.length(); i++) {
            char checkChar = line.charAt(i);
            if (isOpening(checkChar) != -1 && isClosing(checkChar) == -1)

                stack.push(checkChar);
            else if (isOpening(checkChar) != -1 && isClosing(checkChar) != -1) {

                if (stack.isEmpty())
                    stack.push(checkChar);
                else if (stack.pop() != opening[isClosing(checkChar)]) {
                    position = i;
                    return false;
                }
            }
            else if (isClosing(line.charAt(i)) != -1) {

                if (stack.isEmpty() || stack.pop() != opening[isClosing(line.charAt(i))]) {
                    position = i;
                    return false;
                }
            }
        }
        if (stack.isEmpty())
            return true;
        else {
            position = line.length() - 1;
            return false;
        }
    }

    public int getPosition() {
        return position;
    }
}
