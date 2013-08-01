/**
 * 
 * @author yaoruhao
 *
 */
public class LongestSubstringLength {

    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if (s == null || s.length() == 0) {
			return 0;
		}
        int []cache = new int [s.length()];
        String temp = s.substring(0, 1);
        cache[0] = 1;
        for (int i = 1; i < s.length(); i++) {
			if (temp.indexOf(s.charAt(i)) == -1) {
				temp += s.charAt(i);
				cache[i] = temp.length();
			} else {
				temp = temp.substring(temp.indexOf(s.charAt(i)) + 1) + s.charAt(i);
				cache[i] = temp.length();
			}
		}
        int max = 0;
        for (int i = 0; i < cache.length; i++) {
			max = Math.max(cache[i], max);
		}
        return max;
    }
	public static void main(String[] args) {
		LongestSubstringLength test = new LongestSubstringLength();
		System.out.println(test.lengthOfLongestSubstring("bbbb"));
	}

}
