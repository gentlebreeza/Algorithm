package lc.linkedlist.java;

public class RemoveDuplicatesFromList {
    public ListNode removeDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        while(head != null && head.next != null) {
            if(head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }

        return dummyHead.next;
    }

    // more straigh-forward
    public ListNode removeDuplicatesV2(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        while(head != null && head.next != null) {
            // check head.next != null for some cases like [1,1,1]
            // keep removing duplicates
            while(head.next != null && head.val == head.next.val) {
                head.next = head.next.next;
            }
            // otherwise iterate to next one;
            head = head.next;
        }

        return dummyHead.next;
    }
}
