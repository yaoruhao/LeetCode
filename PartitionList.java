/**
 * 
 * @author yaoruhao
 *
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode p = new ListNode(Integer.MIN_VALUE);
        p.next = head;
        head = p;
        while (true) {
			while (p.next != null && p.next.val < x) {
				p = p.next;
			}
			if (p.next == null) {
				break;
			}
			ListNode q = p.next;
			while (q.next != null && q.next.val >= x) {
				q = q.next;
			}
			if (q.next == null) {
				break;
			}
			ListNode bigNode = p.next;
			ListNode smallNode = q.next;
			q.next = q.next.next;
			p.next = smallNode;
			smallNode.next = bigNode;
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
