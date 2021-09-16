package 美团专场.美团10场;

import java.util.Arrays;
import java.util.Scanner;

public class 第二题 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] ints = new int[n];
        int result=0;
        for(int i=0;i<n;i++)
            ints[i]=scanner.nextInt();
        Arrays.sort(ints);
        for(int i=0;i<n;i++){
            if(ints[i]==i+1)    continue;
            else result=result+Math.abs(ints[i]-(i+1));
        }
        System.out.println(result);
    }
}
