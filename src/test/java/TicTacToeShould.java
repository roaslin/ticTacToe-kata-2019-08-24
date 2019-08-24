import org.junit.Before;
import org.junit.Test;

public class TicTacToeShould {

    private TicTactToe ticTacToe;

    @Before
    public void setUp() {
        ticTacToe = new TicTactToe();
    }

    @Test(expected = PlayerXGoesFirstException.class)
    public void does_not_allow_player_O_place_first() {
        TicTactToe ticTacToe = new TicTactToe();
        ticTacToe.place("O");
    }

    @Test(expected = AlternatePlayerException.class)
    public void not_let_player_place_twice_in_a_row() {
        ticTacToe.place("X");
        ticTacToe.place("X");
        ticTacToe.place("O");
    }
}
