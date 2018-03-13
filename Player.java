public class Player {

  private final char symbol;
  private final GameBoard gb;

  private int row;
  private int col;

  public Player(char s, GameBoard gb) {
    symbol = s;
    this.gb = gb;
  }

  public int getRow() {
    return row;
  }

  public void setRow(int row) {
    this.row = row;
  }

  public int getCol() {
    return col;
  }

  public void setCol(int col) {
    this.col = col;
  }

  public char getSymbol() {
    return symbol;
  }

  public GameBoard getGb() {
    return gb;
  }

  public void chooseMove() {
    row = (int) (Math.random() * 3);
    col = (int) (Math.random() * 3);
  }

  public boolean markMove() {
    if (gb.makeMove(row, col, symbol)) {
      return true;
    }
    return false;
  }
}
