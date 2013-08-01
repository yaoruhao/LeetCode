/**
 * 
 * @author yaoruhao
 * Referred to the github solution:https://github.com/yuanx/leetcode/blob/master/JumpGame.java
 *
 */
public class JumpGame {

    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null || A.length <= 1) {
			return true;
		}
        return checkJump(A, 0);
    }
    
    public boolean checkJump(int []A, int currentPos) {
    	if (A[currentPos] + currentPos >= A.length - 1) {
			return true;
		}
    	for (int i = 1; i < A[currentPos]; i++) {
			if (checkJump(A, currentPos + i)) {
				return true;
			}
		}    	
    	return false;
    }
    
    public boolean gitHubSolution(int[] A) {
        if(A.length<=1) return true;
        int last = A.length -1;
        int ll;        
        while(last>0){
            ll = last;
            for(int i=0; i<last; i++){
                if(i+A[i]>=last)
                    last = i;
            }
            
            if(ll == last)
                return false;
        }
        
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
