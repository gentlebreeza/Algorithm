def odd_even_list(head)
    return head unless head

    evenHead = head.next
    even = evenHead
    odd = head

    while even && even.next
        odd.next = even.next
        even.next = even.next.next
        odd = odd.next
        even = even.next
    end

    odd.next = evenHead

    head
end