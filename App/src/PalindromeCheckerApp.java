/**
 * UC2: Print a Hardcoded Palindrome Result
 * This version uses a fixed string and checks if it's a palindrome.
 */
public class PalindromeCheckerApp {

    public static void main(String[] args) {
        // 1. Defining a String Literal (Stored in String Constant Pool)
        String word = "madam";

        // 2. Logic to check for Palindrome
        // We reverse the string to compare it with the original
        String reversedWord = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reversedWord += word.charAt(i);
        }

        System.out.println("Checking Word: " + word);

        // 3. Conditional Statement (if-else) to evaluate the result
        if (word.equals(reversedWord)) {
            System.out.println("Result: The word is a Palindrome.");
        } else {
            System.out.println("Result: The word is NOT a Palindrome.");
        }
    }
}