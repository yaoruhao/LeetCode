import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 *
 */
public class GenerateParentheses {

    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<String> resultList = new ArrayList<String>();
        if (n < 1) {
			return resultList;
		}
        generateAll(0, n, new StringBuilder(), resultList);
        return resultList;
    }
    
    public void generateAll(int openNum, int leftNum, StringBuilder prefix, ArrayList<String> resultList) {
    	if (leftNum == 0) {
			for (int i = 0; i < openNum; i++) {
				prefix.append(")");
			}
			resultList.add(prefix.toString());
			prefix.delete(prefix.length() - openNum, prefix.length());
			return;
		}
    	if (openNum > 0) {
			prefix.append(")");
			generateAll(openNum - 1, leftNum, prefix, resultList);
			prefix.delete(prefix.length() - 1, prefix.length());
		}
    	prefix.append("(");
    	generateAll(openNum + 1, leftNum - 1, prefix, resultList);
    	prefix.delete(prefix.length() - 1, prefix.length());
    }
	public static void main(String[] args) {
		GenerateParentheses test = new GenerateParentheses();
		System.out.println(test.generateParenthesis(2));
	}

}
