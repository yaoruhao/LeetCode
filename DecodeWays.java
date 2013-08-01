import java.util.HashMap;

/**
 * 
 * @author yaoruhao
 *
 */
public class DecodeWays {

    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if (s.isEmpty()) {
			return 0;
		}
        return searchDecodeWays(s, new HashMap<String, Integer>());
    }
    
    public int searchDecodeWays(String s, HashMap<String, Integer> cache) {
    	if (s.isEmpty()) {
			return 1;
		}
    	if (cache.containsKey(s)) {
			return cache.get(s);
		}
    	int code = Integer.valueOf(s.substring(0, 1));
    	if (code < 1 || code > 26) {
			cache.put(s, 0);
			return 0;
		}
    	int ways = searchDecodeWays(s.substring(1), cache);
    	if (s.length() > 1) {
        	code = Integer.valueOf(s.substring(0, 2));
        	if (code <= 26 && code >= 1) {
    			ways += searchDecodeWays(s.substring(2), cache);
    		}
		}

    	cache.put(s, ways);
    	return ways;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
