package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        infixOrder(root, list);
        return list;
    }

    public void infixOrder(TreeNode node, List list) {
        if (node == null) {
            return;
        }
        infixOrder(node.left, list);
        list.add(node.val);
        infixOrder(node.right, list);
    }

    public List<Integer> solution(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;
    }
}
