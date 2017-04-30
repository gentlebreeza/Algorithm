def reverse_list(head)
    dummy_head = ListNode.new 0
    dummy_head.next = head

    # if ruby >= 2.3, just use safe operator like 'head&.next'
    while head && head.next
        tmp = head.next
        head.next = tmp.next
        tmp.next = dummy_head.next
        dummy_head.next = tmp
    end

    return dummy_head.next
end