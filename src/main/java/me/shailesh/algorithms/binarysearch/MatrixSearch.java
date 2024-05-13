package me.shailesh.algorithms.binarysearch;

public class MatrixSearch {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m * n - 1;
        int k = 0;
        while (start <= end) {
            k = (start + end) / 2;
            int i = k / n;
            int j = k % n;
            System.out.println("m: " + m + " n: " + n + " target: " + target + " start: " + start + " end: " + end + " i: " + i + " j: " + j + " k: " + k);
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] < target) {
                start = k + 1;
                continue;
            }
            end = k - 1;
        }
        return false;
    }

    public boolean searchMatrixAlt(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int startRow = 0;
        int endRow = m - 1;
        int startCol = 0;
        int endCol = n - 1;

        while(startRow <= endRow) {
            int currentRow = (startRow + endRow) / 2;
            if(target == matrix[currentRow][0] || target == matrix[currentRow][n - 1]) {
                return true;
            }

            if(target < matrix[currentRow][0]) {
                endRow = currentRow  - 1;
                continue;
            }

            if(target > matrix[currentRow][n-1]) {
                startRow = currentRow + 1;
                continue;
            }
            while(startCol <= endCol) {
                int currentCol = (startCol + endCol) / 2;
                if(target == matrix[currentRow][currentCol]) {
                    return true;
                }
                if(target < matrix[currentRow][currentCol]) {
                    endCol = currentCol - 1;
                    continue;
                }
                startCol = currentCol + 1;
            }
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        var ms = new MatrixSearch();
        System.out.println(ms.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
        System.out.println(ms.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13));
        // More test cases
        System.out.println(ms.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 1));
        System.out.println(ms.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 7));
        System.out.println(ms.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 60));
        System.out.println(ms.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 23));

        // Same test cases for searchMatrixALt
        System.out.println(ms.searchMatrixAlt(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
        System.out.println(ms.searchMatrixAlt(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13));
        // More test cases
        System.out.println(ms.searchMatrixAlt(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 1));
        System.out.println(ms.searchMatrixAlt(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 7));
        System.out.println(ms.searchMatrixAlt(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 60));
        System.out.println(ms.searchMatrixAlt(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 23));
    }
}
