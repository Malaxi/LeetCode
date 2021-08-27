package 回溯题目;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//********************回溯方法*********************
//*****************数组有重复数字*******************
public class 组合总和1 {
    public static int[] candidates= {2,5,2,1,2};
    //主方法
    public static void main(String[] args) {
        System.out.println(combinationSum(candidates,5));
    }
    //方法1
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res= new LinkedList<>();
        //数组长度为0直接返回空集
        if(candidates.length==0)  return res;
        //数组长度不为空
        List<Integer> stack=new LinkedList<>();
        //回溯
        dfs(res,candidates,target,stack,0);
        return res;
    }
    //深度遍历:j表示当前节点在数组中的索引
    private static void dfs(List<List<Integer>> res, int[] candidates, int target, List<Integer> stack, int j) {
        //深度遍历的结束条件1
        if(sum(stack)==target){res.add(new ArrayList<>(stack));return;}
        //深度遍历的结束条件2
        if(sum(stack)>target) return;
        //用于保存在同一层中已经加入过栈的元素
        List<Integer> contents=new ArrayList<>();
        for(int i=j;i< candidates.length;i++){
            //当集合不为空并且当前数字在之前在同一层已经被加入到集合之中，就继续寻找下一数字
            if(contents!=null&&contents.contains(candidates[i])) continue;
            stack.add(candidates[i]);
            //向下一层传递的数组中不包括同一层中的前一个节点的值
            dfs(res,candidates,target,stack,i);
            contents.add(stack.remove(stack.size()-1));
        }
    }
    //计算一个集合的数字和(工具类)
    public static int sum(List<Integer> stack){
        int sum=0;
        for(Integer num:stack){
            sum+=num.intValue();
        }
        return sum;
    }
}
