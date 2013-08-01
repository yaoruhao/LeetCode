/**
 * 
 * @author yaoruhao
 * Referred to the solution of:http://discuss.leetcode.com/questions/287/best-time-to-buy-and-sell-stock-iii/446
 *
 */
public class BestTimeStockIII {

    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int result = 0;
    	if (prices.length == 0) {
			return 0;
		}
    	int []historyProfit = new int[prices.length];
    	int []futureProfit = new int[prices.length];
    	int valley = prices[0];
    	int peak = prices[prices.length - 1];
    	for (int i = 0; i < prices.length; i++) {
			valley = Math.min(valley, prices[i]);
			if (i > 0) {
				historyProfit[i] = Math.max(historyProfit[i-1], prices[i] - valley);
			}
		}
    	for (int i = prices.length - 1; i >= 0; i--) {
			peak = Math.max(peak, prices[i]);
			if (i < prices.length - 1) {
				futureProfit[i] = Math.max(futureProfit[i+1], peak - prices[i]);
			}
			result = Math.max(result, historyProfit[i] + futureProfit[i]);
		}
    	return result;        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
