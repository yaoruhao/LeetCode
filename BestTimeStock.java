/**
 * 
 * @author yaoruhao
 *
 */
public class BestTimeStock {

    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if (prices.length == 0) {
			return 0;
		}
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
			maxProfit = Math.max(maxProfit, prices[i] - min);
			min = Math.min(min, prices[i]);
		}
        return maxProfit;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
