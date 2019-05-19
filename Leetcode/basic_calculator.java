package Leetcode;

import java.util.Stack;

public class basic_calculator {
    public int calculate(String s){
        final int STATE_BEGIN=0;
        final int NUMBER_STATE=1;
        final int OPERATION_STATE=2;
        Stack<Integer> numStack=new Stack<>();
        Stack<Character> operationStack=new Stack<>();
        int num=0;
        int STATE=STATE_BEGIN;
        int compute_flag=0;
        for (int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if (s.charAt(i) == ' '){
                continue;
            }
            switch (STATE){
                case STATE_BEGIN:
                    if (ch >= '0' && ch <= '9'){
                        STATE=NUMBER_STATE;
                    }else {
                        STATE=OPERATION_STATE;
                    }
                    i--;
                    break;
                case NUMBER_STATE:
                    if (ch >= '0' && ch <= '9'){
                        num=num*10+ch-'0';
                    }else {
                        numStack.push(num);
                        if (compute_flag==1){
                            compute(numStack,operationStack);
                        }
                        num = 0;
                        i--;
                        STATE=OPERATION_STATE;
                    }
                    break;
                case OPERATION_STATE:
                    if (ch == '+' || ch == '-'){
                        operationStack.push(ch);
                        compute_flag=1;
                    }else if (ch == '('){
                        STATE=NUMBER_STATE;
                        compute_flag=0;
                    }else if (ch >='0' && ch <= '9'){
                        STATE=NUMBER_STATE;
                        i--;
                    }else if (ch == ')'){
                        compute(numStack,operationStack);
                    }
                    break;
            }
        }
        if (num!=0){
            numStack.push(num);
            compute(numStack,operationStack);
        }
        if (num == 0 && numStack.empty()){
            return 0;
        }
        return numStack.peek();
    }
    public void compute(Stack<Integer> numStack, Stack<Character> operationStack){//传入两个栈
        if (numStack.size()<2) return;//如果数字栈小于2 只有一个数字，直接返回
        int num2 = numStack.peek();//取栈顶数字
        numStack.pop();//栈顶数字出栈
        int num1 = numStack.peek();
        numStack.pop();
        if (operationStack.peek()=='+'){
            numStack.push(num1+num2);
        }else if (operationStack.peek()=='-'){
            numStack.push(num1-num2);
        }
        operationStack.pop();
    }
}
