package lc.tree.java;

public class Subtree {
    public boolean isSubtree(TreeNode parent, TreeNode child) {
        if(parent == null && child == null) return true;
        if(parent == null || child == null) return false;

        boolean subtreeFound = false;
        if(parent.val == child.val) {
            subtreeFound = isSameTree(parent, child);
        }

        return subtreeFound || isSubtree(parent.left, child) || isSubtree(parent.right, child);
    }

    private boolean isSameTree(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;
        if(node1.val != node2.val) return false;

        return isSameTree(node1.left, node2.left) && isSameTree(node1.rihgt, ndoe2.right);
    }
}