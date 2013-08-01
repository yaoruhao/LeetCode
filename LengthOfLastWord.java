/**
 * 
 * @author yaoruhao
 *
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ') {
				continue;
			}
			result++;
			for (int j = i - 1; j >= 0; j--) {
				if (s.charAt(j) == ' ') {
					break;
				}
				result++;
			}
			break;
		}
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
