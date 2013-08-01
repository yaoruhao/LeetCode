/**
 * 
 * @author yaoruhao
 * 
 */
public class RemoveNthNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode first = head;
		ListNode second = head;
		ListNode pre = null;
		for (int i = 1; i < n; i++) {
			second = second.next;
		}
		while (second.next != null) {
			pre = first;
			first = first.next;
			second = second.next;
		}
		if (pre == null) {
			head = first.next;
		} else {
			pre.next = first.next;
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
	
	public void test(){
		ListNode head = new ListNode(1);
		ListNode tail = new ListNode(2);
		head.next = tail;
		removeNthFromEnd(head, 1);
	}

	public static void main(String[] args) {
		RemoveNthNode test = new RemoveNthNode();
		test.test();
	}

}
