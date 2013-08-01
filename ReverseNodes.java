/**
 * 
 * @author yaoruhao
 *
 */
public class ReverseNodes {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pPrev = head;
		ListNode pCurrent = pPrev.next;
		pPrev.next = null;
		while(pCurrent != null) {
			ListNode pNext = pCurrent.next;
			pCurrent.next = pPrev;
			pPrev = pCurrent;
			pCurrent = pNext;
		}
		return pPrev;
	}
    public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if (head == null || head.next == null || k <= 1) {
			return head;
		}
    	ListNode pPrev = head;
    	ListNode pCurrent = pPrev.next;
    	ListNode pLastPartEnd = null;
    	ListNode pNextPartStart = null;
    	boolean headSet = false;
        while (true) {
        	ListNode pEnd = pPrev;
        	for (int i = 1; i < k; i++) {
				if (pEnd == null || pEnd.next == null) {
					return head;
				}
        		pEnd = pEnd.next;

			}
        	if (headSet) {
				pLastPartEnd.next = pEnd;
			} else {
				head = pEnd;
				headSet = true;
			}
        	pCurrent = pPrev.next;
        	pPrev.next = pEnd.next;
        	pNextPartStart = pEnd.next;
        	pLastPartEnd = pPrev;
        	while (pCurrent != pEnd) {
				ListNode pNext = pCurrent.next;
				pCurrent.next = pPrev;
				pPrev = pCurrent;
				pCurrent = pNext;
			}
        	pCurrent.next = pPrev;
        	pPrev = pNextPartStart;
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
