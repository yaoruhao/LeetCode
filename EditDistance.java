/**
 * 
 * @author yaoruhao
 *
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if (word1.isEmpty()) {
			return word2.length();
		}
    	if (word2.isEmpty()) {
			return word1.length();
		}
    	int [][] cache = new int[word1.length()][word2.length()];
    	for (int i = 0; i < cache.length; i++) {
			cache[i] = new int [word2.length()];
			for (int j = 0; j < cache[i].length; j++) {
				cache[i][j] = -1;
			}
		}
        return searchMinDistance(0, 0, word1, word2, cache);
    }
    
    public int searchMinDistance(int i, int j, String word1, String word2, int[][] cache) {
    	if (i == word1.length()) {
			return word2.length() - j;
		}
    	if (j == word2.length()) {
			return word1.length() - i;
		}
    	if (cache[i][j] != -1) {
			return cache[i][j];
		}
    	cache[i][j] = Integer.MAX_VALUE;
    	if (word1.charAt(i) == word2.charAt(j)) {
			cache[i][j] = Math.min(cache[i][j], searchMinDistance(i + 1, j + 1, word1, word2, cache));
		}
    	cache[i][j] = Math.min(cache[i][j], searchMinDistance(i + 1, j, word1, word2, cache) + 1);
    	cache[i][j] = Math.min(cache[i][j], searchMinDistance(i, j + 1, word1, word2, cache) + 1);
    	cache[i][j] = Math.min(cache[i][j], searchMinDistance(i + 1, j + 1, word1, word2, cache) + 1);
    	
    	return cache[i][j];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
