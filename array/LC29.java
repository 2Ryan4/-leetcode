package array;

public class LC29 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int startX = 0;
        int startY = 0;//定义每次循环的起始坐标

        int loop = n / 2;//循环的圈数
        //每循环一圈，剩下未被循环的矩阵边长为上次边长的长度-2

        int count = 1;//用于赋值
        int offset = 1;//用来控制循环的边长度

        int i , j;
        while (loop != 0) {
            i = startX;
            j = startY;

            //当遇到拐角时，便模拟一条全新的边以拐角为起点，所以区间为左闭右开
            //模拟从左到右
            for (j = startY; j < n - offset; j++) {
                matrix[startX][j] = count++;
            }
            //模拟从上到下
            for (i = startX; i < n - offset; i++) {
                matrix[i][j] = count++;
            }
            //模拟从右到左
            for (; j > startY; j--) {
                matrix[i][j] = count++;
            }
            //模拟从下到上
            for (; i > startX; i--) {
                matrix[i][j] = count++;
            }

            startX++;
            startY++;//循环一圈后，起始位置的横纵坐标都加一
            offset++;//每循环一次，循环边长度-2，因为起始位置横纵坐标加一，所以offset加一
            loop--;//圈数减一
        }
        //如果n为奇数，需要单独给最中间的元素赋值
        if (n % 2 == 1) {
            matrix[n / 2][n / 2] = count;
        }

        return matrix;

    }
}
