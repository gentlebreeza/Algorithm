package lc.linkedlist;

public class ReverseList2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        
        for(int i = 1; i < m; i++) {
            curr = curr.next;
        }
        ListNode prev = curr;
        curr = curr.next;
        for(int i = 0; i < n-m; i++) {
            ListNode tmp = curr.next;
            curr.next = tmp.next;
            tmp.next = prev.next;
            prev.next = tmp;
        }
        
        return dummy.next;
    }
}
