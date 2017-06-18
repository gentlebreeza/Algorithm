package lc.tree.java;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Collections;

public class PostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		
        List<Integer> post = new ArrayList<Integer>();
        
        if(root == null) return post;
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        
        s.push(root);
        
        while(!s.empty()) {
        	
            TreeNode curr = s.pop();
            
            post.add(curr.val);
            
            if(curr.left != null) s.push(curr.left);
            
            if(curr.right != null) s.push(curr.right);
            
        }
        
        Collections.reverse(post);
        
        return post;
    }
}
