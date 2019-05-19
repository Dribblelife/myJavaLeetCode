package Leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class medianFinder {
    private PriorityQueue<Integer> minHeap= new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap= new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });
    public medianFinder(){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
    }
    public void addNum(int num){
        if (maxHeap.isEmpty()){//如果最大堆为空，就往里面填元素
            maxHeap.offer(num);
            return;
        }
        if (maxHeap.size()==minHeap.size()){//如果两堆大小相等，这是单纯比较元素和堆顶元素，并添加
            if (num<maxHeap.peek()){
                maxHeap.offer(num);
            }else {
                minHeap.offer(num);
            }
        }
        else if (maxHeap.size()<minHeap.size()){//最大堆小，那么就要分情况讨论，
            if (num<minHeap.peek()) {//如果元素小于最小堆堆顶，直接添加到最大堆就行
                maxHeap.offer(num);
            }else {//如果元素大于最小堆顶，那么就需要，把堆顶元素给最大堆，剔除原来的最小堆堆顶，加入新的元素
                maxHeap.offer(minHeap.peek());
                minHeap.poll();
                minHeap.offer(num);
            }
        }
        else if (maxHeap.size()>minHeap.size()){//最小堆小，也是分情况讨论
            if (num>maxHeap.peek()){
                minHeap.offer(num);
            }else {
                minHeap.offer(maxHeap.peek());
                maxHeap.poll();
                maxHeap.offer(num);
            }
        }
    }
    public double findMedian(){
        if (maxHeap.size()==minHeap.size()){
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }else if (maxHeap.size()<minHeap.size()){
            return minHeap.peek();
        }else {
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        medianFinder  test= new medianFinder();
        test.addNum(1);
        test.findMedian();
        test.addNum(2);
        System.out.println(test.findMedian());
        test.addNum(4);
        test.findMedian();
    }
}
