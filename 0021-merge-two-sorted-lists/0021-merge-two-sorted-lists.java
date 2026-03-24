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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 ==null) return list1;  //全空
        else if (list1==null) return list2;
        else if (list2==null ) return list1;
        
        //都有值
        ListNode head,curr;
        if (list1.val <= list2.val){
            head = list1;
            list1 = list1.next;
        } else{
            head = list2;
            list2 = list2.next;
        }
        curr = head;

        while ((list1 != null) && (list2 != null)){
            if (list1.val <= list2.val){
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        //有一條走完了 沒有val
        if (list1 != null) {
            curr.next = list1;
        } else if (list2 != null) {
            curr.next = list2;
        }
        return head;
    }
}