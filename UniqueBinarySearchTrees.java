import java.util.HashMap;

/**
 * 
 * @author yaoruhao
 * 
 */
public class UniqueBinarySearchTrees {

	public int numTrees(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		return searchAll(n, new HashMap<Integer, Integer>());
	}

	public int searchAll(int n, HashMap<Integer, Integer> cache) {
		if (n <= 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		if (cache.containsKey(n)) {
			return cache.get(n);
		}
		int result = 0;
		for (int i = 0; i < n; i++) {
			result += searchAll(i, cache) * searchAll(n - i - 1, cache);
		}
		cache.put(n, result);
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
