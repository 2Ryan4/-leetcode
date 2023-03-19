package binarytree;

public class LC701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        insert(root, val);
        return root;
    }

    public void insert(TreeNode node, int val) {

        //题目条件规定结点的值都唯一，所以只有大于小于关系
        if (val < node.val) {
            if (node.left != null) {
                insert(node.left, val);
            } else {
                node.left = new TreeNode(val);
            }
        } else {
            if (node.right != null) {
                insert(node.right, val);
            } else {
                node.right = new TreeNode(val);
            }
        }
    }
}
