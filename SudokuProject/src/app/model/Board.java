package model;

public class Board {
    private Cell[][] board = new Cell[9][9];

    public Board(String args) {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                board[i][j] = new Cell(0, false);

        String[] entries = args.split(" ");
        for (String entry : entries) {
            String[] parts = entry.split(";");
            String[] pos = parts[0].split(",");
            int x = Integer.parseInt(pos[0]);
            int y = Integer.parseInt(pos[1]);
            String[] valFixed = parts[1].split(",");
            int value = Integer.parseInt(valFixed[0]);
            boolean fixed = Boolean.parseBoolean(valFixed[1]);
            board[y][x] = new Cell(value, fixed);
        }
    }

    public Cell getCell(int row, int col) {
        return board[row][col];
    }

    public void setCell(int row, int col, int value) {
        if (!board[row][col].isFixed())
            board[row][col].setValue(value);
    }

    public void printBoard() {
        System.out.println("+-------+-------+-------+");
        for (int i = 0; i < 9; i++) {
            System.out.print("| ");
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j].getValue() + " ");
                if ((j + 1) % 3 == 0) System.out.print("| ");
            }
            System.out.println();
            if ((i + 1) % 3 == 0) System.out.println("+-------+-------+-------+");
        }
    }

    public boolean isValid(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i].getValue() == num) return false;
            if (board[i][col].getValue() == num) return false;
        }
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[startRow+i][startCol+j].getValue() == num)
                    return false;
        return true;
    }
}