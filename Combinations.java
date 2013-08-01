import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 *
 */
public class Combinations {

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
    	if (k == 0 || n < k) {
			return resultList;
		}
    	permutationList(n, k, new ArrayList<Integer>(), resultList);
    	return resultList;
    }
    
    public void permutationList(int n, int k, ArrayList<Integer> tempList, ArrayList<ArrayList<Integer>> resultList) {
    	if (k == 0) {
			resultList.add((ArrayList<Integer>) tempList.clone());
			return;
		}
    	int start = 0;
    	if (!tempList.isEmpty()) {
			start = tempList.get(tempList.size() - 1);
		}
    	for (int i = start + 1; i <= n - k + 1; i++) {
			tempList.add(i);
			permutationList(n, k - 1, tempList, resultList);
			tempList.remove(tempList.size() - 1);
		}
    }
	public static void main(String[] args) {
		Combinations test = new Combinations();
		System.out.println(test.combine(4, 2));

	}

}
