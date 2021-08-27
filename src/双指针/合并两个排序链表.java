package 双指针;
/*
    25.输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的
 */
public class 合并两个排序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head,p;
        if(l1==null)    return l2;
        if(l2==null)    return l1;
        if(l1.val<=l2.val){
            head=p=l1;
            l1=l1.next;
        }
        else {
            head=p=l2;
            l2=l2.next;
        }
        while ((l1!=null)&&(l2!=null)){
            if(l1.val<= l2.val){
                p.next=l1;
                l1=l1.next;
            }
            else {
                p.next=l2;
                l2=l2.next;
            }
            p=p.next;
        }
        if(l1==null) p.next=l2;
        else p.next=l1;
        return head;
    }
}
