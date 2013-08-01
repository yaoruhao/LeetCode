/**
 * 
 * @author yaoruhao
 *
 */
public class StrStr {

    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if (haystack == null || needle == null || haystack.length() < needle.length()) {
    		return null;
		}
    	if (needle.isEmpty()) {
			return haystack;
		}
    	for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
			if (haystack.charAt(i) != needle.charAt(0)) {
				continue;
			}
			boolean flag = true;
			for (int j = 1; j < needle.length(); j++) {
				if (haystack.charAt(i + j) != needle.charAt(j)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				return haystack.substring(i);
			}
		}
    	return null;
    }
	public static void main(String[] args) {
		StrStr test = new StrStr();
		System.out.println(test.strStr("a", "a"));
	}

}
