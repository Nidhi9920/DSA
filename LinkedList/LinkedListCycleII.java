package LinkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class LinkedListCycleII {

    // Function to detect the start node of cycle (if any)
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect if a cycle exists using Floyd's algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;         // 1 step
            fast = fast.next.next;    // 2 steps

            if (slow == fast) {
                // Step 2: Reset one pointer to head
                ListNode start = head;

                while (start != slow) {
                    start = start.next;
                    slow = slow.next;
                }

                return start; // start of the cycle
            }
        }

        return null; // no cycle
    }

    // Utility: Create list from array
    public static ListNode createList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    // Utility: Create cycle in the list at given position
    public static ListNode createCyclicList(int[] arr, int pos) {
        ListNode head = createList(arr);
        if (pos == -1) return head;

        ListNode curr = head;
        ListNode cycleNode = null;
        int idx = 0;

        while (curr.next != null) {
            if (idx == pos) cycleNode = curr;
            curr = curr.next;
            idx++;
        }

        curr.next = cycleNode; // create the cycle
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 0, -4};
        int pos = 1; // cycle at index 1 (node with value 2)

        ListNode head = createCyclicList(arr, pos);

        ListNode cycleStart = detectCycle(head);

        if (cycleStart != null) {
            System.out.println("Cycle starts at node with value: " + cycleStart.val);
        } else {
            System.out.println("No cycle detected.");
        }
    }
}

