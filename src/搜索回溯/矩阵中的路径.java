package 搜索回溯;
/*
    12.给定一个m x n 二维字符网格board 和一个字符串单词word 。如
      果word 存在于网格中，返回 true ；否则，返回 false 。
      单词必须按照字母顺序，通过相邻的单元格内的字母构成，
      其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
      本质：深度遍历+剪枝
 */
public class 矩阵中的路径 {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        if(k == word.length - 1) return true;
        board[i][j] = '\0';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        //如果匹配失败的话要还原当前位置的元素以免造成数据丢失，
        // 继续下一次匹配，如果匹配成功的话还不还原当前位置元素无所谓
        board[i][j] = word[k];
        return res;
    }
}
