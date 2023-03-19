package binarytree;

import java.util.LinkedList;

public class LC104 {
    public int maxDepth(TreeNode root) {
        int depth = 0;
        LinkedList<TreeNode> list = new LinkedList<>();
        if (root == null) {
            return depth;
        }
        list.offer(root);
        while (!list.isEmpty()) {
            int size = list.size();
            TreeNode cur = null;
            while (size-- > 0) {
                cur = list.poll();
                if (cur.left != null) {
                    list.offer(cur.left);
                }
                if (cur.right != null) {
                    list.offer(cur.right);
                }
            }
            depth++;
        }
        return depth;

    }

    public int maxHeight(TreeNode root) {
        return solution(root);
    }

    public int solution(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = solution(node.left);
        int rightHeight = solution(node.right);

        int height = Math.max(leftHeight, rightHeight) + 1;

        return height;
    }


}
