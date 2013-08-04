import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author yaoruhao
 *
 */
public class PopulatingNextRightPointersII {
	
	public void connect(TreeLinkNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		while (root != null) {
			TreeLinkNode next = null;
			TreeLinkNode prev = null;
			for (; root != null; root = root.next) {
				if (next == null) {
					next = root.left != null ? root.left : root.right;
				}
				if (root.left != null) {
					if (prev != null) {
						prev.next = root.left;
					}
					prev = root.left;
				}
				if (root.right != null) {
					if (prev != null) {
						prev.next = root.right;
					}
					prev = root.right;
				}
			}
			root = next;
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeLinkNode root = createTree("1,2,3,4,5");
		PopulatingNextRightPointersII test = new PopulatingNextRightPointersII();
		test.connect(root);
	}
	
	public static TreeLinkNode createTree(String tree) {
        // {1,2,3,4,#,#,#,5,#,6,#,7,#,8}
        String[] ss = tree.split(",");
        return createTree(ss);
    }
 
    public static TreeLinkNode createTree(String[] tree) {
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        // 1st one should not be #
        TreeLinkNode root = constructOne(tree[0]);
        q.add(root);
        int idx = 1;
        while (!q.isEmpty()) {
             
            TreeLinkNode tn = q.poll();
            if (tn == null) {
                continue;
            }
            // construct tn's left&right node
            // when to stop
            if (idx == tree.length) {
                break;
            }
            TreeLinkNode left_ = constructOne(tree[idx]);
            tn.left = left_;
            q.add(left_);
            idx++;
            if (idx == tree.length) {
                break;
            }
            TreeLinkNode right_ = constructOne(tree[idx]);
            idx++;
             
             
            tn.right = right_;
            // add to queue
            q.add(right_);
        }
 
        return root;
 
    }
    
    private static TreeLinkNode constructOne(String s) {
        if (s.compareTo("#") == 0) {
            return null;
        } else {
            return new TreeLinkNode(Integer.valueOf(s));
        }
    }
	


}
