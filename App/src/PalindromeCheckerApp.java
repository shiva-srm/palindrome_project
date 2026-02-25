import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- UC10: Case-Insensitive & Space-Ignored Palindrome ---");
        System.out.print("Enter a string (try phrases with spaces/caps): ");
        String input = scanner.nextLine();

        // 1. Normalize the string (The core of UC10)
        String cleaned = preprocess(input);

        System.out.println("Normalized String: " + cleaned);

        // 2. Apply Palindrome Logic
        if (isPalindrome(cleaned)) {
            System.out.println("Result: It is a Palindrome!");
        } else {
            System.out.println("Result: It is NOT a Palindrome.");
        }

        scanner.close();
    }

    /**
     * UC10 Core: Using Regex to remove non-alphanumeric characters
     * and converting to lowercase.
     */
    public static String preprocess(String input) {
        if (input == null) return "";

        //

        // [^a-zA-Z0-9] means "anything that is NOT a letter or number"
        return input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}