/**
 * 
 * @author yaoruhao
 *
 */
public class MaxiamDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) {
			return 0;
		}
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
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