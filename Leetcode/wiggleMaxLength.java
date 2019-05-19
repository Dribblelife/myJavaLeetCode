package Leetcode;

public class wiggleMaxLength {
    public int wiggleMaxLength(int[] nums){
        if (nums.length<2) return nums.length;//如果序列长度小于2的话，必然是摆动序列，直接返回其长度即可
        final int BEGIN = 0;//定义状态机，三个，只要发生变化，就记录
        final int UP = 1;
        final int DOWN = 2;
        int STATE=BEGIN;
        int maxLength=1;//经过上面判断，直接从1开始，因为至少为1
        for (int i=1;i<nums.length;i++){//从数组下标1开始进行遍历，和判断
            switch (STATE){
                case BEGIN:
                    if (nums[i-1]<nums[i]){//如果后一个大于前一个，状态变化为UP，并且最大序列++
                        STATE=UP;
                        maxLength++;
                    }else if (nums[i-1]>nums[i]){
                        STATE=DOWN;
                        maxLength++;
                    }
                    break;//都不是的话，即相等，那么结束本次，后移一位继续判断
                case UP:
                    if (nums[i-1]>nums[i]){//在UP状态时，如果后者小于前者，状态发生变化，最大序列+1
                        STATE=DOWN;
                        maxLength++;
                    }
                    break;
                case DOWN:
                    if (nums[i-1]<nums[i]){
                        STATE=UP;
                        maxLength++;
                    }
                    break;
            }
        }
        return maxLength;
    }
}
