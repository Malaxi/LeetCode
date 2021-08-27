package 搜索回溯;

import java.util.LinkedList;
import java.util.Queue;

/*
    55.二叉树的深度
 */
public class 二叉树的深度 {
    public int dfs(TreeNode root) {
        if(root==null)  return 0;
        //返回左右子树高度的最大值+1
        return Math.max(dfs(root.left),dfs(root.right))+1;
    }
    public int bfs(TreeNode root){
        int res=0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            res=res+1;
            int n=queue.size();
            for(int i=0;i<n;i++){
                TreeNode tmp=queue.poll();
                if(tmp.left!=null)  queue.add(tmp.left);
                if(tmp.right!=null) queue.add(tmp.right);
            }
        }
        return res;
    }
}
