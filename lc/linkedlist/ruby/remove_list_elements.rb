def remove_elements(head, value)
    dummy_head = ListNode.new 0
    dummy_head.next = head
    iterator = dummy_head

    while head
        if head.val == value
            iterator.next = head.next
        else
            iterator = iterator.next
        end
        head = head.next
    end

    dummy_head.next
end