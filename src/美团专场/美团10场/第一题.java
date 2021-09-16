package 美团专场.美团10场;

import java.util.Arrays;
import java.util.Scanner;
//通过
public class 第一题 {
    public static void main(String[] args) {
        //输入
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int x=scanner.nextInt();
        int y=scanner.nextInt();
        int[] scores = new int[n];
        for(int i=0;i<n;i++){
            scores[i]=scanner.nextInt();
        }
        //处理:过线人数越多，分数线越多
        Arrays.sort(scores);
        //getOut为最少的淘汰人数
        int success=y;
        int getOut=n-y;
        if(getOut>=x&&getOut<=y) System.out.println(scores[getOut - 1]);
        else if(getOut<x) {
            while(getOut<x){
                getOut++;
                success--;
            }
            if(getOut>=x&&getOut<=y&&success>=x&&success<=y)
                System.out.println(scores[x-1]);
            else System.out.println(-1);
        }
        else if(getOut>y) System.out.println(-1);
    }
}
