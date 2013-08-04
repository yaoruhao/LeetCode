/**
 * 
 * @author yaoruhao
 *
 */
public class SameTree {
	
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if ((p == null && q != null) || (p != null && q == null)) {
			return false;
		}
        if (p == null && q == null) {
			return true;
		}
        if (p.val != q.val) {
			return false;
		}
        if (isSameTree(p.left, q.left) && isSameTree(p.right, q.right)) {
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
		}

		@Override
		public String toString() {
			return "TreeNode [val=" + val + "]";
		}
		
	}

}
