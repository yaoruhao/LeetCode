/**
 * 
 * @author yaoruhao
 *
 */
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) {
			return 0;
		}
        int leftLength = minDepth(root.left);
        int rightLength = minDepth(root.right);
        if (leftLength == 0) {
			return 1 + rightLength;
		}
        if (rightLength == 0) {
			return 1 + leftLength;
		}
        return 1 + Math.min(leftLength, rightLength);
    }
    
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
