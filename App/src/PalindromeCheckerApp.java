import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- UC6: Queue + Stack Based Palindrome Check ---");
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("Result: '" + input + "' is a Palindrome.");
        } else {
            System.out.println("Result: '" + input + "' is NOT a Palindrome.");
        }

        scanner.close();
    }

    public static boolean isPalindrome(String input) {
        // Clean the string: remove non-alphanumeric and convert to lowercase
        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (cleanInput.isEmpty()) return true;

        // 1. Initialize Data Structures
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        // 2. Enqueue and Push characters
        for (char c : cleanInput.toCharArray()) {
            stack.push(c);   // LIFO
            queue.add(c);    // FIFO
        }

        //

        // 3. Compare dequeue (FIFO) vs pop (LIFO)
        while (!stack.isEmpty()) {
            char fromStack = stack.pop();  // Returns characters in Reverse
            char fromQueue = queue.remove(); // Returns characters in Original order

            if (fromStack != fromQueue) {
                return false; // Mismatch found
            }
        }

        return true; // All characters matched
    }
}