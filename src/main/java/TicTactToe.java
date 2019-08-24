public class TicTactToe {
    private String lastPlaced;

    public void place(String player) {
        if ("O".equalsIgnoreCase(player)) {
            throw new PlayerXGoesFirstException();
        }

        if (player.equalsIgnoreCase(lastPlaced)) {
            throw new AlternatePlayerException(); // message indicating which player should move
        }
        this.lastPlaced = player;
    }
}
