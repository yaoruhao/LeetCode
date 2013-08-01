import java.util.LinkedList;

/**
 * 
 * @author yaoruhao
 *
 */
public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) {
        	return 0;
		}
    	int []sum = new int[1];
        addAllPath(root, new LinkedList<Integer>(), sum);
    	return sum[0];
    }
    
    public void addAllPath(TreeNode root, LinkedList<Integer> pathList, int[]sum) {
    	if (root.left == null && root.right == null) {
			int pathSum = 0;
			for (int i : pathList) {
				pathSum += i;
				pathSum *= 10;
			}
			pathSum += root.val;
			sum[0] += pathSum;
			return;
		}
    	pathList.add(root.val);
    	if (root.left != null) {
			addAllPath(root.left, pathList, sum);
		}
    	if (root.right != null) {
    		addAllPath(root.right, pathList, sum);
    	}
    	pathList.removeLast();
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
