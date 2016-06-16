import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GameTest {

    @Test
    public void shouldDisplayTicTacToeBoardWhenGameStarts() {
        Board board = mock(Board.class);
        Game game = new Game(board);

        game.start();

        verify(board).draw();
    }

}