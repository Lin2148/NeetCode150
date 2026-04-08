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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        if (head.next == null && n == 1) return null;
        ListNode fast = head, slow = head;
        int slowStep = 0;

        // slow ptr is N step slower
        while (slowStep < n){
            fast = fast.next;
            slowStep++;
        }
        if (fast == null) {
            return head.next; 
        }
        // slow ptr move to N-1th node
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        // remove
        slow.next = slow.next.next;

        return head;
    }
}