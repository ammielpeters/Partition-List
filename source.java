import java.util.Scanner;

// Defines a single node in the linked list
class ListNode {
    int val;
    ListNode next;

    // Constructor to create a new node
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class PartitionList {

    /**
     * Partitions a linked list around a value x.
     * All nodes less than x come before all nodes greater than or equal to x.
     *
     * @param head The head of the original linked list.
     * @param x The pivot value to partition around.
     * @return The head of the newly partitioned linked list.
     */
    public ListNode partition(ListNode head, int x) {
        // If the list is empty or has only one node, no changes are needed.
        if (head == null || head.next == null) {
            return head;
        }

        // 1. Initialize Dummy Nodes
        // 'beforeHead' is a placeholder for the list of smaller values.
        // 'afterHead' is a placeholder for the list of larger/equal values.
        ListNode beforeHead = new ListNode(0);
        ListNode afterHead = new ListNode(0);

        // 2. Create Tail Pointers
        // 'beforeTail' will point to the last node in the 'before' list.
        // 'afterTail' will point to the last node in the 'after' list.
        ListNode beforeTail = beforeHead;
        ListNode afterTail = afterHead;

        // Pointer to traverse the original list
        ListNode current = head;

        // 3. Iterate and Partition
        while (current != null) {
            if (current.val < x) {
                // Add the current node to the 'before' list
                beforeTail.next = current;
                // Move the tail pointer of the 'before' list forward
                beforeTail = beforeTail.next;
            } else {
                // Add the current node to the 'after' list
                afterTail.next = current;
                // Move the tail pointer of the 'after' list forward
                afterTail = afterTail.next;
            }
            // Move to the next node in the original list
            current = current.next;
        }

        // 4. Merge the two lists
        // Terminate the 'after' list to avoid cycles in the final list.
        afterTail.next = null;

        // Connect the end of the 'before' list to the start of the 'after' list.
        // afterHead.next is the real start of the second partition.
        beforeTail.next = afterHead.next;

        // The final list starts right after our dummy 'beforeHead' node.
        return beforeHead.next;
    }

    // Helper method to print the linked list
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PartitionList solution = new PartitionList();

        // --- Reading user input to build the linked list ---
        System.out.println("Enter the linked list elements separated by spaces (e.g., 1 4 3 2 5 2).");
        System.out.println("Enter a non-integer character to stop (e.g., 'q'):");
        
        // Use a dummy head to simplify adding the first node
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        while (scanner.hasNextInt()) {
            int val = scanner.nextInt();
            current.next = new ListNode(val);
            current = current.next;
        }
        
        // The actual head of the list is after the dummy node
        ListNode head = dummyHead.next;

        // Clear the buffer if a non-integer was entered
        if (scanner.hasNext()) {
            scanner.next(); 
        }

        System.out.print("Original List: ");
        solution.printList(head);

        // --- Reading the pivot value ---
        System.out.print("\nEnter the partition value (x): ");
        int x = scanner.nextInt();

        // --- Performing the partition ---
        ListNode resultHead = solution.partition(head, x);

        // --- Printing the result ---
        System.out.print("Partitioned List: ");
        solution.printList(resultHead);
        
        scanner.close();
    }
}
