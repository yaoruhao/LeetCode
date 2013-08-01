/**
 * 
 * @author yaoruhao
 *
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int count = 0;
        for (int i = 0; i < A.length; i++) {
			int number = A[i];
			for (int j = i + 1; j < A.length; j++) {
				if (A[j] != number) {
					break;
				}
				i++;
			}
			A[count++] = number;
		}
        return count;
    }
	public static void main(String[] args) {
		RemoveDuplicates test = new RemoveDuplicates();
		int []inputs = {1, 1, 1, 2, 2, 3, 4, 5, 5};
		System.out.println(test.removeDuplicates(inputs));
		for (int i = 0; i < inputs.length; i++) {
			System.out.print(inputs[i]);
		}

	}

}
