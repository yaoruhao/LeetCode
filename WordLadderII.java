import java.util.ArrayList;
import java.util.HashSet;

/**
 * 
 * @author yaoruhao
 * BFS for length, DFS for path.
 *
 */
public class WordLadderII {

    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<String>> resultList = new ArrayList<ArrayList<String>>();
        if (start.length() != end.length()) {
			return resultList;
		}
        if (start.equals(end)) {
			ArrayList<String> tempList = new ArrayList<String>();
			tempList.add(start);
			resultList.add(tempList);
			return resultList;
		}
        minStep = ladderLength(start, end, (HashSet<String>) dict.clone());
        ArrayList<String> tempList = new ArrayList<String>();
        tempList.add(start);
        searchAllLadder(start, end, 0, dict, tempList, resultList);
        return resultList;
    }
    
    public int minStep;
    
    public void searchAllLadder(String start, String end, int curStep, HashSet<String> dict, ArrayList<String> path, ArrayList<ArrayList<String>> resultList) {
    	if (curStep >= minStep) {
			return;
		}
    	for (int i = 0; i < start.length(); i++) {					
			for (int j = 0; j < 26; j++) {
				char tempChar = (char) ('a' + j);
				if (start.charAt(i) == tempChar) {
					continue;
				}
				String tempStr = start.substring(0, i) + tempChar;
				if (i+1 < start.length()) {
					tempStr += start.substring(i + 1);
				}
				if (path.contains(tempStr)) {
					continue;
				}
		    	if (tempStr.equals(end)) {
		    		if (path.size() + 1 > minStep) {
						return;
					}
		    		path.add(tempStr);
		    		minStep = path.size();
					for (int k = 0; k < resultList.size(); k++) {
						if (resultList.get(k).size() > minStep) {
							resultList.remove(k);
							k--;
						}
					}
					resultList.add((ArrayList<String>) path.clone());
					path.remove(path.size() - 1);
					return;
				}
		    	if (!dict.contains(tempStr)) {
					continue;
				}
				path.add(tempStr);
				searchAllLadder(tempStr, end, curStep + 1, dict, path, resultList);
				path.remove(path.size() - 1);
			}
		}
    }
    
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (start.length() != end.length() || start.equals(end)) {
			return 0;
		}

        HashSet<String> lastRound = new HashSet<String>();
        HashSet<String> curRound = new HashSet<String>();
        lastRound.add(start);
        boolean freshAdd = false;
        int round = 1;
        while (!dict.isEmpty()) {
        	freshAdd = false;
        	int checkResult = Integer.MAX_VALUE;
			for (String eachStr : lastRound) {
				if (eachStr.equals(end)) {
					checkResult = Math.min(checkResult, round);
				}
				if (canTransform(eachStr, end)) {
					checkResult = Math.min(checkResult, round + 1);
				}
			}
			if (checkResult != Integer.MAX_VALUE) {
				return checkResult;
			}
			for (String leftStr : dict) {
				for (int i = 0; i < leftStr.length(); i++) {					
					for (int j = 0; j < 26; j++) {
						char tempChar = (char) ('a' + j);
						if (leftStr.charAt(i) == tempChar) {
							continue;
						}
						String tempStr = leftStr.substring(0, i) + tempChar;
						if (i+1 < leftStr.length()) {
							tempStr += leftStr.substring(i + 1);
						}
						if (lastRound.contains(tempStr)) {
							curRound.add(leftStr);
							freshAdd = true;
						}
					}
				}
			}

			dict.removeAll(curRound);
			if (!freshAdd) {
				return 0;
			}
			round++;
			lastRound.clear();
			lastRound.addAll(curRound);
			curRound.clear();

		}
        return 0;
    }
    
    public boolean canTransform(String s, String t) {
    	int changeSpot = 0;
    	for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != t.charAt(i)) {
				changeSpot++;
			}
		}
    	if (changeSpot == 1) {
			return true;
		} else {
			return false;
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordLadderII test = new WordLadderII();
		String[] wordList = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
		HashSet<String> dict = new HashSet<String>();
		for (String string : wordList) {
			dict.add(string);
		}
		System.out.println(test.findLadders("qa", "sq", dict));
	}

}
