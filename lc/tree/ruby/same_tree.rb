def is_same_tree(node1, node2)
    return true unless node1 || node2 # node1 and node2 are both nil
    return false unless node1 && node2 # one of node1 and node2 is nil

    return false if node1.val != node2.val

    is_same_tree(node1.left, node2.left) && is_same_tree(node1.right, node2.right)
end