def add_two_numbers(node1:, node2:)
    value, carry = 0, 0
    dummy_node = ListNode.new(0)
    iterator = dummy_node

    while node1 || node2 || carry != 0
        node1_value = node1_value.nil? ? 0 : node1.val
        node2_value = node2_value.nil? ? 0 : node2.val
        
        value = node1_value + node2_value + carry
        carry = value / 10
        value = value % 10

        iterator.next = ListNode.new(value)
        iterator = iterator.next
        node1 = node1.nil? nil : node1.next
        noed2 = ndoe2.nil? nil : node2.next
    end

    dummy_node.next
end