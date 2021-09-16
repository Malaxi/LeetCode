package 美团专场;

import java.util.Arrays;
import java.util.Scanner;
/*
    在一般的乘法表中，最大值往往在最后项中。现在，我们将构建一种新的乘法表，在新的乘法表中，每一项的计算结果的值被反转并存
储在每一项中。比如说8*9= 72 (第8行第9列)，反转后将27保存在这一项中。在一般的乘法表中，第8行的前9项为8, 16, 24, 32, 40,
48, 56, 64, 72，显而易见72是最大的，但是在反转后的乘法表中，就变为了8, 61,42, 23, 4, 84, 65, 46, 27,所以84为最大值。

 */
public class 翻转乘法表 {
    public static void method1(int N,int K){
        int[] arr = new int[K];
        for(int i=0;i<K;i++){
            arr[i]=slove(N*(i+1));
        }
        Arrays.sort(arr);
        System.out.println(arr[K-1]);
    }
    public static int slove(int N){
        int ans = 0;
        while (N != 0) {
            ans = ans * 10 + (N % 10);
            N /= 10;
        }
        if (ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE) {
            ans = 0;
        }
        return ans;
    }
    public static void method2(int N,int K){
        int ans=0;
        for(int i=1;i<=K;i++){
            StringBuffer stringBuffer = new StringBuffer(String.valueOf(N * i)).reverse();
            ans=Math.max(ans,Integer.parseInt(stringBuffer.toString()));
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        //int N=scanner.nextInt();
        //int K=scanner.nextInt();
        System.out.print("method1：");
        method1(9,8);
        System.out.print("method2：");
        method2(9,8);
    }

}
