package me.shailesh.algorithms.basic;

import java.util.HashSet;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        var rowSets = new HashSet[n];
        var colSets = new HashSet[n];
        var subSets = new HashSet[n/3][n/3];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                char current = board[i][j];
                if(current == '.') {
                    continue;
                }

                int subRow = i/3;
                int subCol = j/3;
                if(rowSets[i] == null) {
                    rowSets[i] = new HashSet<Character>();
                }
                if(colSets[j] == null) {
                    colSets[j] = new HashSet<Character>();
                }
                if(subSets[subRow][subCol] == null) {
                    subSets[subRow][subCol] = new HashSet<Character>();
                }
                if(rowSets[i].contains(current) || colSets[j].contains(current) || subSets[subRow][subCol].contains(current)) {
                    return false;
                }
                rowSets[i].add(current);
                colSets[j].add(current);
                subSets[subRow][subCol].add(current);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var vs = new ValidSudoku();
        char[][] board = new char[][]{
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(vs.isValidSudoku(board));
    }
}
