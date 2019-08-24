public class TicTactToe {
    private String lastPlaced;
    private String[][] board;

    public TicTactToe() {
        this.board = new String[3][3];
    }

    public void place(String player, int horizontal, int vertical) {
        if (isPlayerOPlacingFirst(player)) {
            throw new PlayerXGoesFirstException();
        }
        if (isAlternatePlacingPlayer(player)) {
            throw new AlternatePlayerException(); // message indicating which player should move
        }
        if (board[horizontal][vertical] != null) {
            throw new BoardPositionException();
        }

        this.lastPlaced = player;
        this.board[horizontal][vertical] = player;

        if ("X".equalsIgnoreCase(board[0][0])
                && "X".equalsIgnoreCase(board[0][1])
                && "X".equalsIgnoreCase(board[0][2])) {
            throw new PlayerWinsException("X");
        }
    }

    private boolean isAlternatePlacingPlayer(String player) {
        return player.equalsIgnoreCase(lastPlaced);
    }

    private boolean isPlayerOPlacingFirst(String player) {
        return "O".equalsIgnoreCase(player) && lastPlaced == null;
    }
}
