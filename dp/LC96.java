package dp;

public class LC96 {
    public int numTrees(int n) {
        //dp[i] 表示i个节点构成的二叉搜索树的数量
        int[] dp = new int[n + 1];

        //初始化dp
        //空数也是一种二叉搜索树
        dp[0] = 1;

        //递推
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                //j-1表示是以j为头结点的左子树节点的数量，i-j表示是以i-j为头结点的右子树节点的数量
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }
}
