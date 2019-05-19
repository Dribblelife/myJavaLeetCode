package Leetcode;

public class detectCircle {
    public ListNode detectCircle(ListNode head){
        if (head==null || head.next==null || head.next.next==null){
            return null;        //无法构成环
        }
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null&&fast.next!=null){//有环就不会指向null，无环就会跳出循环
            fast=fast.next.next;
            slow=slow.next;
            if (slow==fast){        //追赶上记录此交点，fast回到头
                fast=head;
                while (fast!=slow){ //速度一样的指针，再次相交时就是环的初始点
                    fast=fast.next;
                    slow=slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
