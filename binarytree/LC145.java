package binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class LC145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        suffixOrder(root, list);
        return list;
    }

    public void suffixOrder(TreeNode node, List list) {
        if (node == null) {
            return;
        }
        suffixOrder(node.left, list);
        suffixOrder(node.right, list);
        list.add(node.val);
    }

    public List<Integer> solution(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode node = null;
        while (!stack.isEmpty()) {
            node= stack.pop();
            list.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(list);
        return list;
    }
}
