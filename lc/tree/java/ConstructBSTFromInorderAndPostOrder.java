package lc.tree.java;

public class ConstructBSTFromInorderAndPostOrder {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length != postorder.length) return null;
        
        return helper(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }
    private TreeNode helper(int[] inorder, int[] postorder, int inl, int inh, int postl, int posth) {
        if(inl > inh || postl > posth) return null;
        
        TreeNode root = new TreeNode(postorder[posth]);
        int index = findRoot(inorder, root.val);
        
        root.left = helper(inorder, postorder, inl, index-1, postl, postl+index-1-inl);
        root.right = helper(inorder, postorder, index+1, inh, posth+index-inh, posth-1);
        
        return root;
    }
    private int findRoot(int[] arr, int rootVal) {
    	
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == rootVal) return i;
        }
        
        return -1;
    }
}
