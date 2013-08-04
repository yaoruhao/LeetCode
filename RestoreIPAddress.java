import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 *
 */
public class RestoreIPAddress {

    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<String> resultList = new ArrayList<String>();
    	if (s.length() < 4) {
			return resultList;
		}
        searchAllIP(4, s, "", resultList);
    	return resultList;
    }
    
    public void searchAllIP(int current, String s, String prefix, ArrayList<String> resultList) {
    	if (s.isEmpty() || s.length() > current * 3) {
			return;
		}
    	if (current == 1) {
    		if (s.startsWith("0") && s.length() > 1) {
				return;
			}
			int value = Integer.valueOf(s);
			if (value > 255) {
				return;
			}
			resultList.add(prefix + s);
			return;
		}
    	if (s.startsWith("0")) {
			String tempStr = s.substring(0, 1);
			searchAllIP(current - 1, s.substring(1), prefix + tempStr + ".", resultList);
		} else {
	    	for (int i = 1; i <= 3; i++) {
				if (s.length() < i) {
					break;
				}
				String tempStr = s.substring(0, i);
				if (Integer.valueOf(tempStr) < 256) {
					searchAllIP(current - 1, s.substring(i), prefix + tempStr + ".", resultList);
				}
			}
		}

    }
	public static void main(String[] args) {
		RestoreIPAddress test = new RestoreIPAddress();
		System.out.println(test.restoreIpAddresses("25525511135"));

	}

}
