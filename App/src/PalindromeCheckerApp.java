import java.util.Scanner;

/**
 * UC3: Palindrome Check Using String Reverse
 * Demonstrates string reversal logic and the equals() method.
 */
public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- UC3: String Reverse Palindrome Checker ---");
        System.out.print("Enter a string: ");
        String original = scanner.nextLine();

        // 1. Reverse the string using a for loop
        String reversed = "";

        // Starting from the last index and moving to the first
        for (int i = original.length() - 1; i >= 0; i--) {
            // String Concatenation: creating a new string object each time
            reversed = reversed + original.charAt(i);
        }

        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed);

        //

        // 2. Compare using equals()
        if (original.equalsIgnoreCase(reversed)) {
            System.out.println("Result: The string is a Palindrome.");
        } else {
            System.out.println("Result: The string is NOT a Palindrome.");
        }

        scanner.close();
    }
}