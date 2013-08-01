/**
 * 
 * @author yaoruhao
 *
 */
public class ConstructBinaryTreeFromInPre {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return buildBTree(preorder, 0, inorder, 0, inorder.length - 1);
    }
    
    public TreeNode buildBTree(int [] preorder, int pIndex, int [] inorder, int iStart, int iEnd) {
    	if (pIndex >= preorder.length || iStart > iEnd) {
			return null;
		}
    	TreeNode root = new TreeNode(preorder[pIndex]);
    	int rootIndex = -1;
    	for (int i = iStart; i <= iEnd; i++) {
			if (inorder[i] == preorder[pIndex]) {
				rootIndex = i;
				break;
			}
		}
    	if (rootIndex == -1) {
			return null;
		}
    	root.left = buildBTree(preorder, pIndex + 1, inorder, iStart, rootIndex - 1);
    	root.right = buildBTree(preorder, pIndex + 1 + rootIndex - iStart, inorder, rootIndex + 1, iEnd);    	
    	return root;
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
