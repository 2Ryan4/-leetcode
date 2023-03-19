package binarytree;

public class LC700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return root;
        }

        //单层逻辑：把val和结点的值比较，小去遍历左子树，大去遍历右子树，相等就返回
        //前序遍历
        if (val == root.val) {
            return root;
        } else if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }

    }
}
