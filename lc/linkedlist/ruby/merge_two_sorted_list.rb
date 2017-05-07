def merge(head1, head2)
    dummy_head = ListNode.new 0
    iterator = dummy_head

    while head1 && head2
        if head1.val <= head2.val
            iterator.next = head1
            head1 = head1.next
        else
            iterator.next = head2
            head2 = head2.next
        end
        iterator = iterator.next
    end

    iterator.next = head1 ? head1 : head2

    dummy_head.next
end