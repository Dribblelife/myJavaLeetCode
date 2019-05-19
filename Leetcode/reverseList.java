package Leetcode;



public class reverseList {
    public ListNode reverseList(ListNode head){
        if (head==null || head.next==null){
            return head;
        }
        ListNode p =head;
        ListNode newList = null;
        while(p!=null){
            ListNode tmp = p.next;
            p.next=newList;
            newList=p;
            p=tmp;
        }
        return newList;
       /* ListNode newHead = reverseList(head.next);  //递归
        head.next.next=head;
        head.next=null;
        return newHead;*/
    }
}
