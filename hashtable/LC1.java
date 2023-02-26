package hashtable;

import java.util.HashMap;

public class LC1 {
    public int[] twoSum(int[] nums, int target) {
        //使用哈希表来存放数组元素
        HashMap<Integer, Integer> hm = new HashMap<>();//第一个整型为数值，第二个整型为下标
        int[] res = new int[2];//存放匹配成功元素下标的数组
        for (int i = 0; i < nums.length; i++) {
            //遍历数组，如果当前元素与hm中元素匹配不成功，放入hm；匹配成功则将下标加入res到并返回
            int other = target - nums[i];//要匹配的数值
            if (hm.containsKey(other)) {
                int otherIndex = hm.get(other);
                res[0] = i;
                res[1] = otherIndex;
                return res;
            } else {
                hm.put(nums[i], i);
            }
        }
        return res;
    }
}
