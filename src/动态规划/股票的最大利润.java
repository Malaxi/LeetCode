package 动态规划;

import java.util.ArrayList;

/*
    63.假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 */
public class 股票的最大利润 {
    //第一种方法：暴力破解
    public int maxProfit1(int[] prices) {
        int res=0;
        for(int i=1;i<prices.length;i++){
            for(int j=0;j<i;j++){
                if(prices[i]-prices[j]<0) continue;
                if(prices[i]-prices[j]>res) res=prices[i]-prices[j];
            }
        }
        return res;
    }
    //第二种方法：动态规划
    public int maxProfit2(int[] prices) {
        /*
            price为当日价格
            profit为之前计算的最大利润
         */
        int cost = Integer.MAX_VALUE, profit = 0;
        //对于每一个价格，计算它和在它之前的最低价格的差：最低价格也可以是自己
        for(int price : prices) {
            //cost要找到数组起始位置到当前位置(price)价格的最低值
            cost = Math.min(cost, price);
            //profit是计算当前位置(price)的价格和在它之前的最低价格的差，也就是最大利润
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
}
