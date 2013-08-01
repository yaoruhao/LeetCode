/**
 * 
 * @author yaoruhao
 *
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        StringBuilder sb = new StringBuilder();
        if (strs.length < 1) {
			return "";
		}
        if (strs.length == 1) {
			return strs[0];
		}
        int index = 0;
        while (true) {
			if (index >= strs[0].length()) {
				break;
			}
			char tempChar = strs[0].charAt(index);
			boolean flag = true;
			for (int i = 1; i < strs.length; i++) {
				if (strs[i].length() <= index) {
					flag = false;
					break;
				}
				if (strs[i].charAt(index) != tempChar) {
					flag = false;
					break;
				}
			}
			if (!flag) {
				break;
			}
			sb.append(tempChar);
			index++;
		}
        return sb.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
