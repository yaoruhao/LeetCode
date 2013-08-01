import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 *
 */
public class TextJustification {

    public ArrayList<String> fullJustify(String[] words, int L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> resultList = new ArrayList<String>();
        ArrayList<String> tempList = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
			int count = 0;
			tempList.clear();
			for (int j = i; j < words.length; j++) {
				int spaceCount = tempList.size();
				if (spaceCount + count + words[j].length() <= L) {
					tempList.add(words[j]);
					count += words[j].length();
					i++;
					continue;
				}
				i = j - 1;
				break;
			}
			if (tempList.size() == 1) {
				StringBuilder sb = new StringBuilder();
				sb.append(tempList.get(0));
				for (int j = sb.length(); j < L; j++) {
					sb.append(" ");
				}
				resultList.add(sb.toString());
				continue;
			}
			if (i < words.length - 1) {
				int spaceSpot = tempList.size() - 1;
				int spaceNeed = L - count;
				StringBuilder sb = new StringBuilder();
				sb.append(tempList.get(0));
				int extraSpace = spaceNeed % spaceSpot;
				for (int j = 1; j < tempList.size(); j++) {
					if (extraSpace > 0) {
						sb.append(" ");
						extraSpace--;
					}
					for (int k = 0; k < spaceNeed/spaceSpot; k++) {
						sb.append(" ");
					}
					sb.append(tempList.get(j));
				}
				resultList.add(sb.toString());
			} else {
				StringBuilder sb = new StringBuilder();
				sb.append(tempList.get(0));
				for (int j = 1; j < tempList.size(); j++) {
					sb.append(" ");
					sb.append(tempList.get(j));
				}
				for (int j = sb.length(); j < L; j++) {
					sb.append(" ");
				}
				resultList.add(sb.toString());
			}

		}
        
        return resultList;
    }
	public static void main(String[] args) {
		String []words = {"a", "b", "c", "d", "e"};
		TextJustification test = new TextJustification();
		System.out.println(test.fullJustify(words, 3));

	}

}
