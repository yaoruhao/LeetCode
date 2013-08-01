/**
 * 
 * @author yaoruhao
 *
 */
public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) {
			return;
		}
        flatten(root.left);
        flatten(root.right);
        TreeNode tempRight = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) {
			root = root.right;
		}
        root.right = tempRight;
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
