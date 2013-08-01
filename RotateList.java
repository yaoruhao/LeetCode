/**
 * 
 * @author yaoruhao
 *
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null || head.next == null || n == 0) {
			return head;
		}
        int count = 1;
        ListNode p = head;
        while (p.next != null) {
			count++;
			p = p.next;
		}
        if (n % count == 0) {
			return head;
		}
        count = count - (n % count);
        p = head;
        while (count > 1) {
			p = p.next;
			count--;
		}
        ListNode tempHead = p.next;
        p.next = null;
        p = tempHead;
        while (p.next != null) {
			p = p.next;
		}
        p.next = head;
        return tempHead;
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
