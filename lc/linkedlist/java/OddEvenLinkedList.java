package lc.linkedlist.java;

public class OddEvenLinkedList {

    // straight forward
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(0);
        ListNode oddIterator = oddHead;
        ListNode evenHead = new ListNode(0);
        LIstNode evenIterator = evenHead;

        int count = 1;
        while(head != null) {
            if(count % 2 != 0) {
                oddIterator.next = head;
                oddIterator = oddIterator.next;
            } else {
                evenIterator.next = head;
                evenIterator = evenIterator.next;
            }
            count++;
            head = head.next;
        }

        evenIterator.next = null
        oddIterator.next = evenHead.next;
        evenHead.next = null;

        return oddHead.next;
    }

    // better, O(N) time, O(1) space
    public ListNode oddEvenListV2(ListNode head) {
        if(head == null) return head;

        ListNode oddHead = head;
        ListNode odd = oddHead;
        ListNode evenHead = head.next;
        ListNode even = evenHead;

        while(even != null && even.next != null) {
            odd.next = evne.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;

        return oddHead;
    }
}