import java.io.BufferedReader;
import java.io.IOException;

public class UserInput {

    private BufferedReader bufferedReader;

    public UserInput(BufferedReader bufferedReader) {

        this.bufferedReader = bufferedReader;
    }

    public String get() {
        String cellToMark = "";

        try {
            cellToMark = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cellToMark;
    }

}
