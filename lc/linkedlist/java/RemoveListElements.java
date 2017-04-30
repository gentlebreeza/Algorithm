package lc.linkedlist.java;

public class RemoveListElements {
    public ListNode removeElements(ListNode head, int value) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode iterator = dummyHead;

        while(head != null) {
            if(head.val == value) {
                iterator.next = head.next;
            } else {
                iterator = iterator.next;
            }
            head = head.next;
        }

        return dummyHead.next;
    }
}