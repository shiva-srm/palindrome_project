import java.util.*;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- UC13: Performance Comparison ---");
        System.out.print("Enter a long string for stress testing: ");
        String input = scanner.nextLine();

        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // 1. Measure Iterative Approach
        long start = System.nanoTime();
        isPalindromeIterative(cleanInput);
        long end = System.nanoTime();
        long iterativeTime = end - start;

        // 2. Measure Stack-based Approach
        start = System.nanoTime();
        isPalindromeStack(cleanInput);
        end = System.nanoTime();
        long stackTime = end - start;

        // 3. Measure Recursive Approach
        start = System.nanoTime();
        isPalindromeRecursive(cleanInput, 0, cleanInput.length() - 1);
        end = System.nanoTime();
        long recursiveTime = end - start;

        // Display Results
        System.out.println("\n--- Execution Results (in Nanoseconds) ---");
        System.out.println("Iterative (Two-Pointer): " + iterativeTime + " ns");
        System.out.println("Stack-based:             " + stackTime + " ns");
        System.out.println("Recursive:               " + recursiveTime + " ns");

        System.out.println("\nAnalysis: Usually, the Iterative approach is the fastest " +
                "because it avoids the overhead of object creation or the call stack.");

        scanner.close();
    }

    public static boolean isPalindromeIterative(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

    public static boolean isPalindromeStack(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) stack.push(c);
        for (char c : s.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String s, int low, int high) {
        if (low >= high) return true;
        if (s.charAt(low) != s.charAt(high)) return false;
        return isPalindromeRecursive(s, low + 1, high - 1);
    }
}