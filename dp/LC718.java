package dp;

public class LC718 {
    public int findLength(int[] nums1, int[] nums2) {
        //定义dp数组，dp[i][j]表示结尾下标i-1的nums1和结尾下标j-1的nums2的最长重复子数组的长度
        //因为两个数组要从第一个元素开始比较，若在两个数组的第一个元素进行初始化，则需要单独处理
        //为了统一操作，在两个数组的前面添加一个用来初始化的元素
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        int result = 0;

        //初始化dp数组
        //dp[i][0]和dp[0][j]都没有意义，只是为了统一操作而创建出来的
        dp[0][0] = 0;

        //确认递推公式和遍历顺序
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    //子数组表示一定是连续的
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                result = Math.max(result, dp[i][j]);
            }
        }

        return result;
    }
}
