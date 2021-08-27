package 链表问题;

import java.util.HashMap;

/*
    35.复制复杂链表：本题的难点在于每个结点包含一个Random随机指针
*/
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution {
    //方法一：哈希表
    public Node copyRandomList1(Node head) {
        if(head==null) return null;
        Node cur=head;
        HashMap<Node, Node> hashmap = new HashMap<>();
        //1.首先构建新链表，但还并没有指明next和random指针
        while(cur!=null){
            hashmap.put(cur,new Node(cur.val));
            cur=cur.next;
        }
        cur=head;
        //2.然后开始构建新链表的next和random指针
        while(cur!=null){
            hashmap.get(cur).next=hashmap.get(cur.next);
            hashmap.get(cur).random=hashmap.get(cur.random);
            cur=cur.next;
        }
        return hashmap.get(head);
    }
    //方法二：拼接+拆分
    public Node copyRandomList2(Node head) {
        Node res,pre;
        Node cur=head;
        if(head==null) return null;
        //1.构建拼接链表
        while(cur!=null){
            res = new Node(cur.val);
            res.next=cur.next;
            cur.next=res;
            cur=cur.next.next;
        }
        //2.构建新链表的random指针
        cur=head;
        while (cur!=null){
            if(cur.random != null)
                cur.next.random=cur.random.next;
            cur=cur.next.next;
        }
        //3.拆分新链表
        pre=head;
        cur=pre.next;
        res=pre.next;
        while (cur.next!=null){//当前cur结点不是尾结点
            pre.next=pre.next.next;
            cur.next=cur.next.next;
            pre=pre.next;
            cur=cur.next;
        }
        pre.next=null;//处理原链表的尾结点
        return res;
    }
}
