import java.util.Stack;

/**
 * 
 * @author yaoruhao
 *
 */
public class ValidParentheses {
	
	public class Status{
		int c1;
		int c2;
		int c3;
		public Status(int c1, int c2, int c3) {
			this.c1 = c1;
			this.c2 = c2;
			this.c3 = c3;
		}
		
	}

    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s.length() % 2 != 0) {
			return false;
		}
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        Stack<Status> c1Stack = new Stack<Status>();
        Stack<Status> c2Stack = new Stack<Status>();
        Stack<Status> c3Stack = new Stack<Status>();
        for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				c1++;
				c1Stack.push(new Status(c1, c2, c3));
			}
			if (s.charAt(i) == ')') {
				if (c1 < 1) {
					return false;
				}
				c1--;
				Status temp = c1Stack.pop();
				if (temp.c2 != c2 || temp.c3 != c3) {
					return false;
				}
			}
			if (s.charAt(i) == '[') {
				c2++;
				c2Stack.push(new Status(c1, c2, c3));
			}
			if (s.charAt(i) == ']') {
				if (c2 < 1) {
					return false;
				}
				c2--;
				Status temp = c2Stack.pop();
				if (temp.c1 != c1 || temp.c3 != c3) {
					return false;
				}
			}
			if (s.charAt(i) == '{') {
				c3++;
				c3Stack.push(new Status(c1, c2, c3));
			}
			if (s.charAt(i) == '}') {
				if (c3 < 1) {
					return false;
				}
				c3--;
				Status temp = c3Stack.pop();
				if (temp.c1 != c1 || temp.c2 != c2) {
					return false;
				}
			}
		}
        if (c1 != 0 || c2 != 0 || c3 != 0) {
			return false;
		}
    	return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
