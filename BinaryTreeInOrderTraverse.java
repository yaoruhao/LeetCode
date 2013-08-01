import java.util.ArrayList;
import java.util.Stack;

/**
 * 
 * @author yaoruhao
 * 
 */
public class BinaryTreeInOrderTraverse {

	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		if (root == null) {
			return resultList;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode temp = stack.peek();
			if (temp.left != null) {
				stack.push(temp.left);
				temp.left = null;
				continue;
			}
			resultList.add(temp.val);
			stack.pop();
			if (temp.right != null) {
				stack.push(temp.right);
			}
			
		}
		
		return resultList;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public void test() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		System.out.println(inorderTraversal(root));
	}

	public static void main(String[] args) {
		BinaryTreeInOrderTraverse test = new BinaryTreeInOrderTraverse();
		test.test();

	}

}
