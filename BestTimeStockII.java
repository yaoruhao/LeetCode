/**
 * 
 * @author yaoruhao
 *
 */
public class BestTimeStockII {

    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int result = 0;
        int lowerIndex = 0;
        int higherIndex = 0;
        while (lowerIndex < prices.length && higherIndex < prices.length) {
			for (; lowerIndex < prices.length - 1; lowerIndex++) {
				if (prices[lowerIndex] < prices[lowerIndex + 1]) {
					break;
				}
			}
			for (higherIndex = lowerIndex + 1; higherIndex < prices.length - 1; higherIndex++) {
				if (prices[higherIndex] > prices[higherIndex + 1]) {
					break;
				}
			}
			if (higherIndex < prices.length) {
				result += Math.max(0, prices[higherIndex] - prices[lowerIndex]);
			}
			lowerIndex = higherIndex + 1;
		}
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
