import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author yaoruhao
 *
 */
public class CombinationSum {

    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(candidates);
        ArrayList<Integer> candidateList = new ArrayList<Integer>();
        for (int i : candidates) {
			candidateList.add(i);
		}
        ArrayList<ArrayList<Integer>> resultList = searchCombinationSum(candidateList, target);
        if (resultList == null || resultList.isEmpty()) {
			return new ArrayList<ArrayList<Integer>>();
		} else {
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
    	while (tempTarget >= minElem) {
    		tempTarget -= minElem;
    		thisRoundNum.add(minElem);
    		if (tempTarget == 0) {
				resultList.add(thisRoundNum);
				break;
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
