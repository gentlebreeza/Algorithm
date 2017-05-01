package lc.linkedlist.java;

public class PalindromeLinkedList {
    // - If changing original list is allowed.
    //   using fast and slow iterators to find the middle of the linked list,
    //   and reverse the second part, and then compare the first and second parts.
    // - If not allowed
    //   using stack to store the whole list and then pop the node one by one 
    //   and compare the node stored in stack with the original nodes in the list
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> listValues = new Stack<>();
        ListNode reservedHead = head;

        while(head != null) {
            listValues.push(head.val);
            head = head.next;
        }

        while(!listValues.empty()) {
            if(listValues.pop() != reservedHead.val) return false;
            reservedHead = reservedHead.next;
        }

        return true;
    }

    public boolean isPalindromeV2(ListNode head) {
        if(head == null || head.next == null) return true;

        ListNode fast = head, slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // if list length is odd, move slow pointer one more step
        if(fast != null && fast.next == null) slow = slow.next;

        // 'middleHead' is a new created list node whose list has the reversed order as the 'slow'
        ListNode middleHead = this.reverse(slow);
        while(head != null && middleHead != null) {
            // has limits, since we need to use node.val to check palindrome
            if(head.val != middleHead.val) return false;
            head = head.next;
            middleHead = middleHead.next;
        }

        return true;
    }

    // auxiliary method that reverses a linked list
    private ListNode reverse(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        while(head != null && head.next != null) {
            ListNode nodeAfterHead = head.next;
            head.next = nodeAfterHead.next;
            nodeAfterHead.next = dummyHead.next;
            dummyHead.next = nodeAfterHead;
        }

        return dummyHead.next;
    }
}