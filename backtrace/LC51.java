package backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC51 {
    private ArrayList<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] chessBoard = new char[n][n];
        for (char[] c : chessBoard) {
            Arrays.fill(c, '.');
        }
        backtrack(n, 0, chessBoard);
        return result;
    }

    public void backtrack(int n, int row, char[][] chessBoard) {
        //结束条件：遍历完棋盘
        if (row == n) {
            result.add(arrayList(chessBoard));
            return;
        }
        //棋盘的宽度高度相等
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, n, chessBoard)) {
                chessBoard[row][col] = 'Q';
                backtrack(n, row + 1, chessBoard);
                chessBoard[row][col] = '.';
            }
        }

    }

    public boolean isValid(int row, int col, int n, char[][] chessBoard) {
        //判断是否在同一列，同时做剪枝操作
        for (int i = 0; i < row; i++) {
            if (chessBoard[i][col] == 'Q') {
                return false;
            }
        }

        //判断45度角
        for (int i = row - 1, j = col - 1; i >=0 && j >= 0 ; i--, j--) {
            if (chessBoard[i][j] == 'Q') {
                return false;
            }
        }

        //判断135度角
        for (int i = row - 1, j = col + 1; i >=0 && j <= n - 1 ; i--, j++) {
            if (chessBoard[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public List<String> arrayList(char[][] chessBoard) {
        List<String> list = new ArrayList<>();

        for (char[] c : chessBoard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }
}
