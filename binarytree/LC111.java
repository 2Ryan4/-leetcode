package binarytree;

public class LC111 {
    public int minDepth(TreeNode root) {
        return getHeight(root);
    }

    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        if (node.left == null && node.right != null) {
            return rightHeight + 1;
        }
        if (node.left != null && node.right == null) {
            return leftHeight + 1;
        }

        return Math.min(leftHeight, rightHeight) + 1;
    }
}
