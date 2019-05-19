package Leetcode;

public class sortList {
    public ListNode sortList(ListNode head){
        //特殊情况
        if (head==null || head.next==null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode l2 =sortList(slow.next);
        slow.next=null;
        ListNode l1 =sortList(head);
        return mergeTwoLists(l1,l2);
    }
    public ListNode mergeTwoLists(ListNode head1,ListNode head2){
        if (head1==null) return head2;
        if (head2==null) return head1;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (head1!=null&&head2!=null){
            if (head1.val<head2.val){
                cur.next=head1;
                head1=head1.next;
            }else {
                cur.next=head2;
                head2=head2.next;
            }
        }
        if (head1!=null) cur.next=head1;
        if (head2!=null) cur.next=head2;
        ListNode res = dummy.next;
        return res;
    }
}
