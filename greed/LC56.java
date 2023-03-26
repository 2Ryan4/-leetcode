package greed;

import java.util.ArrayList;
import java.util.Arrays;

public class LC56 {
    public int[][] merge(int[][] intervals) {
        //对所有区间按照左边界进行排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> results = new ArrayList<>();
        //左边界
        int start = intervals[0][0];
        //右边界
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                //更新右边界
                end = Math.max(end, intervals[i][1]);
            } else {
                results.add(new int[]{start, end});
                //更新左右边界
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        results.add(new int[]{start, end});

        return results.toArray(new int[results.size()][]);
    }


}
