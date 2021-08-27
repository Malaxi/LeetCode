package 动态规划;
/*
    10-||.一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法
          此类求多少种可能性的题目一般都有递推性质 ，即 f(n)和 f(n-1)…f(1)之间是有联系的
          这道题的本质就是斐波那契数列，代码一模一样
 */
public class 青蛙跳台阶 {
    public int numWays(int n) {
        int a=1,b=2,sum;
        //跳上一个0级台阶有1种跳法
        if(n==0)    return 1;
        //跳上一个1级台阶有1种跳法
        if(n==1)    return a;
        //跳上一个2级台阶有2种跳法
        if(n==2)    return b;
        for(int i=3;i<=n;i++){
            sum=(a+b)%1000000007;
            a=b;
            b=sum;
        }
        return b;
    }
}
