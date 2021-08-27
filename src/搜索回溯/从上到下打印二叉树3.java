package 搜索回溯;

import java.util.*;

/*
    32.请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
       第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推
    本题难点：在于向链表中添加结点值的顺序
*/
public class 从上到下打印二叉树3 {
    Deque deque=new ArrayDeque();

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res=new ArrayList<>();
        //root不为空
        if(root!=null)
            queue.add(root);
        //当队列不为空
        while(!queue.isEmpty()){
            LinkedList<Integer> tmp = new LinkedList<>();
            /*
                为什么for(int i = 0; i < queue.size(); i++)不行？
                因为：每进行一次for循环queue.size()的值都在变化(结束条件在不停的变化)，我们想要的queue.size()是
                     还一个固定值(表示某一行的元素个数)，或者改变为以下形式：
                     int temp=queue.size();
                     for(int i = 0; i < temp; i++)
             */
            for(int i = queue.size(); i > 0; i--){
                TreeNode node = queue.poll();
                //如果当前行是偶数行:因为res中已经有奇数行数据所以当前行的偶数行
                if(res.size()%2!=0)  tmp.addFirst(node.val);
                //如果当前行是奇数行:因为res中已经有偶数行数据所以当前行的奇数行
                if(res.size()%2==0)  tmp.addLast(node.val);

                if(node.left!=null)  queue.add(node.left);

                if(node.right!=null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}

/*
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if(res.size() % 2 == 0) tmp.addLast(node.val); // 偶数层 -> 队列头部
                else tmp.addFirst(node.val); // 奇数层 -> 队列尾部
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}
*/