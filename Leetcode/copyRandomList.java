package Leetcode;

public class copyRandomList {
    public Node copyRandomList(Node head){
        if (head==null){
            return null;
        }
        Node cur = head;
        //复制
        while (cur!=null){
            Node newNode = new Node(cur.val,null,null);
            newNode.next=cur.next;
            cur.next=newNode;
            cur=cur.next.next;
        }
        cur=head;//回到头部
        //为其副本设置random值
        while (cur!=null){
            Node newNode = cur.next;
            if (cur.random==null){
                newNode.random=null;
            }else {
                newNode.random=cur.random.next;
            }
            cur=cur.next.next;
        }
        cur=head;//再次回到头部
        Node result = head.next;//结果起始节点
        //拆分链表
        while (cur!=null){
            Node newNode = cur.next;
            cur.next=newNode.next;
            while (newNode.next!=null){
                newNode.next=newNode.next.next;
            }
            cur=cur.next;
        }
        return result;
    }
}
