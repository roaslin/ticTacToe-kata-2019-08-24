import java.util.Arrays;

public class TicTactToe {
    private String lastPlaced;
    private String[][] board;

    public TicTactToe() {
        this.board = new String[9][9];
        Arrays.fill(this.board[0], "-");
    }

    public void place(String player, int horizontal, int vertical) {
        if (isPlayerOPlacingFirst(player)) {
            throw new PlayerXGoesFirstException();
        }
        if (isAlternatePlacingPlayer(player)) {
            throw new AlternatePlayerException(); // message indicating which player should move
        }
        if (!"-".equalsIgnoreCase(board[horizontal][vertical])) {
            throw new BoardPositionException();
        }

        this.lastPlaced = player;
        this.board[horizontal][vertical] = player;
    }

    private boolean isAlternatePlacingPlayer(String player) {
        return player.equalsIgnoreCase(lastPlaced);
    }

    private boolean isPlayerOPlacingFirst(String player) {
        return "O".equalsIgnoreCase(player) && lastPlaced == null;
    }
}
