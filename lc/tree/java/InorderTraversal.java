package lc.tree;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class InorderTraversal {
	
	public List<Integer> inorderTraversal(TreeNode root) {
        
		List<Integer> inorderList = new ArrayList<Integer>();
		
		if(root == null) return inorderList;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		while(root != null || !stack.empty()) {
			
			while(root != null) {
				
				stack.push(root);
				
				root = root.left;
				
			}
			
			root = stack.pop();
			
			inorderList.add(root.val);
			
			root = root.right;
			
		}
		
		return inorderList;
    }
}
