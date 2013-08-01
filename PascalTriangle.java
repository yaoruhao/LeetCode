import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 *
 */
public class PascalTriangle {

    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        if (numRows == 0) {
			return resultList;
		}
        for (int i = 1; i <= numRows; i++) {
			ArrayList<Integer> tempList = new ArrayList<Integer>();
			tempList.add(1);
			if (i == 1) {
				resultList.add(tempList);
				continue;
			}
			ArrayList<Integer> lastRound = resultList.get(resultList.size() - 1);
			for (int j = 1; j < i - 1; j++) {
				tempList.add(lastRound.get(j - 1) + lastRound.get(j));
			}
			tempList.add(1);
			resultList.add(tempList);
		}
        return resultList;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PascalTriangle test = new PascalTriangle();
		System.out.println(test.generate(8));
	}

}
