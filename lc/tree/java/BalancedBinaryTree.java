package lc.tree.java;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        boolean isLeftBalanced = isBalanced(root.left);
        boolean isRightBalanced = isBalanced(root.right);

        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);

        return Math.max(leftDepth - rightDepth) <= 1 && isLeftBalanced && isRightBalanced;
    }

    private int treeDepth(TreeNode node) {
        if(node == null) return 0;

        int leftDepth = treeDepth(node.left);
        int rightDepth = treeDepth(node.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}