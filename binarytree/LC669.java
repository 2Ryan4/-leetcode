package binarytree;

public class LC669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        //结束条件
        if (root == null) {
            return null;
        }

        //单层递归逻辑
        if (root.val < low) {
            //当前结点和左子树被剪去
            root = trimBST(root.right, low, high);
        } else if (root.val > high) {
            root = trimBST(root.left, low, high);
        } else {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        }

        return root;
    }
}
