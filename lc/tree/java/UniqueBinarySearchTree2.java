package lc.tree.java;

import java.util.List;
import java.util.ArrayList;

public class UniqueBinarySearchTree2 {
	public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }
    private List<TreeNode> helper(int l, int r) {
        List<TreeNode> rs = new ArrayList<TreeNode>();
        if(l > r) {
            rs.add(null);
            return rs;
        }
        for(int i = l; i <= r; i++) {
            
            List<TreeNode> leftList = helper(l, i-1);
            List<TreeNode> rightList = helper(i+1, r);
            for(TreeNode leftNode : leftList) {
                for(TreeNode rightNode : rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    rs.add(root);  
                }
            }
        }
        return rs;
    }
}
