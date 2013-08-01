/**
 * 
 * @author yaoruhao
 * 
 */
public class WildcardMatching {

	public boolean isMatch(String s, String p) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s.isEmpty()) {
			if (p.isEmpty()) {
				return true;
			}
			for (int i = 0; i < p.length(); i++) {
				if (p.charAt(i) != '*') {
					return false;
				}
			}
			return true;
		}
		if (p.indexOf("*") == -1) {
			if (s.length() != p.length()) {
				return false;
			}
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) != p.charAt(i) && p.charAt(i) != '?') {
					return false;
				}
			}
			return true;
		} else {
			String[] strs = p.split("\\*");
			boolean matchFromBegining = false;
			if (!p.startsWith("*")) {
				matchFromBegining = true;
			}
			if (matchFromBegining) {
				if (strs[0].length() > s.length()) {
					return false;
				}
				for (int i = 0; i < strs[0].length(); i++) {
					if (s.charAt(i) != strs[0].charAt(i)
							&& strs[0].charAt(i) != '?') {
						return false;
					}
				}
			}
			boolean matchToEnd = false;
			if (!p.endsWith("*")) {
				matchToEnd = true;
			}
			if (matchToEnd) {
				String tailStr = strs[strs.length - 1];
				if (tailStr.length() > s.length()) {
					return false;
				}
				for (int i = 0; i < tailStr.length(); i++) {
					if (s.charAt(s.length() - 1 - i) != tailStr.charAt(tailStr
							.length() - 1 - i)
							&& tailStr.charAt(tailStr.length() - 1 - i) != '?') {
						return false;
					}
				}
			}
			int sIndex = 0;
			for (int i = 0; i < strs.length; i++) {
				if (strs[i].isEmpty()) {
					continue;
				}
				if (sIndex + strs[i].length() > s.length()) {
					return false;
				}
				boolean matched = true;
				for (int j = 0; j < strs[i].length(); j++) {
					if (s.charAt(sIndex + j) != strs[i].charAt(j)
							&& strs[i].charAt(j) != '?') {
						matched = false;
						break;
					}
				}
				if (matched) {
					sIndex += strs[i].length();
				} else {
					i--;
					sIndex++;
				}
			}
			return true;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WildcardMatching test = new WildcardMatching();
		System.out.println(test.isMatch("a", "a*"));

	}

}
