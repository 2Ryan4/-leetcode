package backtrace;

public class LC37 {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    public boolean backtrack(char[][] board) {
        //题目表明仅有一个解，故不用遍历完所有情况，只用找到正确合法一个答案即可
        //遍历棋盘的每一行每一列，放入1-9依次判断是否合法
        //board.length == board[0].length == 9，涉及到棋盘大小都用9直接表达
        for (int i = 0; i < 9; i++) {//遍历行
            for (int j = 0; j < 9; j++) {//遍历列
                if (board[i][j] == '.') {
                    //遇到空格开始尝试放入数字并判断是否合法
                    for (char k = '1'; k <= '9'; k++) {

                        if (isValid(k, i, j, board)) {
                            board[i][j] = k;
                            boolean result = backtrack(board);
                            if (result == true) {
                                return result;
                            }
                            //回溯
                            board[i][j] = '.';
                        }
                    }
                    //1-9放入全部失败
                    return false;
                }
            }

        }
        return true;


    }

    public boolean isValid(int k, int row, int col, char[][] board) {
        //判断行是否有重复数字
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == k) {
                return false;
            }
        }

        //判断列是否有重复数字
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == k) {
                return false;
            }
        }

        //判断小棋盘内是否有重复数字
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == k) {
                    return false;
                }
            }
        }

        return true;
    }

}
