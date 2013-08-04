/**
 * 
 * @author yaoruhao
 * 
 */
public class PopulatingNextRightPointers {
	public void connect(TreeLinkNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null || root.left == null || root.right == null) {
			return;
		}
		root.left.next = root.right;
		if (root.right.next == null && root.next != null) {
			root.right.next = root.next.left;
		}
		connect(root.left);
		connect(root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

}
