package binarytree;

import java.util.ArrayList;
import java.util.List;

public class LC501 {
    private int count = 0;//单词出现次数
    private int maxCount = 0;//出现最多次数
    private TreeNode pre = null;//当前结点的上一个结点
    private List<Integer> list = new ArrayList<>();//存放出现频率最高的元素
    public int[] findMode(TreeNode root) {
        inOrder(root);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public void inOrder(TreeNode cur) {
        if (cur == null) {
            return;
        }
        //根据二叉搜索树的特性，当中序遍历时，相同数值的数紧挨着
        inOrder(cur.left);
        //第一次遍历到叶子结点和前驱结点的值不等于当前结点的值
        if (pre == null || pre.val != cur.val) {
            count = 1;
        } else {//数值相同，次数加一
            count++;
        }
        //通过双指针实时更新
        if (count == maxCount) {
            list.add(cur.val);
        } else if (count > maxCount) {
            list.clear();
            list.add(cur.val);
            maxCount = count;
        }
        pre = cur;
        inOrder(cur.right);


    }
}
