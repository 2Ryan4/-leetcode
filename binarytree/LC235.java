package binarytree;

public class LC235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //递归结束条件：遇到空节点
        if (root == null) {
            return null;
        }

        //结合二叉搜索树的特性，若当前结点的值在[p.val,q.val]，则该结点必然为其祖先
        //因为不需要一直遍历到目标节点，可以在当前结点就可以判断


        //向左遍历
        if (root.val > p.val && root.val > q.val) {
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            if (left != null) {
                return left;
            }
        }

        if (root.val < p.val && root.val < q.val) {
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (right != null) {
                return right;
            }
        }

        //若不符合以上条件，说明当前结点即为祖先结点，直接返回
        return root;
    }
}
