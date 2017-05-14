def intersection_node(head_a, head_b)
    length_a = list_length head_a
    length_b = list_length head_b

    if length_a >= length_b
        while length_a > length_b
            head_a = head_a.next
            length_a -= 1
        end
    else
        while length_a < length_b
            head_b = head_b.next
            length_b -= 1
        end
    end

    while head_a && head_b
        return head_a if head_a == head_b
        head_a = head_a.next
        head_b = head_b.next
    end
end

private
def list_length(head)
    length = 0

    while head
        head = head.next
        length += 1
    end

    length
end