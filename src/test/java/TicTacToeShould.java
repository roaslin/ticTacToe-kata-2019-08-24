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
        ticTacToe.place("O", 0, 0);
    }

    @Test(expected = AlternatePlayerException.class)
    public void not_let_player_place_twice_in_a_row() {
        ticTacToe.place("X", 0, 0);
        ticTacToe.place("X", 0, 0);
        ticTacToe.place("O", 0, 0);
    }

    @Test(expected = BoardPositionException.class)
    public void not_allow_placing_in_the_same_position() {
        ticTacToe.place("X", 0,0);
        ticTacToe.place("O", 0,1);
        ticTacToe.place("X", 0,1);
    }
}
