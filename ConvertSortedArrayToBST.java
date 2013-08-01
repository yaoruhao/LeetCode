/**
 * 
 * @author yaoruhao
 *
 */
public class ConvertSortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return constructBST(num, 0, num.length - 1);
    }
    
    public TreeNode constructBST(int[] num, int start, int end) {
    	if (start > end) {
			return null;
		}
    	int mid = (start + end) / 2;
    	TreeNode subRoot = new TreeNode(num[mid]);
    	subRoot.left = constructBST(num, start, mid - 1);
    	subRoot.right = constructBST(num, mid + 1, end);
    	return subRoot;
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
