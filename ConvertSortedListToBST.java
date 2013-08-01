/**
 * 
 * @author yaoruhao
 *
 */
public class ConvertSortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return buildBST(head);
    }
    
    public TreeNode buildBST(ListNode head) {
    	if (head == null) {
			return null;
		}
    	if (head.next == null) {
			return new TreeNode(head.val);
		}
    	ListNode p = head;
    	ListNode q = head;
    	while (q != null && q.next != null) {
			q = q.next.next;
			p = p.next;
		}
    	q = head;
    	while (q.next != p) {
			q = q.next;
		}
    	q.next = null;
    	TreeNode root = new TreeNode(p.val);
    	root.left = buildBST(head);
    	root.right = buildBST(p.next);
    	return root;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
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
