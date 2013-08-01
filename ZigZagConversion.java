/**
 * 
 * @author yaoruhao
 *
 */
public class ZigZagConversion {

    public String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if (s == null || s.length() <= 1 || nRows <= 1) {
			return s;
		}
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nRows; i++) {
			int j = i;
			while(j < s.length()) {
				sb.append(s.charAt(j));
				if (i != 0 && i != nRows - 1) {
					int temp = j + 2*(nRows - i - 1);
					if (temp < s.length()) {
						sb.append(s.charAt(temp));
					}
				}
				j += nRows + nRows - 2;
			}
		}
        return sb.toString();
    }
	public static void main(String[] args) {
		ZigZagConversion test = new ZigZagConversion();
		System.out.println(test.convert("PAYPALISHIRING", 3));
	}

}
