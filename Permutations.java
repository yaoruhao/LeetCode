import java.util.ArrayList;
import java.util.HashSet;

/**
 * 
 * @author yaoruhao
 * 
 */
public class Permutations {

	public ArrayList<ArrayList<Integer>> permute(int[] num) {
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
		searchPermutations(elemList, resultList, new ArrayList<Integer>(), new HashSet<String>());
		return resultList;
	}

	public void searchPermutations(ArrayList<Integer> elemList,
			ArrayList<ArrayList<Integer>> resultList,
			ArrayList<Integer> currentList, HashSet<String> cacheSet) {
		if (elemList.isEmpty()) {
			if (!currentList.isEmpty() && !cacheSet.contains(currentList.toString())) {
				resultList.add((ArrayList<Integer>) currentList.clone());
				cacheSet.add(currentList.toString());
			}
			return;
		}
		for (int i = 0; i < elemList.size(); i++) {
			int num = elemList.get(i);
			ArrayList<Integer> tempList = (ArrayList<Integer>) elemList.clone();
			tempList.remove(i);
			currentList.add(num);
			searchPermutations(tempList, resultList, currentList, cacheSet);
			currentList.remove(currentList.size() - 1);
		}
	}

	public static void main(String[] args) {
		Permutations test = new Permutations();
		int []inputs = {1};
		System.out.println(test.permute(inputs));

	}

}
