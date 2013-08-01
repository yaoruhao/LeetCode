/**
 * 
 * @author yaoruhao
 * Referred to the github solution:https://github.com/yuanx/leetcode/blob/master/RemoveDuplicatesFromSortedListII.java
 *
 */
public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null || head.next == null) {
			return head;
		}
        ListNode p = new ListNode(Integer.MAX_VALUE);
        p.next = head;
        head = p;
        ListNode q = head.next;
        ListNode r = q.next;
        if (q.val != r.val) {
			p = p.next;
		}
        while (r.next != null) {
			if (r.next.val == r.val || r.val == q.val) {
				r = r.next;
				q = q.next;
			} else {
				r = r.next;
				q = q.next;
				p.next = q;
				p = p.next;
			}
		}
        if (r.val != q.val) {
			p.next = r;
		} else {
			p.next = null;
		}
        
        return head.next;
    }
    
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
