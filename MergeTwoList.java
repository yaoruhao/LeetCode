/**
 * 
 * @author yaoruhao
 *
 */
public class MergeTwoList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (l1 == null) {
			return l2;
		}
        if (l2 == null) {
			return l1;
		}
        if (l1.val > l2.val) {
			ListNode temp = l1;
			l1 = l2;
			l2 = temp;
		}
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1.next != null && p2 != null) {
			if (p1.next.val < p2.val) {
				p1 = p1.next;
				continue;
			}
			ListNode tempNode = p2.next;
			p2.next = p1.next;
			p1.next = p2;
			p2 = tempNode;
			p1 = p1.next;
		}
        if (p1.next == null) {
			p1.next = p2;
		}
        
        return l1;
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

}
