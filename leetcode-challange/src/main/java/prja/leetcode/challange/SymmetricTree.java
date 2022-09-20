package prja.leetcode.challange;
 
// https://leetcode.com/problems/symmetric-tree/
class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
    	if(null==root) return true;
		return isChildSymetric(root.left, root.right);
    }

	private boolean isChildSymetric(TreeNode left, TreeNode right) {
		if(left ==null && right== null) return true;
		if(left==null ||right==null  || (left.val!=right.val)) return false;
		return isChildSymetric(left.left, right.right) && isChildSymetric(left.right, right.left);
	}
}