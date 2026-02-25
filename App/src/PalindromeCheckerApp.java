import java.util.Scanner;

class Node {
    char data;
    Node next;
    Node(char data) { this.data = data; }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- UC8: Linked List Based Palindrome Checker ---");
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
        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        if (cleanInput.isEmpty()) return true;

        // 1. Build the Singly Linked List
        Node head = new Node(cleanInput.charAt(0));
        Node current = head;
        for (int i = 1; i < cleanInput.length(); i++) {
            current.next = new Node(cleanInput.charAt(i));
            current = current.next;
        }

        // 2. Find Middle using Fast and Slow Pointers

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 3. Reverse the Second Half of the list

        Node prev = null;
        Node secondHalfHead = slow;
        while (secondHalfHead != null) {
            Node nextNode = secondHalfHead.next;
            secondHalfHead.next = prev;
            prev = secondHalfHead;
            secondHalfHead = nextNode;
        }

        // 4. Compare First Half and Reversed Second Half
        Node firstHalf = head;
        Node reversedSecondHalf = prev;
        while (reversedSecondHalf != null) {
            if (firstHalf.data != reversedSecondHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            reversedSecondHalf = reversedSecondHalf.next;
        }

        return true;
    }
}