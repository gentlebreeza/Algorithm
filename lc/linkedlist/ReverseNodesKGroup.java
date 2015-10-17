package lc.linkedlist;

public class ReverseNodesKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode move = head;
        
        int total = 0;
        while(move != null) {
            total++;
            move = move.next;
        }
        
        int cycles = total / k;
        for(int i = 0; i < cycles; i++) {
            for(int j = 1; j < k; j++) {
                ListNode tmp = head.next;
                head.next = tmp.next;
                tmp.next = prev.next;
                prev.next = tmp;
            }
            prev = head;
            head = head.next;
        }
        
        return dummy.next;
    }
}
