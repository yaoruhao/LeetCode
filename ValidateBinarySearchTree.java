/**
 * 
 * @author yaoruhao
 *
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return checkValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public boolean checkValidBST(TreeNode root, int minBound, int maxBound) {
    	if (root == null) {
			return true;
		}
    	if (root.val <= minBound || root.val >= maxBound) {
			return false;
		}
    	if (checkValidBST(root.left, minBound, root.val) && checkValidBST(root.right, root.val, maxBound)) {
			return true;
		}
    	return false;
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
