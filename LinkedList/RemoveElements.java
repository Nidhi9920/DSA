package LinkedList;
/*Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5] */
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class RemoveElements {
    Node solve(Node head, int val)
    {
        Node dummy = new Node(-1);
        dummy.next = head;
        Node curr = dummy;
        while(curr != null && curr.next != null){
            if(curr.next.data == val) curr.next=curr.next.next;
            else curr = curr.next;
        }
        return dummy.next;
    }
}
