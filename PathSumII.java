import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 *
 */
public class PathSumII {

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        getAllPathEqualToSum(root, sum, resultList, new ArrayList<Integer>());
        return resultList;
    }
    
    public void getAllPathEqualToSum(TreeNode root, int sum, ArrayList<ArrayList<Integer>> resultList, ArrayList<Integer> curList) {
    	if (root == null) {
			return;
		}
    	if (root.left == null && root.right == null) {
			if (root.val == sum) {
				curList.add(root.val);
				resultList.add((ArrayList<Integer>) curList.clone());
				curList.remove(curList.size() - 1);
			}
			return;
		}
    	
    	curList.add(root.val);
    	getAllPathEqualToSum(root.left, sum - root.val, resultList, curList);
    	getAllPathEqualToSum(root.right, sum - root.val, resultList, curList);
    	curList.remove(curList.size() - 1);
    	
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
