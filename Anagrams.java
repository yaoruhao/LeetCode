import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author yaoruhao
 *
 */
public class Anagrams {

    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<String, ArrayList<String>> resultMap = new HashMap<String, ArrayList<String>>();
        ArrayList<String> resultList = new ArrayList<String>();
        for (int i = 0; i < strs.length; i++) {
			int [] stats = new int[26];
			for (int j = 0; j < strs[i].length(); j++) {
				stats[strs[i].charAt(j) - 'a']++;
			}
			ArrayList<Integer> tempList = new ArrayList<Integer>();
			for (int stat : stats) {
				tempList.add(stat);
			}
			String fingerPrint = tempList.toString();
			if (resultMap.containsKey(fingerPrint)) {
				resultMap.get(fingerPrint).add(strs[i]);
			} else {
				ArrayList<String> strList = new ArrayList<String>();
				strList.add(strs[i]);
				resultMap.put(fingerPrint, strList);
			}
		}
        for (ArrayList<String> eachSet : resultMap.values()) {
			if (eachSet.size() > 1) {
				for (String string : eachSet) {
					resultList.add(string);
				}
			}
		}
        return resultList;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
