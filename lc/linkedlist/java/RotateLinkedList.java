package lc.linkedlist;

public class RotateLinkedList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        
        int total = 0;
        ListNode trav = head;
        while(trav != null) {
            total++;
            trav = trav.next;
        }
        
        k = k % total;
        if(k == 0) return head;
        ListNode curr = head;
        for(int i = 1; i < total-k; i++) {
            curr = curr.next;
        }
        ListNode result = curr.next;
        curr.next = null;
        ListNode tmp = result;
        while(tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = head;
        
        return result;
    }
}
