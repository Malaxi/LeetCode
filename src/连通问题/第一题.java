package 连通问题;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/*
    题目地址：https://www.nowcoder.com/questionTerminal/11ee0516a988421abf40b315a2b28d08
    思路：只要看到联通之类的题目，就应该想到使用查并集
 */

class UnionFind {
    public static int[] parent = new int[10000001];
    public static int[] personNums = new int[10000001];
    public UnionFind(){
        for(int i = 1; i <= 10000000; i++){
            //初始阶段每个人都是祖先
            parent[i] = i;
            //某个人的子孙人数
            personNums[i] = 1;
        }
    }
    //查找某个人的祖先，并进行路径压缩
    int find(int x) {
        if (x != parent[x])  // x不是自身的父亲，即x不是该集合的代表
            parent[x] = find(parent[x]);  // 查找x的祖先直到找到代表,于是顺手路径压缩
        return parent[x];
    }

    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY) return;
        parent[rootY] = rootX;
        personNums[rootX] += personNums[rootY];
    }
}

//代码缺点：只能确保最后合并的成为祖先的那个员工的圈子的人数数量(最大数不会改变)
public class 第一题 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T -- > 0){
            int n = Integer.parseInt(br.readLine());
            UnionFind uf = new UnionFind();
            for(int i = 0; i < n; i++){
                String[] params = br.readLine().trim().split(" ");
                int x = Integer.parseInt(params[0]);
                int y = Integer.parseInt(params[1]);
                uf.union(x, y);
            }
            int max = 0;
            for(int i = 1; i < uf.personNums.length; i++)
                max = Math.max(max, uf.personNums[i]);
            System.out.println(max);
        }
    }
}