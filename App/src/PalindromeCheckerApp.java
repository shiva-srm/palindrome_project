import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- UC9: Recursive Palindrome Checker ---");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Clean the string before passing to recursive function
        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (isPalindromeRecursive(cleanInput, 0, cleanInput.length() - 1)) {
            System.out.println("Result: '" + input + "' is a Palindrome.");
        } else {
            System.out.println("Result: '" + input + "' is NOT a Palindrome.");
        }

        scanner.close();
    }

    /**
     * Recursive method to check palindrome
     * @param str The cleaned string
     * @param start Starting index
     * @param end Ending index
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindromeRecursive(String str, int start, int end) {
        // 1. Base Condition: If pointers cross or meet, we've checked everything
        if (start >= end) {
            return true;
        }

        // 2. Base Condition: If characters at start and end don't match
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // 3. Recursive Call: Check the inner substring by moving pointers inward
        return isPalindromeRecursive(str, start + 1, end - 1);
    }
}