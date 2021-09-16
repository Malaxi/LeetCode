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
    107.层次遍历二叉树，从下到上，从左到右
 */
public class 二叉树层序遍历ll {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int curSize = queue.size();
            for(int i=0;i<=curSize;i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            /*
                与层次遍历|相同，list存储的都是每一层从左到右的元素——>满足从左到右的条件
                所以只要翻转res顺序(list头插法)—>即可满足从下到上的条件
             */
            res.add(0,list);
        }
        return res;
    }
}
