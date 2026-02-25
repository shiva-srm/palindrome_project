import java.util.Scanner;

/**
 * UC4: Character Array Based Palindrome Check
 * Demonstrates the Two-Pointer technique and index-based access.
 */
public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- UC4: Character Array (Two-Pointer) Palindrome Checker ---");
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
        // Clean the string: remove non-alphanumeric and lowercase
        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (cleanInput.isEmpty()) return true;

        // 1. Convert String to char array
        char[] charArray = cleanInput.toCharArray();

        // 2. Initialize Two Pointers
        int left = 0;                  // Start pointer
        int right = charArray.length - 1; // End pointer

        // 3. Compare characters until pointers meet in the middle
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false; // Mismatch found
            }
            left++;  // Move forward
            right--; // Move backward
        }

        return true; // All characters matched
    }
}