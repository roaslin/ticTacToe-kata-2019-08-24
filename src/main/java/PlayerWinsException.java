public class PlayerWinsException extends RuntimeException {
    public PlayerWinsException(String player) {
        super("Player " + player + "wins the game!");
    }
}
