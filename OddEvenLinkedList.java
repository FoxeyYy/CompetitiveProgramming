/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    //Space: O(1)
    //Time: O(n) where n is list size
    public ListNode oddEvenList(ListNode head) {
        
        if (head == null) return null;
        
        //Two pointers
        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = evenHead;
        
        while(even != null && even.next != null) {
                        
            odd.next = even.next;
            odd = odd.next;
            
            even.next = odd.next;
            even = even.next;
            
        }
        
        odd.next = evenHead;
        
        return head;
        
    }
}
