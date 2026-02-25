import java.util.Scanner;

/**
 * Service Class to handle Palindrome Logic (Encapsulation)
 */
class PalindromeService {

    // Encapsulated method following Single Responsibility Principle
    public boolean checkPalindrome(String input) {
        if (input == null) return false;

        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = cleanInput.length() - 1;

        while (left < right) {
            if (cleanInput.charAt(left) != cleanInput.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating an object of the service class
        PalindromeService service = new PalindromeService();

        System.out.println("--- UC11: Object-Oriented Palindrome Service ---");
        System.out.print("Enter string: ");
        String text = scanner.nextLine();

        // Using the service object
        if (service.checkPalindrome(text)) {
            System.out.println("Result: '" + text + "' is a Palindrome.");
        } else {
            System.out.println("Result: '" + text + "' is NOT a Palindrome.");
        }

        scanner.close();
    }
}