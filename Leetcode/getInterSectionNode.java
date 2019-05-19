package Leetcode;

public class getInterSectionNode {
    public ListNode getInterSectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
            return null;
        }
        ListNode tail=headA;
        while (tail.next!=null){
            tail=tail.next;
        }
        tail.next=headA;    //成环
        ListNode fast=headB;
        ListNode slow=headB;
        while(fast!=null&&fast.next!=null){     //如果是不相交的链表，最后就返回null；循环体里是针对相交链表的
            slow=slow.next;             //快慢指针追赶
            fast=fast.next.next;
            if (slow==fast){        //追上了，即第一次相交，记录下来
                fast=headB;         //fast回到头开始,从头开始，慢指针记录第一次相交点
                while (fast!=slow){//重新定义速度一样的指针
                    fast=fast.next;
                    slow=slow.next;
                }
                                    //当再次相遇时，就是链表相交点
                tail.next=null; //释放环
                return slow;
            }
        }
        tail.next=null;                 //释放环链表为原结构
        return null;                    //说明B链表不与A相交，会找到null，退出while循环！

    }
}
