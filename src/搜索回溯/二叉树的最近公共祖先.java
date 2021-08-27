package 搜索回溯;
/*
    68-II.给定一个二叉树, 找到该树中两个指定节点的最近公共祖先
 */
public class 二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //找到叶结点也没有找到p和q
        if(root == null)
            return null;
        //先序遍历如果找到p或q就返回当前结点
        if(p == root || q == root)
            return root;
        //先序遍历左节点
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        //线序遍历右节点
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        //如果left和right不为空说明p,q位于当前节点两侧，返回当前结点
        if(left != null && right != null)
            return root;

        return left == null ? right : left;
    }
}
