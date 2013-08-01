import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 * 
 */
public class UniqueBinarySearchTreesII {

	public ArrayList<TreeNode> generateTrees(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		return generateAllBST(1, n);
	}
	
	public ArrayList<TreeNode> generateAllBST(int start, int end) {
		ArrayList<TreeNode> tempList = new ArrayList<TreeNode>();
		if (start == end) {
			tempList.add(new TreeNode(start));
			return tempList;
		}
		if (start > end) {
			tempList.add(null);
			return tempList;
		}
		for (int i = start; i <= end; i++) {
			ArrayList<TreeNode> leftChildList = generateAllBST(start, i - 1);
			ArrayList<TreeNode> rightChildList = generateAllBST(i + 1, end);
			for (int leftIndex = 0; leftIndex < leftChildList.size(); leftIndex++) {
				for (int rightIndex = 0; rightIndex < rightChildList.size(); rightIndex++) {
					TreeNode root = new TreeNode(i);
					root.left = leftChildList.get(leftIndex);
					root.right = rightChildList.get(rightIndex);
					tempList.add(root);
				}
			}
		}		
		return tempList;
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
