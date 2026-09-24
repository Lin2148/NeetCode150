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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode ret = head;
        if (head == null || head.next == null){
            return head;
        }

        while(head.next != null){
            int gcd = gcd(head.val,head.next.val);
            ListNode tmp = head.next;
            head.next = new ListNode(gcd, tmp);
            head = tmp;
        }
        return ret;
    }

    private int gcd(int a, int b){
        return b==0 ? a : gcd(b, a % b);
    }
}