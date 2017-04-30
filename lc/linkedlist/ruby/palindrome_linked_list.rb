def is_palindrome(head)
    list_values = []
    # remember to save the head; 
    # head will finally move to end after all the values being put into list_values
    reserved_head = head

    while head
        list_values << head.val
        head = head.next
    end
    
    # simulate the stack
    list_values.reverse!

    list_values.each do |value|
        return false unless reserved_head.val == value
        reserved_head = reserved_head.next
    end

    true
end