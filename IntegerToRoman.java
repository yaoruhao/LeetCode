/**
 * 
 * @author yaoruhao
 *
 */
public class IntegerToRoman {

    public String intToRoman(int num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        StringBuilder sb = new StringBuilder();
        while (num >= 1000) {
			sb.append("M");
			num -= 1000;
		}
        if (num >= 900) {
			sb.append("CM");
			num -= 900;
		} else if (num >= 500) {
			sb.append("D");
			int round = (num - 500) / 100;
			for (int i = 0; i < round; i++) {
				sb.append("C");
				num -= 100;
			}
			num -= 500;
		} else if (num >= 400) {
			sb.append("CD");
			num -= 400;
		} else if (num >= 100) {
			int round = num / 100;
			for (int i = 0; i < round; i++) {
				sb.append("C");
				num -= 100;
			}
		}
        if (num >= 90) {
        	sb.append("XC");
        	num -= 90;
        } else if (num >= 50) {
			sb.append("L");
			int round = (num - 50) / 10;
			for (int i = 0; i < round; i++) {
				sb.append("X");
				num -= 10;
			}
			num -= 50;
		} else if (num >= 40) {
			sb.append("XL");
			num -= 40;
		} else if (num >= 10) {
			int round = num / 10;
			for (int i = 0; i < round; i++) {
				sb.append("X");
				num -= 10;
			}
		}
        if (num == 9) {
			sb.append("IX");
		} else if (num >= 5) {
			sb.append("V");
			int round = num - 5;
			for (int i = 0; i < round; i++) {
				sb.append("I");
			}
		} else if (num == 4) {
			sb.append("IV");
		} else if (num > 0) {
			for (int i = 0; i < num; i++) {
				sb.append("I");
			}
		}
        return sb.toString();
    }
	public static void main(String[] args) {
		IntegerToRoman test = new IntegerToRoman();
		System.out.println(test.intToRoman(1));

	}

}
