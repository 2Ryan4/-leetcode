package binarytree;

public class LC110 {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    public int getHeight(TreeNode node) {
        //递归的终止条件
        if (node == null) {
            return 0;
        }
        //获取左子树高度
        int leftHeight = getHeight(node.left);
        if (leftHeight == -1) {
            return -1;
        }
        //获取右子树高度
        int rightHeight = getHeight(node.right);
        if (rightHeight == -1) {
            return -1;
        }
        //当前操作，判断
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
