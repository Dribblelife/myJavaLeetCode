/*
package Leetcode;

public class mergeKList {
    public ListNode mergeKList(ListNode[] lists){
        if(lists.length==0){
            return null;
        }
        if (lists.length==1){
            return lists[0];
        }
        if (lists.length==2){
            return  //mergeTwoLists(lists[0],lists[1]);
        }
        int mid=lists.length/2;
        ListNode[] l1=new ListNode[mid];//数组容量
        for (int i=0;i<mid;i++){
            l1[i]=lists[1];
        }
        ListNode[] l2=new ListNode[lists.length-mid];
        for (int i=mid,j=0;i<lists.length;i++,j++){
            l2[j]=lists[i];
        }
        return mergeTwoLists(mergeKList(l1),mergeKList(l2));

    }
}
*/
