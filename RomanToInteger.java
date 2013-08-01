/**
 * 
 * @author yaoruhao
 *
 */
public class RomanToInteger {

    public int romanToInt(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'M') {
				result += 1000;
				continue;
			}
			if (s.indexOf("CM", i) == i) {
				result += 900;
				i++;
				continue;
			}
			if (s.charAt(i) == 'D') {
				result += 500;
				for (int j = i + 1; j < s.length() && s.charAt(j) == 'C'; j++) {
					result += 100;
					i++;
				}
				continue;
			}
			if (s.indexOf("CD", i) == i) {
				result += 400;
				i++;
				continue;
			}
			if (s.charAt(i) == 'C') {
				for (int j = i; j < s.length() && s.charAt(j) == 'C'; j++) {
					result += 100;
					i++;
				}
				i--;
				continue;
			}
			if (s.indexOf("XC", i) == i) {
				result += 90;
				i++;
				continue;
			}
			if (s.charAt(i) == 'L') {
				result += 50;
				for (int j = i + 1; j < s.length() && s.charAt(j) == 'X'; j++) {
					result += 10;
					i++;
				}
				continue;
			}
			if (s.indexOf("XL", i) == i) {
				result += 40;
				i++;
				continue;
			}
			if (s.charAt(i) == 'X') {
				for (int j = i; j < s.length() && s.charAt(j) == 'X'; j++) {
					result += 10;
					i++;
				}
				i--;
				continue;
			}
			if (s.indexOf("IX", i) == i) {
				result += 9;
				break;
			}
			if (s.charAt(i) == 'V') {
				result += 5;
				for (int j = i + 1; j < s.length() && s.charAt(j) == 'I'; j++) {
					result++;
					i++;
				}
				break;
			}
			if (s.indexOf("IV", i) == i) {
				result += 4;
				break;
			}
			if (s.charAt(i) == 'I') {
				for (int j = i; j < s.length() && s.charAt(j) == 'I'; j++) {
					result++;
				}
				break;
			}
		}
        return result;
    }
	public static void main(String[] args) {
		RomanToInteger test = new RomanToInteger();
		System.out.println(test.romanToInt("XI"));

	}

}
