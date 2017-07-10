def min_depth(root)
    minimum_depth = case 
    when root.nil?
        0
    when root.left.nil? && root.right
        min_depth(root.right) + 1
    when root.right.nil? && root.left
        min_depth(root.left) + 1
    else
        [min_depth(root.left), min_depth(root.right)].min + 1
    end

    minimum_depth
end