/**
 * 
 * @author yaoruhao
 * The question is not clear, this solution referred to https://github.com/yuanx/leetcode/blob/master/CountAndSay.java
 *
 */
public class CountAndSay {

    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	StringBuilder sb = new StringBuilder();
    	String result = "1";
    	while (n > 1) {
    		char current = result.charAt(0);
    		int count = 0;
    		for (int i = 0; i < result.length();) {
				if (result.charAt(i) == current) {
					count++;
					i++;
				} else {
					sb.append(count);
					sb.append(current);
					current = result.charAt(i);
					count = 0;
				}
			}
    		sb.append(count);
    		sb.append(current);
    		result = sb.toString();
    		sb = new StringBuilder();
    		n--;
		}
    	
    	return result;
    }
	public static void main(String[] args) {
		CountAndSay test = new CountAndSay();
		System.out.println(test.countAndSay(5));
	}

}
