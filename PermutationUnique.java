import java.util.ArrayList;
import java.util.HashSet;

/**
 * 
 * @author yaoruhao
 *
 */
public class PermutationUnique {

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
		if (num.length == 0) {
			return resultList;
		}
		ArrayList<Integer> elemList = new ArrayList<Integer>(num.length);
		for (int elem : num) {
			elemList.add(elem);
		}
		searchPermutations(elemList, resultList, new ArrayList<Integer>());
		return resultList;
    }
    public void searchPermutations(ArrayList<Integer> elemList,
			ArrayList<ArrayList<Integer>> resultList,
			ArrayList<Integer> currentList) {
		if (elemList.isEmpty()) {
			if (!currentList.isEmpty()) {
				resultList.add((ArrayList<Integer>) currentList.clone());
			
			}
			return;
		}
		HashSet<Integer> cacheSet = new HashSet<Integer>();
		for (int i = 0; i < elemList.size(); i++) {
			int num = elemList.get(i);
			if (cacheSet.contains(num)) {
				continue;
			}
			cacheSet.add(num);
			ArrayList<Integer> tempList = (ArrayList<Integer>) elemList.clone();
			tempList.remove(i);
			currentList.add(num);
			searchPermutations(tempList, resultList, currentList);
			currentList.remove(currentList.size() - 1);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
