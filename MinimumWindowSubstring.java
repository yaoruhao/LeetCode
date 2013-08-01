import java.util.HashMap;

/**
 * 
 * @author yaoruhao
 *
 */
public class MinimumWindowSubstring {

    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	HashMap<Character, Integer> needToFind = new HashMap<Character, Integer>();
        for (int i = 0; i < T.length(); i++) {
        	char tempChar = T.charAt(i);
			if (needToFind.containsKey(tempChar)) {
				needToFind.put(tempChar, needToFind.get(tempChar) + 1);
			} else {
				needToFind.put(tempChar, 1);
			}
		}
        HashMap<Character, Integer> hasFound = new HashMap<Character, Integer>();
        String result = "";
        int count = 0;
        for (int begin = 0, end = 0; end < S.length(); end++) {
        	char tempChar = S.charAt(end);
        	if (!needToFind.containsKey(tempChar)) {
				continue;
			}
			if (hasFound.containsKey(tempChar)) {
				hasFound.put(tempChar, hasFound.get(tempChar) + 1);
			} else {
				hasFound.put(tempChar, 1);
			}
			if (hasFound.get(tempChar) <= needToFind.get(tempChar)) {
				count++;
			}
			if (count == T.length()) {
				tempChar = S.charAt(begin);
				while (!needToFind.containsKey(tempChar) || hasFound.get(tempChar) > needToFind.get(tempChar)) {
					if (needToFind.containsKey(tempChar) && hasFound.get(tempChar) > needToFind.get(tempChar)) {
						hasFound.put(tempChar, hasFound.get(tempChar) - 1);
					}
					begin++;
					tempChar = S.charAt(begin);
				}
				if (result.isEmpty() || result.length() > end - begin + 1) {
					result = S.substring(begin, end + 1);
				}
			}
		}        
        return result;
    }
	public static void main(String[] args) {
		MinimumWindowSubstring test = new MinimumWindowSubstring();
		System.out.println(test.minWindow("of_characters_and_as", "aas"));

	}

}
