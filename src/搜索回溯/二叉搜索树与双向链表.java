package 搜索回溯;
/*
    36.输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
      要求不能创建任何新的节点，只能调整树中节点指针的指向
 */
public class 二叉搜索树与双向链表 {
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    void dfs(Node cur) {
        if(cur == null) return;
        dfs(cur.left);
        if(pre != null) pre.right = cur;
        else head = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}
