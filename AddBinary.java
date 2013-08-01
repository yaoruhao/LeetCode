/**
 * 
 * @author yaoruhao
 *
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	a = new StringBuilder(a).reverse().toString();
    	b = new StringBuilder(b).reverse().toString();
    	if (a.length() > b.length()) {
			String temp = a;
			a = b;
			b = temp;
		}
    	if (a.length() < b.length()) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < b.length() - a.length(); i++) {
				sb.append("0");
			}
			a = a + sb.toString();
		}
    	StringBuilder result = new StringBuilder();
    	int carry = 0;
    	for (int i = 0; i < a.length(); i++) {
			int aNum = a.charAt(i) - '0';
			int bNum = b.charAt(i) - '0';
			int tempSum = aNum + bNum + carry;
			if (tempSum > 1) {
				carry = 1;
			} else {
				carry = 0;
			}
			result.append(tempSum % 2);
		}
    	if (carry == 1) {
			result.append(1);
		}    	
    	return result.reverse().toString();
    }
	public static void main(String[] args) {
		AddBinary test = new AddBinary();
		System.out.println(test.addBinary("0", "0"));

	}

}
