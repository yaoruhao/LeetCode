import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 *
 */
public class LongestValidParentheses {

	//use a status list to store caches. 1 for '(', other value for matched length, ')' will not store in statusList
    public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int maxLength = 0;
        ArrayList<Integer> statusList = new ArrayList<Integer>();
        int currentOpen = 0;
        for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				statusList.add(1);
				currentOpen++;
				continue;
			}
			if (statusList.isEmpty() || currentOpen == 0) {
				statusList.clear();
				continue;
			}
			int count = 0;
			boolean flag = false;
			for (int j = statusList.size() - 1; j >= 0; j--) {
				if (statusList.get(j) != 1) {
					count += statusList.get(j);
					statusList.remove(j);
					continue;
				}
				if (flag) {
					break;
				}
				count += 2;
				currentOpen--;
				flag = true;
				statusList.remove(j);
			}
			if (maxLength < count) {
				maxLength = count;
			}
			statusList.add(count);
		}
        return maxLength;
    }
	public static void main(String[] args) {
		
	}

}
