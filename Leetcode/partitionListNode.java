package Leetcode;


public class partitionListNode {
    public ListNode partition(ListNode head,int x){
        ListNode dummyHead1=new ListNode(0);//定义两个虚拟头结点为null，指向现在的头
        ListNode dummyHead2=new ListNode(0);
        ListNode node1=dummyHead1;      //声明两个节点分别存小于指定值和大于指定值
        ListNode node2=dummyHead2;
        while (head!=null){
            if (head.val<x){
                node1.next=head;    //node1现在是虚拟头结点，他的下一个指向head，这时，dummyhead1存贮这个头
                node1=node1.next;   //node1向后移动，现在就是实际存的head中的值
            }else {
                node2.next=head;
                node2=node2.next;
            }
            head=head.next;     //依次遍历链表
        }
        node2.next=null;    //将其尾变成null
        node1.next=dummyHead2.next; //node1现在就是比x小的新链表的尾，连接尾和头，头是原本虚拟头指针dummy存贮的头的位置的next；
        return dummyHead1.next;//返回虚拟头结点的next，也就是小链表的一开始的头
    }

}
