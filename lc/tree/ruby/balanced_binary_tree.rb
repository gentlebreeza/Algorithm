def is_balanced(root)
    return true unless root

    is_left_balanced = is_balanced root.left
    is_right_balanced = is_balanced root.right

    left_depth = tree_depth root.left
    right_depth = tree_depth root.right

    (left_depth - right_depth).abs <= 1 && is_left_balanced && is_right_balanced
end

private
def tree_depth(node)
    return 0 unless node

    left_depth = tree_depth node.left
    right_depth = tree_depth node.right

    [left_depth, right_depth].max + 1
end