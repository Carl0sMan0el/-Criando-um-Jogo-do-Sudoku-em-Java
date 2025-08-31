import model.Board; 
import service.SudokuSolver; 
import java.nio.file.*; 
import java.io.IOException; 
public class Main {
     public static void main(String[] args) {
         String input = "";
          try {
             input = new String(Files.readAllBytes(Paths.get("app/input.txt")));
            } catch (IOException e) { System.out.println("Erro ao ler o arquivo input.txt"); e.printStackTrace(); return; }
          Board board = new Board(input);
          System.out.println("Tabuleiro inicial:");
          board.printBoard();
          if (SudokuSolver.solve(board)) {
              System.out.println("Tabuleiro resolvido:");
              board.printBoard();
          } else {
              System.out.println("Não foi possível resolver o Sudoku!");
          }
      }
}