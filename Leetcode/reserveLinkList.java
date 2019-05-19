package Leetcode;

public class reserveLinkList {
    public ListNode reserveList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead =null;
        while (head.next!=null){
            ListNode tmp = head.next;//备份head.next
            head.next=newHead;// 修改head.next 指向当前newhead的第一个节点
            newHead=head;//移动newhead到头
            head=tmp;//移动head到下一个
        }
        return newHead;
    }
}
