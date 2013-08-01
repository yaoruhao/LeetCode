import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author yaoruhao
 *
 */
public class Subsets {

    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        int []flag = new int[S.length];
        Arrays.sort(S);
        while (true) {
        	ArrayList<Integer> tempList = new ArrayList<Integer>();
            for (int i = 0; i < flag.length; i++) {    			
    			if (flag[i] == 1) {
					tempList.add(S[i]);
				}
    		}
            resultList.add(tempList);
            if (tempList.size() == S.length) {
				break;
			}
            flag[0]++;
            for (int i = 0; i < flag.length; i++) {
				if (flag[i] > 1) {
					flag[i] = 0;
					flag[i+1]++;
				}
			}
		}
        return resultList;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
