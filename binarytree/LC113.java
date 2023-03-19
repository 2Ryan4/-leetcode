package binarytree;

import java.util.ArrayList;
import java.util.List;

public class LC113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        path.add(root.val);
        solution(root, targetSum - root.val, path, result);
        return result;
    }

    public void solution(TreeNode node, int sum, List<Integer> path, List<List<Integer>> result) {
        if (node.left == null && node.right == null && sum != 0) {
            return;
        } else if (node.left == null && node.right == null && sum == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (node.left != null) {
            sum -= node.left.val;
            path.add(node.left.val);
            solution(node.left, sum, path, result);
            path.remove(path.size() - 1);
            sum += node.left.val;
        }

        if (node.right != null) {
            sum -= node.right.val;
            path.add(node.right.val);
            solution(node.right, sum, path, result);
            path.remove(path.size() - 1);
            sum += node.right.val;
        }
    }

}
