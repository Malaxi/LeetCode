package 回溯题目;

import java.util.*;

//********************回溯方法*********************
//*****************数组有重复数字*******************
public class 全排列1 {
    public static int[] nums={3,3,0,3};
    public static int len=nums.length;
    //主方法
    public static void main(String[] args) {
        System.out.println(permute(nums));
    }
    //方法1：深优先遍历
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //Deque<Integer> deque=new ArrayDeque<>();
        Stack<Integer> stack=new Stack<>();
        boolean[] pos=new boolean[len];
        //如果数组长度为0，直接h返回一个空集合
        if(len==0) return res;
        //重头戏
        dfs(nums,0,res,stack,pos,len);
        return res;
    }
    public static void dfs(int[] nums,int depth,List<List<Integer>> res, Stack<Integer> stack,boolean[] pos,int len) {
        //结束条件1：已经到了最后一层
        if(depth==len){
            res.add(new ArrayList<>(stack));return;
        }
        //用于保存在同一层中已经加入过栈的元素
        List<Integer> contents=new ArrayList<>();
        for(int i=0;i<len;i++){
            //1.如果该数字之前已经被添加到栈，就继续寻找下一数字
            if(pos[i]==true) continue;
            //2.当集合不为空并且当前数字在之前在同一层已经被加入到集合之中，就继续寻找下一数字
            if(contents!=null&&contents.contains(nums[i])) continue;
            //3.向集中添加符合条件的数字
            stack.push(nums[i]);
            pos[i]=true;
            dfs(nums,depth+1,res,stack,pos,len);
            contents.add(stack.pop());
            pos[i]=false;
        }
    }
}


