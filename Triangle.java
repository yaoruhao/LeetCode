import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 *
 */
public class Triangle {

	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int minSum = Integer.MAX_VALUE;
        ArrayList<Integer> cache = new ArrayList<Integer>();
        cache.add(triangle.get(0).get(0));
        for (int i = 1; i < triangle.size(); i++) {
			ArrayList<Integer> tempCache = new ArrayList<Integer>();
			ArrayList<Integer> curEdge = triangle.get(i);
			tempCache.add(curEdge.get(0) + cache.get(0));
			for (int j = 1; j < cache.size(); j++) {
				tempCache.add(curEdge.get(j) + Math.min(cache.get(j), cache.get(j - 1)));
			}
			tempCache.add(curEdge.get(curEdge.size() - 1) + cache.get(cache.size() - 1));
			cache = tempCache;
		}
        for (Integer sum : cache) {
			minSum = Math.min(sum, minSum);
		}
        return minSum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
