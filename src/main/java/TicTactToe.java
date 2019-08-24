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

        if (isUpperHorizontalWonByPlayer("X")) {
            throw new PlayerWinsException("X");
        }

        if (isUpperHorizontalWonByPlayer("O")) {
            throw new PlayerWinsException("O");
        }

        if (isGameEnded()) {
            throw new EndGameException();
        }
    }

    private boolean isGameEnded() {
        boolean isGameEnded = true;
        for (int horizontalPosition = 0; horizontalPosition < 3; horizontalPosition++) {
            for (int verticalPosition = 0; verticalPosition < 3; verticalPosition++) {
                if (board[horizontalPosition][verticalPosition] == null) {
                    isGameEnded = false;
                    break;
                }
            }
        }
        return isGameEnded;
    }

    private boolean isUpperHorizontalWonByPlayer(String x) {
        return x.equalsIgnoreCase(board[0][0])
                && x.equalsIgnoreCase(board[0][1])
                && x.equalsIgnoreCase(board[0][2]);
    }

    private boolean isAlternatePlacingPlayer(String player) {
        return player.equalsIgnoreCase(lastPlaced);
    }

    private boolean isPlayerOPlacingFirst(String player) {
        return "O".equalsIgnoreCase(player) && lastPlaced == null;
    }
}
