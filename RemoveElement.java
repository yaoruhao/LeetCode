/**
 * 
 * @author yaoruhao
 *
 */
public class RemoveElement {

    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int tempLength = A.length;
    	for (int i = 0; i < tempLength; i++) {
    		//find elem
			if (A[i] != elem) {
				continue;
			}
			boolean flag = false;
			//find tempElem != elem from tail
			for (int j = tempLength - 1; j > i; j--) {
				if (A[j] == elem) {
					tempLength--;
					continue;
				}
				//substitute and reduce tempLength
				A[i] = A[j];
				flag = true;
				tempLength--;
				break;
			}
			if (!flag) {
				tempLength = i;
				break;
			}
		}
    	return tempLength;        
    }
	public static void main(String[] args) {
		RemoveElement test = new RemoveElement();
		int []inputs = {1};
		System.out.println(test.removeElement(inputs, 1));
		for (int i = 0; i < inputs.length; i++) {
			System.out.print(inputs[i]);
		}
	}

}
