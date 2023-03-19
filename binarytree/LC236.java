package binarytree;

public class LC236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //递归结束条件：遇到空节点或目标结点，将目标结点返回
        if (root == null || root == p || root == q) {
            return root;
        }
        //因为要自下往上找祖先，所以要回溯，用后序遍历
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        //若左子树返回值不为空，即在左子树找到目标值，返回目标值
        if (left != null && right == null) {
            return left;
        }
        if (left == null && right != null) {
            return right;
        }else {//没有找到目标值返回空
            return null;
        }

    }


}
