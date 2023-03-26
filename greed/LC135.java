package greed;

import java.util.Arrays;

public class LC135 {
    public int candy(int[] ratings) {
        //每个孩子至少有一颗糖果
        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1);

        //第一种情况：评分高的右相邻的孩子得到的糖果更多
        //从前向后遍历
        for (int i = 1; i < candy.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }

        //第二种情况：评分高的左相邻的孩子得到的糖果更多
        //从后往前遍历
        //最后结果取最大，这样满足评分高的孩子既比左边的多也比右边的多
        for (int i = candy.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }
        }

        int result = 0;
        for (int i : candy) {
            result += i;
        }

        return result;
    }
}
