/**
 * 
 * @author yaoruhao
 *
 */
public class ConstructBinaryTreeFromInPost {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return reConstructTree(inorder, postorder, 0, 0, inorder.length);
    }
    
    public TreeNode reConstructTree(int[] inorder, int []postorder, int iStart, int pStart, int length) {
    	if (length == 0) {
			return null;
		}
    	TreeNode root = new TreeNode(postorder[pStart + length - 1]);
    	int rootIndex = -1;
    	for (int i = iStart; i < inorder.length; i++) {
			if (inorder[i] == root.val) {
				rootIndex = i;
				break;
			}
		}
    	root.left = reConstructTree(inorder, postorder, iStart, pStart, rootIndex - iStart);
    	root.right = reConstructTree(inorder, postorder, rootIndex + 1, pStart + rootIndex - iStart, length - rootIndex + iStart - 1);
    	return root;
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
