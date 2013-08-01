import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 *
 */
public class LetterCombination {

    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<String> resultList = new ArrayList<String>();
    	char [][] table = new char[10][];
    	initMapTable(table);
    	if (!digits.isEmpty()) {
			iterateDigits(0, digits, resultList, "", table);
		} else {
			resultList.add("");
		}
    	return resultList;
        
    }
    
    public void iterateDigits(int index, String digits, ArrayList<String> resultList, String currentString, char[][] table) {
    	if (index == digits.length()) {
			resultList.add(currentString);
    		return;
		}
    	int number = digits.charAt(index) - '0';
    	if (number <= 1) {
			iterateDigits(index + 1, digits, resultList, currentString, table);
		} else {
			for (Character tempChar : table[number]) {
				iterateDigits(index + 1, digits, resultList, currentString + tempChar, table);
			}
		}
    }
    
    public void initMapTable(char [][] table) {
    	table[0] = new char[0];
    	table[1] = new char[0];
    	int alphabetCount = 0;
    	for (int i = 2; i <= 6; i++) {
			table[i] = new char[3];
			for (int j = 0; j < 3; j++) {
				table[i][j] = (char) ('a' + alphabetCount);
				alphabetCount++;
			}
		}
    	table[7] = new char[4];
    	for (int i = 0; i < 4; i++) {
			table[7][i] = (char) ('a' + alphabetCount);
			alphabetCount++;
		}
    	table[8] = new char[3];
    	for (int i = 0; i < 3; i++) {
			table[8][i] = (char) ('a' + alphabetCount);
			alphabetCount++;
		}
    	table[9] = new char[4];
    	for (int i = 0; i < 4; i++) {
			table[9][i] = (char) ('a' + alphabetCount);
			alphabetCount++;
		}
    }
	public static void main(String[] args) {
		LetterCombination test = new LetterCombination();
		System.out.println(test.letterCombinations("6"));
	}

}
