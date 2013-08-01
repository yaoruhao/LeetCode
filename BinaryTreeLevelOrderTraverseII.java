import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 
 * @author yaoruhao
 *
 */
public class BinaryTreeLevelOrderTraverseII {

    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
			return resultList;
		}
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        LinkedList<TreeNode> bfsList = new LinkedList<TreeNode>();
        bfsList.add(root);
        bfsList.add(null);
        while (bfsList.size() > 1) {
        	TreeNode tempNode = bfsList.getFirst();
			bfsList.removeFirst();
			if (tempNode == null) {
				resultList.add(tempList);
				tempList = new ArrayList<Integer>();
				bfsList.add(null);
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
        Collections.reverse(resultList);
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
