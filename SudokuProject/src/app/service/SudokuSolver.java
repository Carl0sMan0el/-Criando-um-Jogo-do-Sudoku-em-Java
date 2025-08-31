package service;

import model.Board;

public class SudokuSolver {

    public static boolean solve(Board board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board.getCell(row, col).getValue() == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (board.isValid(row, col, num)) {
                            board.setCell(row, col, num);
                            if (solve(board)) return true;
                            board.setCell(row, col, 0);
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}