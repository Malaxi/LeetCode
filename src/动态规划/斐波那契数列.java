package 动态规划;
/*
    10-|.写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）
 */
public class 斐波那契数列 {
    public int fib(int n) {
        int a = 0, b = 1, sum;
        if(n==0)    return 0;
        if(n==1)    return 1;
        //从头开始计算f(n)的值
        for(int i = 2; i <=n; i++){
            sum = (a + b) % 1000000007;
            //a是f(n-2)的值
            a = b;
            //b是f(n-1)的值
            b = sum;
        }
        return b;
    }
}
