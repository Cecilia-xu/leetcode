// Solution: DP
// Time compelxity: O(2k + 1) + O(n * (2k + 1)) + O(k + 1) = O((n + 1) * (2k + 1) + k + 1) -> O(nk)
// Space complexity: O(n * (2k + 1)) -> O(nk)
class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        // Note: when k > len / 2, no limitation on transaction
        if (k > len / 2) {
            return noLimitMaxProfit(prices);
        }
        int states = 2 * k + 1;
        int[][] profit = new int[len + 1][states + 1];
        // initialization
        profit[0][1] = 0;
        for (int j = 2; j <= states; j++) {
            profit[0][j] = Integer.MIN_VALUE;
        }
        for (int i = 1; i <= len; i++) {
            // state: 1, 3, 5, ... 2k + 1
            for (int j = 1; j <= states; j += 2) {
                profit[i][j] = profit[i - 1][j];
                if (i > 1 && j > 1 && profit[i - 1][j - 1] != Integer.MIN_VALUE) {
                    profit[i][j] = Math.max(profit[i][j], profit[i - 1][j - 1] + prices[i - 1] - prices[i - 2]);
                }
            }
            // state: 2, 4, ... 2k
            for (int j = 2; j <= states; j += 2) {
                profit[i][j] = profit[i - 1][j - 1];
                if (i > 1 && profit[i - 1][j] != Integer.MIN_VALUE) {
                    profit[i][j] = Math.max(profit[i][j], profit[i - 1][j] + prices[i - 1] - prices[i - 2]);
                }
            }
        }
        // find maximum profit
        int res = Integer.MIN_VALUE;
        for (int j = 1; j <= states; j += 2) {
            res = Math.max(res, profit[len][j]);
        }    
        return res;
    }
    
    public int noLimitMaxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}

// Solution: DP (optimization in space)
// Time complexity: O(nk)
// Space complexity: O(k)
class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        if (k > len / 2) {
            return noLimitMaxProfit(prices);
        }
        int states = 2 * k + 1;
        int[][] profit = new int[2][states + 1];
        int cur = 0, pre = 1;
        // initialization
        profit[cur][1] = 0;
        for (int j = 2; j <= states; j++) {
            profit[cur][j] = Integer.MIN_VALUE;
        }
        for (int i = 1; i <= len; i++) {
            // change pointers
            int temp = cur;
            cur = pre;
            pre = temp;
            // state: 1, 3, 5, ... 2k + 1
            for (int j = 1; j <= states; j += 2) {
                profit[cur][j] = profit[pre][j];
                if (j > 1 && profit[pre][j - 1] != Integer.MIN_VALUE) {
                    profit[cur][j] = Math.max(profit[cur][j], profit[pre][j - 1] + prices[i - 1] - prices[i - 2]);
                }
            }
            // state: 2, 4, ... 2k
            for (int j = 2; j <= states; j += 2) {
                profit[cur][j] = profit[pre][j - 1];
                if (profit[pre][j] != Integer.MIN_VALUE) {
                    profit[cur][j] = Math.max(profit[cur][j], profit[pre][j] + prices[i - 1] - prices[i - 2]);
                }
            }
        }
        // find maximum profit
        int res = Integer.MIN_VALUE;
        for (int j = 1; j <= states; j += 2) {
            res = Math.max(res, profit[cur][j]);
        }    
        return res;
    }
    
    public int noLimitMaxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
