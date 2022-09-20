package prja.leetcode.challange;

//https://leetcode.com/problems/merge-two-binary-trees/
public class MergeTree {

	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (null == t1 && null == t2)
			return null;
		if (null == t1)
			return t2;
		if (null == t2)
			return t1;

		TreeNode resultNode = new TreeNode(t1.val + t2.val);
		resultNode.left = mergeTrees(t1.left, t2.left);
		resultNode.right = mergeTrees(t1.right, t2.right);

		return resultNode;
	}

}
