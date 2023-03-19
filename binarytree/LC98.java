package binarytree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LC98 {
    TreeNode pre = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }

//        ArrayList<Integer> list = new ArrayList<>();
//        inOrder(root, list);
//        //因为二叉搜索树的中序遍历一定为单调递增的数组，直接判断数组是否为单调递增
//        for (int i = 1; i < list.size(); i++) {
//            if (list.get(i) <= list.get(i - 1)) {
//                return false;
//            }
//        }
//        return true;

        return solution2(root);
    }

    public void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }

    public boolean solution2(TreeNode cur) {
        if (cur == null) {
            return true;
        }
        //中序遍历
        boolean left = solution2(cur.left);
        //单层操作逻辑：比较当前结点的值和上一个遍历到的结点
        if (pre != null && cur.val <= pre.val) {
            return false;
        }
        //更新pre
        pre = cur;
        boolean right = solution2(cur.right);

        return left && right;
    }

}
