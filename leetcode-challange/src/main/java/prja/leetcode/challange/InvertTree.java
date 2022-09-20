
package prja.leetcode.challange;

//https://leetcode.com/problems/invert-binary-tree/

public class InvertTree {

	public TreeNode invertTree(TreeNode root) {
		if (null == root)
			return null;
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;

		invertTree(root.left);
		invertTree(root.right);

		return root;

	}
}
