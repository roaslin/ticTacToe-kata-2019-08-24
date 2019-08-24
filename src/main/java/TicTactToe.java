public class TicTactToe {
    public void place(String player) {
        if ("O".equalsIgnoreCase(player)) {
            throw new PlayerXGoesFirstException();
        }
    }
}
