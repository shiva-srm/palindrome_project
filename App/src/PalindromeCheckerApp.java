import java.util.*;

// 1. Define the Strategy Interface
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

// 2. Implementation: Stack-based Strategy
class StackStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String input) {
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : clean.toCharArray()) stack.push(c);
        for (char c : clean.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }
}

// 3. Implementation: Deque-based Strategy
class DequeStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String input) {
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : clean.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }
}

// 4. Context Class: This uses the strategy
class PalindromeContext {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(String input) {
        return strategy.isPalindrome(input);
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PalindromeContext context = new PalindromeContext();

        System.out.println("--- UC12: Strategy Pattern Palindrome ---");
        System.out.println("Select Strategy: 1. Stack | 2. Deque");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (choice == 1) {
            context.setStrategy(new StackStrategy());
        } else {
            context.setStrategy(new DequeStrategy());
        }

        System.out.print("Enter string: ");
        String input = scanner.nextLine();

        if (context.executeStrategy(input)) {
            System.out.println("Result: Palindrome found!");
        } else {
            System.out.println("Result: Not a palindrome.");
        }
        scanner.close();
    }
}