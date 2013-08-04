/**
 * 
 * @author yaoruhao
 *
 */
public class SymmetricTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if (root == null) {
			return true;
		}
    	return checkSymmetric(root.left, root.right);
    }
	
    public boolean checkSymmetric(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (p != null && q == null)) {
			return false;
		}
        if (p == null && q == null) {
			return true;
		}
        if (p.val != q.val) {
			return false;
		}
        if (checkSymmetric(p.left, q.right) && checkSymmetric(p.right, q.left)) {
			return true;
		} else {
			return false;
		}
    }
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return "TreeNode [val=" + val + "]";
		}
		
	}

}
