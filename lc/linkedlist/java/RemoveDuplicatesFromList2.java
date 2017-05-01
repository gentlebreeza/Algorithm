package lc.linkedlist.java;

public class RemoveDuplicatesFromList2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prevNode = dummyHead;
        
        while(head != null) {
            if(head != null && head.next != null && head.val == head.next.val) {
                while(head != null && head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                prevNode.next = head.next;
                head = prevNode.next;
            } else {
                prevNode = prevNode.next;
                head = head.next;
            }
        }

        return dummyHead.next;
    }
}