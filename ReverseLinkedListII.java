/**
 * 
 * @author yaoruhao
 *
 */
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null || head.next == null || m == n) {
			return head;
		}
        ListNode tempHead = new ListNode(Integer.MAX_VALUE);
        tempHead.next = head;
        head = tempHead;
        for (int i = 1; i < m; i++) {
			tempHead = tempHead.next;
		}
        ListNode pPrev = tempHead.next;
        ListNode pCurrent = pPrev.next;
        ListNode pNext = null;
        ListNode tempTail = tempHead.next;
        for (int i = m; i < n; i++) {
        	pNext = pCurrent.next;
        	pCurrent.next = pPrev;
        	pPrev = pCurrent;
        	pCurrent = pNext;
        }
        tempTail.next = pCurrent;
        tempHead.next = pPrev;
        return head.next;
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
