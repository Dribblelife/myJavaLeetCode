package Leetcode;

public class isHuiwenList {
    public boolean isPalindrome(ListNode head){
        if (head==null || head.next == null){
            return true;
        }
        //先利用快慢指针找到中点
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next !=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        //slow 现在是中点
        slow=reserveLinkList(slow.next);
        while (slow!=null){
            if (head.val==slow.val){
                return true;
            }
            head=head.next;
            slow=slow.next;
        }
        return false;
    }
    public ListNode reserveLinkList(ListNode head){
        ListNode newHead = null;
        while (head!=null){
            ListNode tmp = head.next;
            head.next=newHead;
            newHead=head;
            head=tmp;
        }
        return newHead;
    }
}
