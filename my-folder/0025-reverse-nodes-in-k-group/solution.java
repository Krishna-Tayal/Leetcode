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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null){
            return null;
        }
        ListNode temp=head;
        for(int i=0;i<k;i++){
            if(temp==null){
                return head;
            }
            temp=temp.next;
        }
        ListNode prev = null;
        ListNode curr = head;
        for (int i = 0; i < k; ++i) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        head.next = reverseKGroup(curr, k);
        return prev;
    }
}
