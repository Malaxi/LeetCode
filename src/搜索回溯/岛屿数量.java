package 搜索回溯;

public class 岛屿数量 {
    public static int num=0;
    public static int slove(int[][] grid){
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    dfs(grid,i,j);
                    num++;
                }
            }
        return num;
    }

    private static void dfs(int[][] grid, int i, int j) {
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]==2||grid[i][j]==0)
            return;
        grid[i][j]=2;
        //上
        if(i>0&&grid[i-1][j]==1) dfs(grid,i-1,j);
        //下
        if(i<grid.length-1&&grid[i+1][j]==1) dfs(grid,i+1,j);
        //左
        if(j>0&&grid[i][j-1]==1)  dfs(grid,i,j-1);
        //右
        if(j<grid[0].length-1&&grid[i][j+1]==1) dfs(grid,i,j+1);
    }

    public static void main(String[] args) {
        int[][] grid= {{1,1,0,0,0},{0,1,0,1,1},{0,0,0,1,1},{0,0,0,0,0},{0,0,1,1,1}};
        System.out.println("岛屿数量："+slove(grid));
    }
}
