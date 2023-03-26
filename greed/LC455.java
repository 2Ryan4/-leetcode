package greed;

import java.util.Arrays;

public class LC455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int childNum = 0;

        for (int i = 0; i < s.length; i++) {
            if (childNum < g.length && s[i] >= g[childNum]) {
                childNum++;
            }
        }

        return childNum;
    }
}
