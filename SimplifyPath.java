import java.util.LinkedList;

/**
 * 
 * @author yaoruhao
 *
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	LinkedList<String> dirList = new LinkedList<String>();
    	String []dirs = path.split("/");
    	for (String str : dirs) {
    		if (str.isEmpty()) {
				continue;
			}
			if (str.equals(".")) {
				continue;
			}
			if (str.equals("..")) {
				if (!dirList.isEmpty()) {
					dirList.removeLast();
				}				
				continue;
			}
			dirList.add(str);
		}
    	if (dirList.isEmpty()) {
			return "/";
		}
    	StringBuilder sb = new StringBuilder();
    	for (String tempStr : dirList) {
			sb.append("/" + tempStr);
		}
        return sb.toString();
    }
	public static void main(String[] args) {
		SimplifyPath test = new SimplifyPath();
		System.out.println(test.simplifyPath("/.hidden"));

	}

}
