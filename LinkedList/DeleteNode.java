package LinkedList;
/*
 * Given a singly linked list and an integer x.
Delete xth node from the singly linked list.
Input: 1 -> 3 -> 4 x = 3
Output: 1 -> 3
Explanation: After deleting the node at 3rd position (1-base indexing), the linked list is as 1 -> 3.
 */
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class DeleteNode {
    Node solve(Node head, int x)
    {
        if(head == null) return null;
        if(x==1){
            return head.next;
        }
        Node curr = head;
        for(int i=1; i<x-1 && curr!=null; i++){
            curr=curr.next;
        }
        if(curr==null||curr.next==null){
            return head;
        }
        curr.next=curr.next.next;
        return head;
    }
}
