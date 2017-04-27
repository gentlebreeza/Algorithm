package lc.linkedList;

public class AddTwoNumbers {
	public ListNode add(ListNode node1, ListNode node2) {
		int value = 0, carry = 0;
		ListNode dummyNode = new ListNode(0);
		ListNode iterator = dummyNode;

		while(node1 != null || node2 != null || carry != 0) {
			int node1Value = node1 == null ? 0 : node1.val;
			int node2Value = node2 == null ? 0 : node2.val;
			value = node1Value + node2Value + carry;
			carry = value / 10; value = value % 10;

			iterator.next = new ListNode(value);

			iterator = iterator.next;
			node1 = node1 == null ? null : node1.next;
			node2 = node2 == null ? null : node2.next;
		}

		return dummyNode.next;
	}
}