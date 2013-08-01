import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 
 * @author yaoruhao
 *
 */
public class CombinationSumII {

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        ArrayList<Integer> candidateList = new ArrayList<Integer>();
        for (int i : num) {
			candidateList.add(i);
		}
        ArrayList<ArrayList<Integer>> resultList = searchCombinationSum(candidateList, target);
        if (resultList == null || resultList.isEmpty()) {
			return new ArrayList<ArrayList<Integer>>();
		} else {
			HashSet<String> cacheSet = new HashSet<String>();
			for (int i = 0; i < resultList.size(); i++) {
				ArrayList<Integer> tempList = resultList.get(i);
				if (cacheSet.contains(tempList.toString())) {
					resultList.remove(i);
					i--;
					continue;
				}
				cacheSet.add(tempList.toString());
			}
			return resultList;
		}
    }
    
    public ArrayList<ArrayList<Integer>> searchCombinationSum(ArrayList<Integer> candidates, int target) {
    	if (candidates.isEmpty() || candidates.get(0) > target) {
			return null;
		}
    	ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
    	int tempTarget = target;
    	int minElem = candidates.get(0);
    	ArrayList<Integer> nextRoundList = (ArrayList<Integer>) candidates.clone();
    	nextRoundList.remove(0);
    	ArrayList<Integer> thisRoundNum = new ArrayList<Integer>();
    	if (tempTarget >= minElem) {
    		tempTarget -= minElem;
    		thisRoundNum.add(minElem);
    		if (tempTarget == 0) {
				resultList.add(thisRoundNum);
			} else {
				ArrayList<ArrayList<Integer>> tempResultList = searchCombinationSum(nextRoundList, tempTarget);
				if (tempResultList != null) {
					for (ArrayList<Integer> arrayList : tempResultList) {
						ArrayList<Integer> tempList = new ArrayList<Integer>();
						tempList.addAll(thisRoundNum);
						tempList.addAll(arrayList);
						resultList.add(tempList);
					}
				}
			}
		}
		ArrayList<ArrayList<Integer>> tempResultList = searchCombinationSum(nextRoundList, target);
		if (tempResultList != null) {
			for (ArrayList<Integer> arrayList : tempResultList) {
				ArrayList<Integer> tempList = new ArrayList<Integer>();
				tempList.addAll(arrayList);
				resultList.add(tempList);
			}
		}
    	if (resultList.isEmpty()) {
			return null;
		} else {
			return resultList;
		}
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
