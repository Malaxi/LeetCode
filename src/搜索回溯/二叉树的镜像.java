package 搜索回溯;

import java.util.Stack;

/*
    27.返回一个二叉树的镜像
 */
public class 二叉树的镜像 {
    //第一种方法：递归
    public TreeNode mirrorTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftRoot = mirrorTree1(root.right);
        TreeNode rightRoot = mirrorTree1(root.left);
        root.left = leftRoot;
        root.right = rightRoot;
        return root;
    }
    //第一种方法：利用辅助栈
    public TreeNode mirrorTree2(TreeNode root) {
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack<TreeNode>() {{ add(root); }};
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.left != null) stack.add(node.left);
            if(node.right != null) stack.add(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }
}
