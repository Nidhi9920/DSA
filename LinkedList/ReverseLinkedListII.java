package LinkedList;
/*Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]

 */
class ListNode{
    int data;
    ListNode next;
    ListNode(int data){
        this.data=data;
        this.next=null;
    }
}
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for(int i=1; i<left; i++){
            prev = prev.next;
        }
        ListNode start = prev.next;
        ListNode then = start.next;
        for(int i=0; i<right-left; i++){
            start.next=then.next;
            then.next=prev.next;
            prev.next=then;
            then=start.next;
        }
        return dummy.next;
    }
}
