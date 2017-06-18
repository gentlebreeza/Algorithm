def has_path_sum(root, sum)
    return false unless root

    unless root.left || root.right
        return root.val == sum
    end

    has_path_sum(root.left, sum - root.val) || has_path_sum(root.right, sum - root.val)
end