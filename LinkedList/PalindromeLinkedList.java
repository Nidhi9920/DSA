package LinkedList;

import java.util.ArrayList;

/*Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
Input: head = [1,2,2,1]
Output: true */
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class PalindromeLinkedList {
     static boolean solve(Node head) {
        ArrayList<Integer> list = new ArrayList<>();
        Node curr = head;
        while(curr != null){
            list.add(curr.data);
            curr = curr.next;
        }
        int n = list.size();
        for(int i=0; i<n/2; i++){
            if(!list.get(i).equals(list.get(n-i-1))){
                return false;
            }
        }
        return true;
    }
}
