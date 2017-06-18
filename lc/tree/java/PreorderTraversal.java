package lc.tree.java;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class PreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		
        List<Integer> preorderList = new ArrayList<Integer>();
        
        if(root == null) return preorderList;
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        
        s.push(root);
        
        while(!s.empty()) {
        	
            TreeNode curr = s.pop();
            
            preorderList.add(curr.val);
            
            if(curr.right != null) s.push(curr.right);
            
            if(curr.left != null) s.push(curr.left);
            
        }
        
        return preorderList;
    }
}
