public class TicTactToe {
    private String lastPlaced;

    public void place(String player) {
        if (isPlayerOPlacingFirst(player)) {
            throw new PlayerXGoesFirstException();
        }

        if (isAlternatePlacingPlayer(player)) {
            throw new AlternatePlayerException(); // message indicating which player should move
        }
        this.lastPlaced = player;
    }

    private boolean isAlternatePlacingPlayer(String player) {
        return player.equalsIgnoreCase(lastPlaced);
    }

    private boolean isPlayerOPlacingFirst(String player) {
        return "O".equalsIgnoreCase(player) && lastPlaced == null;
    }
}
