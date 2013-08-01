/**
 * 
 * @author yaoruhao
 * Two dimensional dp, referred to the solution of:http://blog.csdn.net/martin_liang/article/details/8927064
 * 
 */
public class InterleavingString {

	public boolean isInterleave(String s1, String s2, String s3) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}
		boolean[][] cache = new boolean[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i < cache.length; i++) {
			cache[i] = new boolean[s2.length() + 1];
			for (int j = 0; j < cache[i].length; j++) {
				cache[i][j] = false;
			}
		}
		cache[0][0] = true;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == s3.charAt(i)) {
				cache[i + 1][0] = true;
			}
		}
		for (int j = 0; j < s2.length(); j++) {
			if (s2.charAt(j) == s3.charAt(j)) {
				cache[0][j + 1] = true;
			}
		}
		for (int i = 1; i < cache.length; i++) {
			for (int j = 1; j < cache[i].length; j++) {
				if (cache[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1)) {
					cache[i][j] = true;
					continue;
				}
				if (cache[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1)) {
					cache[i][j] = true;
				}
			}
		}
		return cache[s1.length()][s2.length()];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
