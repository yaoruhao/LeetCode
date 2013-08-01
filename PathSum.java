/**
 * 
 * @author yaoruhao
 *
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) {
			return false;
		}
        if (root.left == null && root.right == null) {
			if (root.val == sum) {
				return true;
			} else {
				return false;
			}
		}
        if (hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val)) {
			return true;
		} else {
			return false;
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}

}
