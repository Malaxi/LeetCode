package 动态规划;
/*
    42.输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值
 */
public class 连续子数组的最大和 {
    public int maxSubArray(int[] nums) {
        //res表示的是数组中每个位置的连续数组位置的最大值
        int res,max;
        res=max=nums[0];
        for(int i=1;i<nums.length;i++) {
            //如果当前位置之前的连续数组的最大和小于0，则当前位置的连续数组的最大和是自己
            if (res < 0)
                res = nums[i];
            //如果当前位置之前的连续数组的最大和大于等于0，则当前位置的连续数组的最大和是自己+前一个位置的最大和
            else
                res = nums[i] + res;
            if(res>max)
                max=res;
        }
        return max;
    }
}
