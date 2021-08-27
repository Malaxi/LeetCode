package 搜索回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/*
    32.从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印
*/
public class 从上到下打印二叉树1 {
    public int[] levelOrder(TreeNode root) {
        if(root==null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> array = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            array.add(node.val);
            if(node.left!=null) queue.add(node.left);
            if(node.right!=null) queue.add(node.right);
        }
        int[] res = new int[array.size()];
        for(int i=0;i<array.size();i++){
            res[i]=array.get(i);
        }
        return res;
    }
}
