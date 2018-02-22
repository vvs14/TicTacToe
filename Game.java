package interview.flipkart.machinecoding.tictactoe;

public class Game {
  private Player first;
  private Player second;

  public void start() {
    GameBoard gb = new GameBoard();
    first = new Player('X', gb);
    second = new Player('O', gb);
    boolean isGameFinished = false;
    Player currentPlayer = first;
    while (!isGameFinished) {
      currentPlayer.chooseMove();
      boolean isMoveSuccessful = currentPlayer.markMove();
      if (isMoveSuccessful) {
        gb.display();
        if (gb.getTotalValidMoves() >= 5) {
          char result = gb.match();
          if (result != 'N') {
            System.out.println("\n" + result + " is the winner.");
            isGameFinished = true;
          }
          else if (gb.getTotalValidMoves() == 9) {
            System.out.println("\nThe game is draw.");
            isGameFinished = true;
          }
        }
        if (currentPlayer == first) {
          currentPlayer = second;
        }
        else {
          currentPlayer = first;
        }
      }
    }
  }
}
