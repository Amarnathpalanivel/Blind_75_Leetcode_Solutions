class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int target = coin; target <= amount; target++) {
                dp[target] = dp[target] + dp[target - coin];
            }
        }
        return dp[amount];
    }
}