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
        ListNode fast = head, slow = head;

        // slow ptr is N step slower
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // remove 1st node
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