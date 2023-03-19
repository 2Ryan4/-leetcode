package binarytree;

import java.util.ArrayList;
import java.util.List;

public class LC530 {
    int result = Integer.MAX_VALUE;
    TreeNode pre = null;
    public int getMinimumDifference(TreeNode root) {
//        ArrayList<Integer> list = new ArrayList<>();
//        inOrder(root, list);
//        int result = Integer.MAX_VALUE;
//        for (int i = 1; i < list.size(); i++) {
//            if (list.get(i) - list.get(i - 1) < result) {
//                result = list.get(i) - list.get(i - 1);
//            }
//        }
//        return result;
        solution(root);
        return result;

    }

    public void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);

    }

    public void solution(TreeNode node) {
        if (node == null) {
            return;
        }
        solution(node.left);
        if (pre != null) {
            result = Math.min(result, node.val - pre.val);
        }
        pre = node;
        solution(node.right);

    }
}
