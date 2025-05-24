package LinkedList;
/*Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.

Return the decimal value of the number in the linked list.

The most significant bit is at the head of the linked list.



Input: head = [1,0,1]
Output: 5
Explanation: (101) in base 2 = (5) in base 10

 */
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class BinaryToDecimal {
    static int solve(Node head){
        int res =0;
        while(head != null){
            res = res*2 + head.data;
            head = head.next;
        }
        return res;
    }
}
