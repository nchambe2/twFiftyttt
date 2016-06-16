import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerTest {
    @Test
    public void shouldCapturetheCellToMarkWhenPlayerMakesASelection() throws IOException {
        BufferedReader bufferedReader = mock(BufferedReader.class);
        Player player = new Player(bufferedReader);
        when(bufferedReader.readLine()).thenReturn("1");

        assertThat(player.chooseCellToMark(), is("1"));
    }
}