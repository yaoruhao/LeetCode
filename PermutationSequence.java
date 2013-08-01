import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 *
 */
public class PermutationSequence {

    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        StringBuilder sb = new StringBuilder();
        int []eachRound = new int[n + 1];
        eachRound[0] = 1;
        eachRound[1] = 1;
        for (int i = 2; i < eachRound.length; i++) {
			eachRound[i] = i * eachRound[i-1];
		}
        ArrayList<Integer> digitList = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
			digitList.add(i + 1);
		}
        for (int i = n; i > 1; i--) {
			int pickNum = (k-1) / eachRound[i - 1];
			sb.append(digitList.get(pickNum));
			digitList.remove(pickNum);
			k = (k - 1) % eachRound[i - 1] + 1;
		}
        sb.append(digitList.get(0));
        return sb.toString();
    }
	public static void main(String[] args) {
		PermutationSequence test = new PermutationSequence();
		System.out.println(test.getPermutation(3, 3));

	}

}
