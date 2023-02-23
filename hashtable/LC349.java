package hashtable;

import java.util.HashSet;

public class LC349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        //因为交集每一个元素都是唯一的，所以要去重，选择hashset
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();

        for (int i :nums1) {
            set.add(i);
        }
        for (int i :nums2) {
            if (set.contains(i)) {
                result.add(i);
            }
        }
        int[] arr = new int[result.size()];
        int index = 0;
        for (int i :result) {
            arr[index++] = i;
        }
        return arr;


    }

    public int[] intersection1(int[] nums1, int[] nums2) {
//        1 <= nums1.length, nums2.length <= 1000
//        0 <= nums1[i], nums2[i] <= 1000
        //题目给定数子范围大小，可以确定记录数字出现的数组大小
        int[] show = new int[1001];
        HashSet<Integer> result = new HashSet<>();
        for (int i :nums1) {
            show[i] = 1;
        }
        for (int i :nums2) {
            if (show[i] == 1) {
                result.add(i);
            }
        }
        int[] arr = new int[result.size()];
        int index = 0;
        for (int i :result) {
            arr[index++] = i;
        }
        return arr;



    }
}
