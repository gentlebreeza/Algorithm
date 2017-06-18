package lc.tree.java;

public class BinaryTreeMaxPathSum {
	public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        helper(root, max);
        return max[0];
    }
    private int helper(TreeNode root, int[] max) {
        if(root == null) return 0;
        
        int left = helper(root.left, max);
        int right = helper(root.right, max);
        
        int current = Math.max(root.val, Math.max(left, right) + root.val);
        max[0] = Math.max(max[0], Math.max(left + right + root.val, current));
        
        return current;
    }
}
