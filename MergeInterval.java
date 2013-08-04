import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 
 * @author yaoruhao
 * 
 */
public class MergeInterval {

	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Interval> resultList = new ArrayList<Interval>();
		if (intervals.isEmpty()) {
			return resultList;
		}
		Collections.sort(intervals, new IntervalComparator());
		Interval curInterval = new Interval(intervals.get(0).start, intervals.get(0).end);
		for (int i = 1; i < intervals.size(); i++) {
			Interval tempInterval = intervals.get(i);
			if (tempInterval.start > curInterval.end) {
				resultList.add(curInterval);
				curInterval = tempInterval;
			} else {
				curInterval.start = Math.min(tempInterval.start, curInterval.start);
				curInterval.end = Math.max(tempInterval.end, curInterval.end);				 
			}
		}
		resultList.add(curInterval);
		return resultList;
	}


	
	public class IntervalComparator implements Comparator<Interval>{

		@Override
		public int compare(Interval o1, Interval o2) {
			// TODO Auto-generated method stub
			return o1.start - o2.start;
		}
		
	}
	
	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
