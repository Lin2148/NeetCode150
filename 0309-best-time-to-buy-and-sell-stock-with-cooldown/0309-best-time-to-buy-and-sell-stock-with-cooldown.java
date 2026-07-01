class Solution {
    // key是天數+持有/空手
    private Map<String, Integer> dp = new HashMap<>();

    public int maxProfit(int[] prices) {
         return dfs(0, false, prices);
    }

    private int dfs(int days, boolean hold, int[] prices){
        if (days >= prices.length){
            return 0;
        }
        String key = days + "_" + hold;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        if (hold){
            int sell = prices[days] + dfs(days+2, false, prices);
            int holding = dfs(days+1, true, prices);
            int max = Math.max(sell, holding); 
            dp.put(key, max);
            return max;
        } else {
            int buy = dfs(days+1, true, prices) - prices[days];
            int rest = dfs(days+1, false, prices);
            int max = Math.max(buy, rest); 
            dp.put(key, max);
            return max;
        }

    }
}