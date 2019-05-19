package Leetcode;

import java.util.Stack;

public class removeK_digits {
    public String removeKdigits(String num,int k){
        Stack<Integer> stack= new Stack<>();//栈来存最小的数字
        StringBuilder result = new StringBuilder();//初始化字符串，存最后的结果
        for (int i=0;i<num.length();i++){//从数组高位开始遍历
            int number = num.charAt(i)-'0';//将字符串转换为int类型
            while (stack.size()!=0 && stack.peek()>number && k>0){//栈不为空时，且栈顶元素大于当前number，且k还没用完时，就是仍然可以删number时继续
                stack.pop();//说明已经可以去掉一个数字了，之前的栈顶数字出栈
                k--;//k就少了一个
            }
            if (number!=0||stack.size()!=0){//push是保留数字的情况，1，数字不为0 或2，栈不为空（就是无前导0）
                stack.push(number);//number 压入栈
            }
        }
        while (stack.size()!=0 && k>0){//遍历完数字后，k还大于0，而且栈不为空
            stack.pop();
            k--;//删除数字，更新k
        }
        for (int i=0;i<stack.size();i++){
            result.append(stack.get(i));
        }
        if (result.toString().equals("")){
            return "0";
        }
        return result.toString();
    }
}
