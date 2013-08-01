import java.util.HashMap;

/**
 * 
 * @author yaoruhao
 *
 */
public class ScrambleString {

    public boolean isScramble(String s1, String s2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s1.length() != s2.length()) {
			return false;
		}
        HashMap<String, Boolean> cache = new HashMap<String, Boolean>();
        return checkNode(s1, s2, cache);
    }
    
    public boolean checkNode(String s1, String s2, HashMap<String, Boolean> cache) {
    	String key;
    	if (s1.compareTo(s2) > 0) {
			key = s1 + s2;
		} else {
			key = s2 + s1;
		}
    	if (cache.containsKey(key)) {
			return cache.get(key);
		}
    	if (s1.length() != s2.length()) {
			cache.put(key, false);
    		return false;
		}
    	if (s1.isEmpty()) {
    		cache.put(key, true);
			return true;
		}
    	if (s1.length() == 1) {
			if (s1.equals(s2)) {
				cache.put(key, true);
				return true;
			} else {
				cache.put(key, false);
				return false;
			}
		}
    	if (s1.length() == 2) {
			if (s1.charAt(0) == s2.charAt(0) && s1.charAt(1) == s2.charAt(1)) {
				cache.put(key, true);
				return true;
			}
			if (s1.charAt(0) == s2.charAt(1) && s1.charAt(1) == s2.charAt(0)) {
				cache.put(key, true);
				return true;
			}
			cache.put(key, false);
			return false;
		}
    	if (s1.equals(s2)) {
			cache.put(key, true);
			return true;
		}
    	for (int i = 1; i < s1.length(); i++) {
			if ((checkNode(s1.substring(0, i), s2.substring(0, i), cache) && checkNode(s1.substring(i), s2.substring(i), cache)) ||
					(checkNode(s1.substring(s1.length() - i), s2.substring(0, i), cache) && checkNode(s1.substring(0, s1.length() - i), s2.substring(i), cache))) {
				cache.put(key, true);
				return true;
			}
		}    	
    	cache.put(key, false);
    	return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
