import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 * 
 */
public class InsertInterval {

	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Interval> result = new ArrayList<Interval>();
		int i = 0;
		for (; i < intervals.size(); i++) {
			if (newInterval.end < intervals.get(i).start) {
				break;
			}
			if (intervals.get(i).end < newInterval.start) {
				result.add(intervals.get(i));
				continue;
			}
			newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
			newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
		}
		result.add(newInterval);
		while (i < intervals.size()) {
			result.add(intervals.get(i));
			i++;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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

}
