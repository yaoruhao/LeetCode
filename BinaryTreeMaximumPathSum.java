/**
 * 
 * @author yaoruhao
 *
 */
public class BinaryTreeMaximumPathSum {

	int result;
    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        result = Integer.MIN_VALUE;
        getMaxPathSumForRoot(root);
        return result;
    }
    
    public int getMaxPathSumForRoot(TreeNode root) {
    	if (root == null) {
			return 0;
		}
    	int leftVal = getMaxPathSumForRoot(root.left);
    	int rightVal = getMaxPathSumForRoot(root.right);
    	result = Math.max(Math.max(0, leftVal) + Math.max(0, rightVal) + root.val, result);    	
    	return root.val + Math.max(0, Math.max(leftVal, rightVal));
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
