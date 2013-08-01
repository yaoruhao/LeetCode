/**
 * 
 * @author yaoruhao
 *
 */
public class AddTwoNumbers {
	

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	 

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if (l1 == null) {
			return l2;
		}
    	if (l2 == null) {
			return l1;
		}
    	ListNode head1 = l1;
    	ListNode head2 = l2;
    	while (head1.next != null && head2.next != null) {
			head1.val += head2.val;
			head1 = head1.next;
			head2 = head2.next;
		}
    	head1.val += head2.val;
    	if (head1.next == null) {
			head1.next = head2.next;
		}
    	head1 = l1;
    	while (head1.next != null) {
			if (head1.val >= 10) {
				head1.val -= 10;
				head1.next.val++;
			}
			head1 = head1.next;
		}
    	if (head1.val >= 10) {
			head1.val -= 10;
			head1.next = new ListNode(1);
		}
    	return l1;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
