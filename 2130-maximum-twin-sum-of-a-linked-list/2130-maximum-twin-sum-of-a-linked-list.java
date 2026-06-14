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
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = Reverse(slow.next);
        int max = 0;
        ListNode sum1 = head;
        ListNode sum2 = slow.next;
        while(sum2!= null){
            int sum = sum1.val + sum2.val;
            max = Math.max(max,sum);
            sum1 = sum1.next;
            sum2 = sum2.next;
        }
        
        return max;
    }
    private ListNode Reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}