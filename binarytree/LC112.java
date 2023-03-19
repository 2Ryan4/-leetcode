package binarytree;

import java.util.List;

public class LC112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return solution(root, targetSum - root.val);
    }

    public boolean solution(TreeNode node, int sum) {
        if (node.left == null && node.right == null && sum == 0) {
            return true;
        } else if (node.left == null && node.right == null && sum != 0) {
            return false;
        }

        if (node.left != null) {
            sum -= node.left.val;
            if (solution(node.left, sum)) {
                return true;
            }
            //回溯
            sum += node.left.val;
        }

        if (node.right != null) {
            sum -= node.right.val;
            if (solution(node.right, sum)) {
                return true;
            }
            //回溯
            sum += node.right.val;
        }

        //遍历完都没有合适的路径
        return false;
    }
}
