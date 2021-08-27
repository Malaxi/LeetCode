package 回溯题目;

import java.util.ArrayList;
import java.util.List;
//********************回溯方法*********************
//********************很重要*********************
public class 数组子集 {
    public static int n;
    public static int[] nums={1,2,3};
    public static List<List<Integer>> result=new ArrayList<>();

    public static void main(String[] args) {
        /*1.递归法
        result=subsets_1(nums);
        for(List<Integer> list:result){
            System.out.print(list);
            System.out.print(" ");
        }
        System.out.println('\n');
        */

        //2.回溯法
        result=subsets_2(nums);
        for(List<Integer> list:result){
            System.out.print(list);
            System.out.print(" ");
        }

    }

    //1.利用递归法求解
    public static List<List<Integer>> subsets_1(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        //先加入空集
        result.add(new ArrayList<>());
        //集合中不会出现重复的数字
        for(Integer num:nums){
            List<List<Integer>> mid_result=new ArrayList<>();
            for(List<Integer> list:result){
                //依次便利result中的每一个集合，对该集合进行复制，添加新的元素后在添加到mid_result
                List<Integer> copy=new ArrayList<>(list);
                copy.add(num);
                mid_result.add(copy);
            }
            //将新产生的集合添加到result
            result.addAll(mid_result);
        }
        return result;
    }

    //2.利用回溯法进行求解
    public static List<List<Integer>> subsets_2(int[] nums){
        n=nums.length;
        //以长度作为标准，查找所有集合
        for(int k=0;k<=n;k++){
            //每次都是以数组起始元素为起点查找指定长度的子集集合
            backtrack(0,k,new ArrayList<Integer>(),nums);
        }
        return result;
    }
    //在nums中从start为起点查找长度为k的子集
    private static void backtrack(int start, int k, ArrayList<Integer> cur, int[] nums) {
        if(k==0){
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i=start;i<n;i++){
            cur.add(nums[i]);
            backtrack(i+1,k-1,cur,nums);
            cur.remove(cur.size()-1);
        }
    }
}
