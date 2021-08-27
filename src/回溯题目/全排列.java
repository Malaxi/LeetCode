package 回溯题目;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
//********************回溯方法*********************
//*****************数组无重复数字*******************
public class 全排列 {
    public static int[] nums={1,2,3};
    public static int len=nums.length;
    //主方法：
    public static void main(String[] args) {
        System.out.println(permute1(nums));
    }
    //方法1：不推荐
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }
        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }
    public static void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        /*
            @ public static void swap(List list, int i, int j)
            @ list –交换元素的列表
            @ i要交换的一个元素的索引
            @ j要交换的其他元素的索引
         */
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }
    //方法2：基于深度遍历——https://leetcode-cn.com/problems/permutations/solution/quan-pai-lie-by-leetcode-solution-2/
    public static List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Stack<Integer> stack=new Stack<>();
        boolean[] pos=new boolean[len];
        //如果数组长度为0，直接返回一个空集合
        if(len==0) return res;
        //重头戏
        dfs(nums,0,res,stack,pos,len);
        return res;
    }

    public static void dfs(int[] nums,int depth,List<List<Integer>> res, Stack<Integer> stack, boolean[] pos, int len) {
        if(depth==len){
            res.add(new ArrayList<>(stack));return;
        }
        for(int i=0;i<len;i++){
            //1.
            if(pos[i]==true) continue;
            //2.
            stack.push(nums[i]);
            pos[i]=true;
            dfs(nums,depth+1,res,stack,pos,len);
            stack.pop();
            pos[i]=false;
        }
    }
}
