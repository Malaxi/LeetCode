package 搜索回溯;
/*
    68-I.给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先
 */
public class 二叉搜索树的最近公共祖先 {
    //第一种方法：递归
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        //终止条件：不需要，因为官方给了均存在与树中的条件
        //          即老子现在肯定是这两个乖孙子的公共祖先
        //递推操作：
        //第一种情况：
        if(root.val>p.val&&root.val>q.val){//看看是不是都是左儿子的后代
            return lowestCommonAncestor1(root.left,p,q);//是的话就丢给左儿子去认后代（继续递归）
        }
        //第二种情况：
        if(root.val<p.val&&root.val<q.val){//不是左儿子的后代，看看是不是都是右儿子的后代
            return lowestCommonAncestor1(root.right,p,q);//是的话就丢给右儿子去认后代（继续递归）
        }
        //第三种情况：
        //左儿子和右儿子都说我只认识一个，唉呀妈呀，那就是老子是你们最近的祖先，因为老子本来就是你们的公共的祖先
        //现在都只认一个，那就是老子是最近的。
        //其实第三种才是题目需要找到的解，所以返回，拜托我的祖先们也传一下（递归回溯返回结果），我才是他们最近的公共曾爷爷
        return root;
    }
    //第二种方法：迭代
    class Solution {
        public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
            while(root != null) {
                if(root.val < p.val && root.val < q.val) // p,q 都在 root 的右子树中
                    root = root.right; // 遍历至右子节点
                else if(root.val > p.val && root.val > q.val) // p,q 都在 root 的左子树中
                    root = root.left; // 遍历至左子节点
                else break;
            }
            return root;
        }
    }
}
