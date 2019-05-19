package Leetcode;

import java.util.PriorityQueue;

public class topK {
    public int findKthLargest(int[] nums, int k){
        PriorityQueue<Integer> Q = new PriorityQueue<>();//声明并初始化一个最小堆，用优先队列
        for (int i=0;i<nums.length;i++){//遍历这个数组
            if (Q.size()<k){//如果堆中的元素个数小于k，直接offer进入堆
                Q.offer(nums[i]);
            }else if (nums[i]>Q.peek()){ // 比较数组元素和最小堆顶元素，如果比堆顶元素大，则
                Q.poll();               //堆顶元素出堆
                Q.offer(nums[i]);       // 加入到堆里，堆自己调整
            }
        }
        return Q.peek();
    }
}
