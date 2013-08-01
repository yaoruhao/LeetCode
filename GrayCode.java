import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 *
 */
public class GrayCode {

    public ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<Integer> resultList = new ArrayList<Integer>();
    	if (n == 0) {
    		resultList.add(0);
			return resultList;
		}
    	generateGrayCode(n, 0, resultList, new ArrayList<Integer>(n), true);
        return resultList;
    }
    
    public void generateGrayCode(int n, int current, ArrayList<Integer> resultList, ArrayList<Integer> tempList, boolean flag) {
    	if (current == n) {
			int num = 0;
			for (int i = 0; i < tempList.size(); i++) {
				num = num << 1;
				if (tempList.get(i) == 0) {
					num |= 0;
				} else {
					num |= 1;
				}
			}
			resultList.add(num);
			return;
		}
    	if (flag) {
			tempList.add(0);
			generateGrayCode(n, current + 1, resultList, tempList, true);
			tempList.set(tempList.size() - 1, 1);
			generateGrayCode(n, current + 1, resultList, tempList, false);
			tempList.remove(tempList.size() - 1);
		} else {
			tempList.add(1);
			generateGrayCode(n, current + 1, resultList, tempList, true);
			tempList.set(tempList.size() - 1, 0);
			generateGrayCode(n, current + 1, resultList, tempList, false);
			tempList.remove(tempList.size() - 1);
		}    	
    }
	public static void main(String[] args) {
		GrayCode test = new GrayCode();
		System.out.println(test.grayCode(3));

	}

}
