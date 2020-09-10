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
 
 //Space: O(1)
 //Time: O(max(len(l1), len(l2))
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode(0);
        
        ListNode sol = dummy;
        
        int carry = 0; 
        
        while(l1 != null || l2 != null) {
            
            int curr = 0;
            if (l1 != null) curr += l1.val;
            if (l2 != null) curr += l2.val;
            curr += carry;
                        
            sol.next = new ListNode(curr % 10);
            carry = curr / 10;

            sol = sol.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            
        }
        
        if (carry > 0) {
            sol.next = new ListNode(carry);
        }
        
        return dummy.next;
        
    }
}
