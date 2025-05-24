package LinkedList;
/*Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]
 */
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class RemoveDuplicates {
    Node deleteDuplicates(Node head)
    {
        if(head == null || head.next == null){
            return head;
        }
        if(head.data == head.next.data){
            while(head.next != null && head.data == head.next.data){
                head = head.next;
            }
            return deleteDuplicates(head.next);
        }else{
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }
}
