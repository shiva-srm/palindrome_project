import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- UC7: Deque-Based Optimized Palindrome Checker ---");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("Result: '" + input + "' is a Palindrome.");
        } else {
            System.out.println("Result: '" + input + "' is NOT a Palindrome.");
        }

        scanner.close();
    }

    public static boolean isPalindrome(String input) {
        // Clean input: remove spaces/punctuation and lowercase
        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (cleanInput.isEmpty()) return true;

        // 1. Initialize Deque (Double Ended Queue)
        Deque<Character> deque = new ArrayDeque<>();

        // 2. Insert characters into the deque
        for (char c : cleanInput.toCharArray()) {
            deque.addLast(c);
        }

        // 3. Compare front and rear
        // A palindrome must match from both ends until 0 or 1 character remains
        while (deque.size() > 1) {
            char first = deque.removeFirst();
            char last = deque.removeLast();

            if (first != last) {
                return false; // Mismatch found, not a palindrome
            }
        }

        return true; // If we cleared the deque, it's a palindrome
    }
}