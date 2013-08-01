import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 
 * @author yaoruhao
 *
 */
public class BinaryTreeZigZagTraverse {

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
			return resultList;
		}
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        boolean reverse = false;
        LinkedList<TreeNode> bfsList = new LinkedList<TreeNode>();
        bfsList.add(root);
        bfsList.add(null);
        while (bfsList.size() > 1) {
			TreeNode tempNode = bfsList.getFirst();
			bfsList.removeFirst();
			if (tempNode == null) {
				if (reverse) {
					Collections.reverse(tempList);
				}
				resultList.add(tempList);
				tempList = new ArrayList<Integer>();
				bfsList.add(null);
				reverse = !reverse;
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
        if (reverse) {
			Collections.reverse(tempList);
		}
        resultList.add(tempList);
        return resultList;
    }
	/**
	 * @param args
	 */
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
	}

}
