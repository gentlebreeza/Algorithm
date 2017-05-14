def remove_duplicates(head)
    dummy = ListNode.new 0
    dummy.next = head
    previous = dummy

    while head
        if head.next && head.val == head.next.val
            while head.next && head.val == head.next.val
                head = head.next
            end
            previous.next = head.next
            head = head.next
        else
            head = head.next
            previous = previous.next
        end
    end

    dummy.next
end