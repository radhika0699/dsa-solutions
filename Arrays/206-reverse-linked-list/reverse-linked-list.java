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
    public ListNode reverseList(ListNode head) {
        ListNode dummy = null;
        while(head != null)
        {
            //Take current node
            // Point it backward
            // Advance everything forward
            ListNode temp = head.next; //start with 2nd ele
            head.next = dummy; // first ele next is null, now 1-> null
            dummy = head; //dummy is 1 -> null
            head = temp; //head = 2
        }
        return dummy;

    }
}