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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //從一半
        ListNode sHalf = reverseL(slow.next);
        //從頭
        ListNode fHalf = head;
        slow.next = null;

        while (sHalf != null){
            ListNode tmp1 = fHalf.next;
            ListNode tmp2 = sHalf.next;

            fHalf.next = sHalf;
            sHalf.next = tmp1;
            
            fHalf = tmp1;
            sHalf = tmp2;
        }
    }

    private ListNode reverseL (ListNode h){
        ListNode prev = null, curr = h;
        while (curr != null){
                ListNode tmp = curr.next;
                curr.next = prev;

                prev = curr;
                curr = tmp;
        }
        return prev;
    }
}