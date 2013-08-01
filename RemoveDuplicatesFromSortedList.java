/**
 * 
 * @author yaoruhao
 *
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null || head.next == null) {
			return head;
		}
        ListNode p = head;
        while (p != null && p.next != null) {
        	while (p.next != null && p.val == p.next.val) {
				p.next = p.next.next;
			}
        	p = p.next;
		}
        return head;
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
