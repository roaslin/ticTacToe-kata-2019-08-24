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

    @Test(expected = PlayerWinsException.class)
    public void has_a_winner_when_player_places_3_X_in_a_horizontal_row() {
        ticTacToe.place("X", 0,0);
        ticTacToe.place("O", 1,0);
        ticTacToe.place("X", 0,1);
        ticTacToe.place("O", 2,0);
        ticTacToe.place("X", 0,2);
    }
}
