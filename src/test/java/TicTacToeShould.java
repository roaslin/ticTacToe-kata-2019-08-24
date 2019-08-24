import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class TicTacToeShould {

    @Test
    public void exist() {

        TicTactToe ticTacToe = new TicTactToe();
        assertNotNull(ticTacToe);
    }

    @Test(expected = PlayerXGoesFirstException.class)
    public void does_not_allow_player_O_place_first() {
        TicTactToe ticTacToe = new TicTactToe();
        ticTacToe.place("O");
    }
}
