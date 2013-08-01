import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author yaoruhao
 *
 */
public class SubsetsWithDup {

    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        if (num.length == 0) {
			resultList.add(new ArrayList<Integer>());
			return resultList;
		}
        ArrayList<Integer> elemList	= new ArrayList<Integer>();
        elemList.add(num[0]);
        for (int i = 1; i < num.length; i++) {
			if (num[i] == num[i - 1]) {
				continue;
			}
			elemList.add(num[i]);
		}
        int []stat = new int[elemList.size()];
        for (int i = 0; i < num.length; i++) {
			stat[elemList.indexOf(num[i])]++;
		}
        int []flag = new int[stat.length];
        while (true) {
        	ArrayList<Integer> tempList = new ArrayList<Integer>();
            for (int i = 0; i < flag.length; i++) {    			
    			for (int j = 0; j < flag[i]; j++) {
					tempList.add(elemList.get(i));
				}
    		}
            resultList.add(tempList);
            if (tempList.size() == num.length) {
				break;
			}
            flag[0]++;
            for (int i = 0; i < stat.length; i++) {
            	if (flag[i] > stat[i]) {
					flag[i] = 0;
					flag[i+1]++;
				}
			}
		}
        return resultList;
    }
    
	public static void main(String[] args) {
		SubsetsWithDup test = new SubsetsWithDup();
		int []num = {1, 1};
		System.out.println(test.subsetsWithDup(num));
	}

}
