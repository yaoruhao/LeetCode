import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 *
 */
public class MultiplyString {
    public String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}
        String smallStr = null;
        String bigStr = null;
        ArrayList<Integer> smallList = new ArrayList<Integer>();
        ArrayList<Integer> bigList = new ArrayList<Integer>(); 
        if (num1.length() < num2.length()) {
			smallStr = num1;
			bigStr = num2;
		} else {
			smallStr = num2;
			bigStr = num1;
		}
        for (int i = smallStr.length() - 1; i >= 0; i--) {
			smallList.add(smallStr.charAt(i) - '0');
		}
        for (int i = bigStr.length() - 1; i >= 0; i-- ) {
        	bigList.add(bigStr.charAt(i) - '0');
        }
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        for (int i = 0; i < smallList.size(); i++) {
			int round = smallList.get(i);
			while (round > 0) {
				addList(resultList, bigList);
				round--;
			}
			if (i != smallList.size() - 1) {
				bigList.add(0, 0);
			}
		}
        for (int i = 0; i < resultList.size() - 1; i++) {
			int num = resultList.get(i);
			if (num > 9) {
				resultList.set(i, num % 10);
				resultList.set(i+1, resultList.get(i+1) + num/10);
			}
		}
        while (resultList.get(resultList.size() - 1) > 9) {
			int num = resultList.get(resultList.size() - 1);
			resultList.set(resultList.size() - 1, num % 10);
			resultList.add(num / 10);
		}
        for (int i = resultList.size() - 1; i >= 0; i--) {
			if (resultList.get(i) != 0) {
				break;
			}
			resultList.remove(i);
		}
        StringBuilder result = new StringBuilder();
        for (int i = resultList.size() - 1; i >= 0; i--) {
			result.append(resultList.get(i));
		}
        return result.toString();
    }
    
    public void addList(ArrayList<Integer> aList, ArrayList<Integer> bList) {
    	if (aList.isEmpty()) {
			aList.addAll(bList);
			return;
		}
    	for (int i = 0; i <= bList.size() - aList.size(); i++) {
			aList.add(0);
		}
    	for (int i = 0; i < bList.size(); i++) {
    		if (aList.size() > i) {
    			aList.set(i, aList.get(i) + bList.get(i));
			} else {
				aList.add(bList.get(i));
			}
			
		}
    }
	public static void main(String[] args) {
		MultiplyString test = new MultiplyString();
		System.out.println(test.multiply("9999", "99999"));

	}

}
