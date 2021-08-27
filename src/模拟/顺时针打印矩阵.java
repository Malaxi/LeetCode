package 模拟;
/*
    29.顺时针打印矩阵
 */
public class 顺时针打印矩阵 {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0)    return new int[0];
        int up=0,down=matrix.length-1,left=0,right=matrix[0].length-1,x=0;
        int[] res = new int[matrix.length * matrix[0].length];
        while (true){
            //1.从左到右打印
            for (int i=left;i<=right;i++)    res[x++]=matrix[up][i];
            if(++up>down)break;
            //2.从上到下打印
            for(int i=up;i<=down;i++)    res[x++]=matrix[i][right];
            if(--right<left)    break;
            //3.从右到左打印
            for (int i=right;i>=left;i--)   res[x++]=matrix[down][i];
            if(--down<up)   break;
            //4.从下到上打印
            for (int i=down;i>=up;i--)  res[x++]=matrix[i][left];
            if(++left>right)    break;
        }
        return res;
    }
}
