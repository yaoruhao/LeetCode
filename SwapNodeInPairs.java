/**
 * 
 * @author yaoruhao
 *
 */
public class SwapNodeInPairs {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null || head.next == null) {
			return head;
		}
        ListNode temp1 = head;
        ListNode temp2 = head.next;
        temp1.next = temp2.next;
        temp2.next = temp1;
        head = temp2;
        while (temp2.next.next != null) {
			temp2 = temp2.next.next;
			if (temp2.next == null) {
				break;
			}
			temp2 = temp2.next;
			ListNode temp3 = temp1;
			temp1 = temp1.next;
			temp1.next = temp2.next;
			temp2.next = temp1;
			temp3.next = temp2;
		}        
        return head;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
