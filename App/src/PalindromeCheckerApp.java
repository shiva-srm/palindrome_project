import java.util.Scanner;
import java.util.Stack;

/**
 * UC5: Stack-Based Palindrome Checker
 * Demonstrates the LIFO (Last-In, First-Out) principle.
 */
public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- UC5: Stack-Based Palindrome Checker ---");
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
        // Clean the string to handle cases and spaces
        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (cleanInput.isEmpty()) return true;

        // 1. Initialize the Stack data structure
        Stack<Character> stack = new Stack<>();

        // 2. Push Operation: Insert characters into the stack
        for (int i = 0; i < cleanInput.length(); i++) {
            stack.push(cleanInput.charAt(i));
        }



        // 3. Pop and Compare: Check characters in reverse order
        for (int i = 0; i < cleanInput.length(); i++) {
            char originalChar = cleanInput.charAt(i);
            char reversedChar = stack.pop(); // Removes and returns the top element

            if (originalChar != reversedChar) {
                return false; // Mismatch found
            }
        }

        return true; // If all characters match, it's a palindrome
    }
}