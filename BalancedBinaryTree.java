/**
 * 
 * @author yaoruhao
 *
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if (getTreeDepth(root) != -1) {
    		return true;
		} else {
			return false;
		}        
    }
    
    public int getTreeDepth(TreeNode root) {
    	if (root == null) {
			return 0;
		}
    	int leftDepth = getTreeDepth(root.left);
    	if (leftDepth == -1) {
			return -1;
		}
    	int rightDepth = getTreeDepth(root.right);
    	if (rightDepth == -1) {
			return -1;
		}
    	if (Math.abs(leftDepth - rightDepth) > 1) {
			return -1;
		}
    	return 1 + Math.max(leftDepth, rightDepth);
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
