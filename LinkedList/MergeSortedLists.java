package LinkedList;
/*
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
        this.next=null;
    }
}
public class MergeSortedLists{
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2){
        if(list1==null) return list2;
        if(list2==null) return list1;
        if(list1.val<list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }else{
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
    public static void printList(ListNode head){
        ListNode curr = head;
        while(curr != null){
            System.out.print(curr.val+" -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
    public static ListNode createList(int[] arr){
        if(arr.length==0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for(int i=0; i<arr.length; i++){
            curr.next=new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }
    public static void main(String[] args) {
        int[] arr1 = {1,3,5};
        int[] arr2 = {2,4,6};
        ListNode list1 = createList(arr1);
        ListNode list2 = createList(arr2);
        System.out.println("List 1: ");
        printList(list1);
        System.out.println("List2 :");
        printList(list2);
        ListNode mergedList = mergeTwoLists(list1, list2);
        System.out.println("Merged List: ");
        printList(mergedList);
    }
}