package lc.linkedlist;

public class MergeSortList {
	public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode slow = head, fast = head;
        ListNode prev = null;
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(prev != null) prev.next = null;
        ListNode left = this.sortList(head);
        ListNode right = this.sortList(slow);
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(left != null && right != null) {
            if(left.val < right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        
        if(left != null) {
            curr.next = left;
        } else {
            curr.next = right;
        }
        
        return dummy.next;
    }
}
