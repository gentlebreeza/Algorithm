public class IntersectionOfTwoLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getListLength(headA), lengthB = getListLength(headB);

        if (lengthA >= lengthB) {
            while(lengthA > lengthB) {
                lengthA--;
                headA = headA.next;
            }
        } else {
            while(lengthB > lengthA) {
                lengthB--;
                headB = headB.next;
            }
        }

        while(headA != null && headB != null) {
            if(headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    private int getListLength(ListNode head) {
        int length = 0;

        while(head != null) {
            length++;
            head = head.next;
        }

        return length;
    }
}