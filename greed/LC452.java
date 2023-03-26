package greed;

import java.util.Arrays;

public class LC452 {
    public int findMinArrowShots(int[][] points) {
        int result = 1;

        //对气球的左边界进行排序
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 1; i < points.length; i++) {
            //当前气球的左边界大于上一个气球的右边界，说明两个气球不重合
            if (points[i][0] > points[i -1][1]) {
                result++;
            } else {
                //如果重合，就要更新当前气球的右边界，以此判断下一个气球当前重合的气球是否同样重合
                points[i][1] = Math.min(points[i - 1][1], points[i][1]);
            }
        }

        return result;
    }
}
