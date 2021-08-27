package 搜索回溯;

import java.util.*;

/*
    38.输入一个字符串，打印出该字符串中字符的所有排列。
       你可以以任意顺序返回这个字符串数组，但里面不能有重复元素

 */
public class 字符串的排列 {
    List<String> res;
    StringBuilder tmp;
    boolean[] visited;

    public String[] permutation(String s) {
        //res 存储所有排序结果
        this.res = new ArrayList<String>();
        //tmp 存储临时排序结果
        this.tmp = new StringBuilder();
        //visited 是用来判断字符是否使用过的标志数组
        this.visited = new boolean[s.length()];

        //1.先将字符划分为字符数组并排序
        char[] temp = s.toCharArray();
        Arrays.sort(temp);

        //2.深度遍历：当前遍历到第0层
        dfs(temp,0);

        //3.返回最终结果
        return res.toArray(new String[res.size()]);
    }

    void dfs(char[] cs,int depth){
        if(depth == cs.length){
            res.add(tmp.toString());
            return;
        }
        for(int i = 0; i < cs.length; i++){
            //判断当前位置的元素是否使用过
            if(visited[i])  continue;
            //这是剪枝同一层的元素
            if(i > 0 && cs[i - 1] == cs[i] && visited[i - 1]==false)  continue;

            tmp.append(cs[i]);
            visited[i] = true;

            dfs(cs,depth + 1);

            visited[i] = false;
            tmp.deleteCharAt(tmp.length() - 1);
        }

    }
}
