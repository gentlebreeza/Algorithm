package lc.tree.java;

public class ConstructBSTFromPreorderAndInorder {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder == null || inorder == null) return null;
		if(preorder.length == 0 || inorder.length == 0) return null;
		
        return this.helper(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
    private TreeNode helper(int[] preorder, int[] inorder, int prel, int preh, int inl, int inh) {
        if(prel > preh || inl > inh) return null;
        
        TreeNode root = new TreeNode(preorder[prel]);
        int index = this.findRootIndex(inorder, root.val);
        
        root.left = this.helper(preorder, inorder, prel+1, index-inl+prel, inl, index-1);
        root.right = this.helper(preorder, inorder, preh-inh+index+1, preh, index+1, inh);
        
        return root;
    }
    private int findRootIndex(int[] arr, int rootVal) {
    	
        for(int i = 0; i < arr.length; i++) {
        	if(arr[i] == rootVal) return i;
        }
        
        return -1;
    }
}

