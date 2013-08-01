import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 *
 */
public class PalindromePartitioning {

    public ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<String>> resultList = new ArrayList<ArrayList<String>>();
        if (s.isEmpty()) {
			return resultList;
		}
        searchAllPalindrome(s, new ArrayList<String>(), resultList);
        return resultList;
    }
    
    public void searchAllPalindrome(String s, ArrayList<String> currentList, ArrayList<ArrayList<String>> resultList) {
    	if (s.isEmpty()) {
			resultList.add((ArrayList<String>) currentList.clone());
		}
    	for (int i = 1; i <= s.length(); i++) {
			String subStr = s.substring(0, i);
			if (subStr.equals(new StringBuilder(subStr).reverse().toString())) {
				currentList.add(subStr);
				searchAllPalindrome(s.substring(i), currentList, resultList);
				currentList.remove(currentList.size() - 1);
			}
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
