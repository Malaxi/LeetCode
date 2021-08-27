package 搜索回溯;
/*
    55.判断一个二叉树是不是平衡二叉树
 */
public class 平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        if(root==null)  return true;
        return Math.abs(depth(root.left)-depth(root.right))<=1&&isBalanced(root.left)&&isBalanced(root.right);
    }
    public int depth(TreeNode root){
        if(root==null)  return 0;
        return Math.max(depth(root.left),depth(root.right))+1;
    }

}
