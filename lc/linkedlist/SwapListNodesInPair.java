package lc.linkedlist;

public class SwapListNodesInPair {
	public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        while(head != null && head.next != null) {
            ListNode tmp = head.next;
            head.next = tmp.next;
            tmp.next = head;
            prev.next = tmp;
            prev = head;
            head = head.next;
        }
        
        return dummy.next;
    }
}
