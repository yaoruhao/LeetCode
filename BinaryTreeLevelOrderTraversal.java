import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 
 * @author yaoruhao
 *
 */
public class BinaryTreeLevelOrderTraversal {

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        LinkedList<TreeNode> bfsList = new LinkedList<TreeNode>();
        if (root == null) {
			return resultList;
		}
        bfsList.add(root);
        bfsList.add(null);
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        while (bfsList.size() > 1) {
			TreeNode tempNode = bfsList.getFirst();
			bfsList.removeFirst();
			if (tempNode == null) {
				bfsList.add(null);
				resultList.add(tempList);
				tempList = new ArrayList<Integer>();
				continue;
			}
			tempList.add(tempNode.val);
			if (tempNode.left != null) {
				bfsList.add(tempNode.left);
			}
			if (tempNode.right != null) {
				bfsList.add(tempNode.right);
			}
		}
        resultList.add(tempList);
        return resultList;
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
