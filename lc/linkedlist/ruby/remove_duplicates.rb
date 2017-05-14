def remove_duplicates(head)
    dummy_head = ListNode.new 0
    dummy_head.next = head

    while head && head.next
        while head.next && head.val == head.next.val
            head.next = head.next.next
        end
        head = head.next
    end

    dummy_head.next
end


# cleaner code

def remove_duplicates(head)
    dummy = ListNode.new 0
    dummy.next = head

    while head && head.next
        if head.val == head.next.val
            head.next = head.next.next # removing duplicates
        else
            head = head.next # iterator to next node
        end
    end

    dummy.next
end
