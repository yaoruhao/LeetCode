import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 *
 */
public class PascalTriangleII {

    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        for (int i = 1; i <= rowIndex + 1; i++) {
			ArrayList<Integer> tempList = new ArrayList<Integer>();
			tempList.add(1);
			if (i == 1) {
				resultList = tempList;
				continue;
			}
			for (int j = 1; j < i - 1; j++) {
				tempList.add(resultList.get(j - 1) + resultList.get(j));
			}
			tempList.add(1);
			resultList = tempList;
		}
        return resultList;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PascalTriangleII test = new PascalTriangleII();
		System.out.println(test.getRow(0));
	}

}
