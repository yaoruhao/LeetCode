/**
 * 
 * @author yaoruhao
 * Referred to github solution.
 *
 */
public class LongestPalindrome {
	public String longestPalindrome(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s == null || s.length() == 0) {
			return s;
		}
		int maxLength = 0;
		int start = 0;
		for (int i = 0; i < s.length(); i++) {
			int t = lengthWithCurrent(s, i);
			if (t > maxLength) {
				maxLength = t;
				start = i - maxLength + 1;
			}
		}
		return s.substring(start, start + maxLength);
	}

	public int lengthWithCurrent(String s, int end) {
		int result = 1;
		for (int i = 0; i < end; i++) {
			if (s.charAt(i) == s.charAt(end) && isPalindrom(s, i, end)) {
				return end - i + 1;
			}
		}
		return result;
	}

	public boolean isPalindrom(String s, int begin, int end) {
		while (begin < end) {
			if (s.charAt(begin) != s.charAt(end)) {
				return false;
			}
			begin++;
			end--;
		}
		return true;
	}

	public static void main(String[] args) {
		LongestPalindrome test = new LongestPalindrome();
		System.out
				.println(test
						.longestPalindrome("whdqcudjpisufnrtsyupwtnnbsvfptrcgvobbjglmpynebblpigaflpbezjvjgbmofejyjssdhbgghgrhzuplbeptpaecfdanhlylgusptlgobkqnulxvnwuzwauewcplnvcwowmbxxnhsdmgxtvbfgnuqdpxennqglgmspbagvmjcmzmbsuacxlqfxjggrwsnbblnnwisvmpwwhomyjylbtedzrptejjsaiqzprnadkjxeqfdpkddmbzokkegtypxaafodjdwirynzurzkjzrkufsokhcdkajwmqvhcbzcnysrbsfxhfvtodqabvbuosxtonbpmgoemcgkudandrioncjigbyizekiakmrfjvezuzddjxqyevyenuebfwugqelxwpirsoyixowcmtgosuggrkdciehktojageynqkazsqxraimeopcsjxcdtzhlbvtlvzytgblwkmbfwmggrkpioeofkrmfdgfwknrbaimhefpzckrzwdvddhdqujffwvtvfyjlimkljrsnnhudyejcrtrwvtsbkxaplchgbikscfcbhovlepdojmqybzhbiionyjxqsmquehkhzdiawfxunguhqhkxqdiiwsbuhosebxrpcstpklukjcsnnzpbylzaoyrmyjatuovmaqiwfdfwyhugbeehdzeozdrvcvghekusiahfxhlzclhbegdnvkzeoafodnqbtanfwixjzirnoaiqamjgkcapeopbzbgtxsjhqurbpbuduqjziznblrhxbydxsmtjdfeepntijqpkuwmqezkhnkwbvwgnkxmkyhlbfuwaslmjzlhocsgtoujabbexvxweigplmlewumcone"));
	}

}
