package greed;

public class LC122 {
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            int benefit = Math.max(prices[i] - prices[i - 1], 0);
            result += benefit;
        }
        return result;
    }
}
