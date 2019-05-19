package Leetcode;

import java.util.Arrays;

public class cookieForChildren {
    public int findContentChildren(int[] g,int[] s){
        Arrays.sort(g); //分别对俩数组进行一个排序
        Arrays.sort(s);
        int child = 0;//定义孩子和饼干的下标；
        int cookie = 0;
        while ( child < g.length-1 && cookie < s.length-1){//当孩子和饼干下标都没有超出数组范围时，继续循环
            if ( g[child] <= s[cookie] ) {//当孩子需求小于等于饼干大小的时候，可以满足
                child++;//孩子数组下标后移一位；
            }
            cookie++;//无论是否满足孩子需求，饼干都要往后走
        }
        return child;//返回满足了几个孩子，因为如果不满足，child就不动，满足了才往后移动
    }
}
