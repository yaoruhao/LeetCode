/**
 * 
 * @author yaoruhao
 *
 */
public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        int []result = new int[2];
        for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i+1; j < numbers.length; j++) {
				if (numbers[i] + numbers[j] == target) {
					result[0] = i + 1;
					result[1] = j + 1;
					return result;
				}
			}
		}        
        return result;
    }
    
	public static void main(String[] args) {
		TwoSum twoSum = new TwoSum();
		int [] numbers = {2, 7, 11, 15};
		int [] result = twoSum.twoSum(numbers, 26);
		System.out.println(result[0] +" " + result[1]);
	}

}
