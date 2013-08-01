/**
 * 
 * @author yaoruhao
 * Referred to solutions of https://github.com/yuanx/leetcode/blob/master/MedianOfTwoSortedArrays.java 
 *
 */
public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int A[], int B[]) {
    	if (A.length == 0 && B.length == 0) {
			return 0;
		}
    	if (A.length == 0) {
			if (B.length % 2 == 0) {
				return (B[B.length / 2 - 1] + B[B.length / 2]) / 2.0;
			} else {
				return B[B.length / 2];
			}
		}
    	if (B.length == 0) {
			if (A.length % 2 == 0) {
				return (A[A.length / 2 - 1] + A[A.length / 2]) / 2.0;
			} else {
				return A[A.length / 2];
			}
		}
    	if (A.length < B.length) {
			return medianSortedArrays(A, B, 0, 0, A.length - 1, B.length - 1);
		} else {
			return medianSortedArrays(B, A, 0, 0, B.length - 1, A.length - 1);
		}
    }
    
    public double medianOfFour(int a, int b, int c, int d) {
    	int min = Math.min(a, Math.min(b, Math.min(c, d)));
    	int max = Math.max(a, Math.max(b, Math.max(c, d)));
    	return (a + b + c + d - min - max) / 2.0;
    }
    
    public double medianOfThree(int a, int b, int c) {
    	int min = Math.min(a, Math.min(b, c));
    	int max = Math.max(a, Math.max(b, c));
    	return a + b + c - min - max;
    }
    
    public double medianSortedArrays(int a[], int b[], int leftA, int leftB, int rightA, int rightB) {
    	int aElemNum = rightA - leftA + 1;
    	int bElemNum = rightB - leftB + 1;
    	int midA = (leftA + rightA + 1) / 2;
    	int midB = (leftB + rightB + 1) / 2;
    	if (aElemNum == 1) {
			if (bElemNum == 1) {
				return (a[leftA] + b[leftB]) / 2.0;
			}
			if (bElemNum % 2 == 1) {
				return (b[(leftB + rightB)/2] + medianOfThree(a[leftA], b[(leftB + rightB)/2 - 1], b[(leftB + rightB) / 2 + 1])) / 2;
			} else {
				return medianOfThree(a[leftA], b[(leftB + rightB + 1) / 2 - 1], b[(leftB + rightB + 1) / 2]);
			}
		}
    	if (aElemNum == 2) {
			if (bElemNum == 2) {
				return medianOfFour(a[leftA], a[rightA], b[leftB], b[rightB]);
			}
			if (bElemNum % 2 == 1) {
				return medianOfThree(b[(leftB + rightB) / 2], Math.min(a[leftA], b[(leftB + rightB) / 2 + 1]), Math.max(a[rightA], b[(leftB + rightB) / 2 - 1]));
			} else {
				return medianOfFour(b[(leftB + rightB + 1) / 2], b[(leftB + rightB + 1) / 2 - 1], Math.min(a[leftA], b[(leftB + rightB + 1) / 2 + 1]), Math.max(a[rightA], b[(leftB + rightB + 1) / 2 - 2]));
			}
		}
    	int minRemoved = 0;
    	if (a[midA] <= b[midB]) {
			if (aElemNum % 2 == 0) {
				midA--;
			}
			minRemoved = Math.min(midA - leftA, bElemNum - (midB - leftB + 1));
			return medianSortedArrays(a, b, leftA + minRemoved, leftB, rightA, rightB - minRemoved);
		} else {
			if (bElemNum % 2 == 0) {
				midB--;
			}
			minRemoved = Math.min(midB - leftB, aElemNum - (midA - leftA + 1));
			return medianSortedArrays(a, b, leftA, leftB + minRemoved, rightA - minRemoved, rightB);
		}
    }
	public static void main(String[] args) {
		int [] A = {1, 6, 7};
		int [] B = {2, 3, 4, 5, 8, 9, 10};
		FindMedianSortedArrays test = new FindMedianSortedArrays();
		System.out.println(test.findMedianSortedArrays(A, B));

	}

}
