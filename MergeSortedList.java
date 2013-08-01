import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * @author yaoruhao
 * Referred to the solution for heap sort:https://github.com/yuanx/leetcode/blob/master/MergeKSortedLists.java
 * 
 */
public class MergeSortedList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int len = lists.size();
		if (len == 0) {
			return null;
		}
		if (len == 1) {
			return lists.get(0);
		}
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(len, LISTNODE_COMPARE);
		for (int i = 0; i < lists.size(); i++) {
			if (lists.get(i) != null) {
				queue.add(lists.get(i));
			}
		}
		ListNode h = new ListNode(-1);
		ListNode head = h;
		while (!queue.isEmpty()) {
			ListNode temp = queue.poll();
			h.next = temp;
			h = temp;
			if (temp.next != null) {
				queue.add(temp.next);
			}
		}
		
		return head.next;
	}
	
	static final Comparator<ListNode> LISTNODE_COMPARE = new Comparator<ListNode>(){
		public int compare(ListNode i, ListNode j){
			return i.val-j.val;
		}
	};

	public static void main(String[] args) {
		MergeSortedList test = new MergeSortedList();
		test.mergeKLists(new ArrayList<ListNode>());

	}

}
