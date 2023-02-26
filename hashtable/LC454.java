package hashtable;

import java.util.HashMap;

public class LC454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        //用一个哈希表存放num1和num2各元素的相加值
        //key代表两数之和，value代表两数之和出现的次数，即有多少种元素搭配方式
        int n = nums1.length;
        int result = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = nums1[i] + nums2[j];
                if (hm.containsKey(sum)) {
                    hm.put(sum, hm.get(sum) + 1);
                } else {
                    hm.put(sum, 1);
                }
            }
        }

        //遍历nums3和nums4求两数之和，找hm中是否有匹配值
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int other = 0 - (nums3[i] + nums4[j]);
                if (hm.containsKey(other)) {
                   result += hm.get(other);
                }
            }
        }
        return result;
    }
}
