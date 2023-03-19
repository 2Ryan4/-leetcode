package binarytree;

public class LC150 {
    //返回值为结点，参数为结点和删除指定值
    public TreeNode deleteNode(TreeNode root, int key) {
        //递归结束条件：当前结点为空节点或者为删除结点
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            //删除结点为叶子结点直接删除
            if (root.left == null && root.right == null) {
                return null;
            }
            //删除结点只有一颗子树
            if (root.left != null && root.right ==null) {
                return root.left;
            }
            if (root.left == null && root.right !=null) {
                return root.right;
            }
            //删除结点有两颗子树
            if (root.left != null && root.right != null) {
                TreeNode node = root.left;
                //让右子树的结点代替被删除结点
                root = root.right;
                TreeNode temp = root;
                while (temp.left != null) {
                    temp = temp.left;
                }
                //让被删除结点的左子树成为新结点的最左节点
                temp.left = node;
            }
        }

        //单层递归逻辑
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }

        return root;
    }
}
