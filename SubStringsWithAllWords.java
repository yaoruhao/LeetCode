import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author yaoruhao
 * Referred to the solution of http://www.cnblogs.com/lichen782/archive/2013/07/06/leetcode_SubstringwithConcatenationofAllWords.html
 *
 */
public class SubStringsWithAllWords {

	public  ArrayList<Integer> findSubstring(String S, String[] L) {
        int lengthPerKey = L[0].length();
        int numberOfKeys = L.length;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(String str : L){
            if(!map.containsKey(str)){
                map.put(str, 1);
            }else {
                map.put(str, map.get(str) + 1);
            }
        }
        
        for(int i = 0; i <= S.length() - numberOfKeys*lengthPerKey; i++){
            int j = 0;
            int st = i;
            HashMap<String, Integer> wordsCount = new HashMap<String, Integer>(map);
            for(; j < numberOfKeys; j++){
                if(S.length() - st < (numberOfKeys - j)*lengthPerKey)
                	break;
                String sub = S.substring(st, st + lengthPerKey);
                if(wordsCount.containsKey(sub)){
                    int times = wordsCount.get(sub);
                    if(times == 1) 
                    	wordsCount.remove(sub);
                    else 
                    	wordsCount.put(sub, times - 1);
                } else 
                	break;
                st += lengthPerKey;
            }
            if(j == numberOfKeys){
                result.add(i);
            }
        }
        return result;
    }
	public static void main(String[] args) {
		SubStringsWithAllWords test = new SubStringsWithAllWords();
		String[] list = new String[2];
		list[0] = "foo";
		list[1] = "bar";
		System.out.println(test.findSubstring("barfoothefoobarman", list));

	}

}
