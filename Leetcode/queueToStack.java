package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class queueToStack {
    Queue<Integer> queue;   //声明栈中队列对象
    Queue<Integer> tmpQueue;//声明临时队列对象
    public queueToStack(){
        queue=new LinkedList<>(); //stack中队列对象实例化
    }
    public void push(int x){//入栈
        tmpQueue=new LinkedList<>();//临时队列对象实例化
        tmpQueue.offer(x);//加入x到临时队列，也就是队头，相当于push进来的x
        while (!queue.isEmpty()){//当栈（中队列）不为空时，
            tmpQueue.offer(queue.poll());//poll取出栈（中队列）元素，也就是栈顶元素，即队头元素，加入到临时队列中
        }
        queue=tmpQueue;//把排好的临时队列给栈（中队列）
    }
    public int pop(){//出栈，也就是队头元素
        return queue.poll();
    }
    public int top(){
        return queue.peek();
    }
    public boolean empty(){
        return queue.isEmpty();
    }

}
