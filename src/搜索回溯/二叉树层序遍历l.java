package 搜索回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhujianlin
 * @version 1.0
 * @date 2021/9/16 9:27
 */

/*
    102.层次遍历二叉树，从上到下，从左到右
 */
public class 二叉树层序遍历l {
    //BFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null)  return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()){
            //这里是重点,用来判断每层有多少个节点
            int curSize = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i=1;i<=curSize;i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            res.add(list);
        }
        return res;
    }
}
