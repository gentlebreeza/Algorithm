package lc.linkedlist.java;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;

        // fast and slow iterators
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next
            // check if slow == fast, not just slow.val == fast.val
            if(fast == slow) return true;
        }

        return false;
    }
}