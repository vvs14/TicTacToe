package interview.flipkart.machinecoding.tictactoe;

import java.util.Arrays;

public class GameBoard {
  private char[][] gameBoard;
  private final int n = 3;
  private int totalValidMoves;

  public GameBoard() {
    gameBoard = new char[n][n];
    totalValidMoves = 0;
    for (int row = 0; row < n; row++) {
      Arrays.fill(gameBoard[row], ' ');
    }
  }

  public boolean makeMove(int row, int col, char symbol) {
    if (isMoveValid(row, col)) {
      gameBoard[row][col] = symbol;
      totalValidMoves++;
      return true;
    }
    return false;
  }

  public int getTotalValidMoves() {
    return totalValidMoves;
  }

  public void setTotalValidMoves(int totalValidMoves) {
    this.totalValidMoves = totalValidMoves;
  }

  private boolean isMoveValid(int row, int col) {
    if (row < 0 || row > 2) {
      return false;
    }
    if (col < 0 || col > 2) {
      return false;
    }
    if (gameBoard[row][col] != ' ') {
      return false;
    }
    return true;
  }

  public void display() {
    System.out.println("\n\n");
    for (int row = 0; row < n; row++) {
      for (int col = 0; col < n; col++) {
        System.out.print("\t" + gameBoard[row][col]);
        if (col != 2) {
          System.out.print("|");
        }
      }
      if (row != 2) {
        System.out.println("\n---------------\n");
      }
    }
  }

  public char match() {
    if (gameBoard[0][0] != ' ' && gameBoard[0][0] == gameBoard[0][1] && gameBoard[0][0] == gameBoard[0][2])
      return gameBoard[0][0];
    if (gameBoard[1][0] != ' ' && gameBoard[1][0] == gameBoard[1][1] && gameBoard[1][0] == gameBoard[1][2])
      return gameBoard[1][0];
    if (gameBoard[2][0] != ' ' && gameBoard[2][0] == gameBoard[2][1] && gameBoard[2][0] == gameBoard[2][2])
      return gameBoard[2][0];
    if (gameBoard[0][0] != ' ' && gameBoard[0][0] == gameBoard[1][0] && gameBoard[0][0] == gameBoard[2][0])
      return gameBoard[0][0];
    if (gameBoard[0][1] != ' ' && gameBoard[0][1] == gameBoard[1][1] && gameBoard[0][1] == gameBoard[2][1])
      return gameBoard[0][1];
    if (gameBoard[0][2] != ' ' && gameBoard[0][2] == gameBoard[1][2] && gameBoard[0][2] == gameBoard[2][2])
      return gameBoard[0][2];
    if (gameBoard[0][0] != ' ' && gameBoard[0][0] == gameBoard[1][1] && gameBoard[0][0] == gameBoard[2][2])
      return gameBoard[0][0];
    if (gameBoard[0][2] != ' ' && gameBoard[0][2] == gameBoard[1][1] && gameBoard[0][2] == gameBoard[2][0])
      return gameBoard[0][2];

    return 'N';
  }

}
