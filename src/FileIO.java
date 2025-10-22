import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileIO {

    private static final String GAMES_FILE_PATH = "games.csv";
    private static final String GAMERS_FILE_PATH = "gamers.csv";

    private String[] gamesArray;
    private String[] gamersArray;

    public FileIO() {
        try {
            int gameLineCount = countLines(GAMES_FILE_PATH);
            this.gamesArray = new String[gameLineCount];
            readLinesToArray(GAMES_FILE_PATH, this.gamesArray);

            int gamerLineCount = countLines(GAMERS_FILE_PATH);
            this.gamersArray = new String[gamerLineCount];
            readLinesToArray(GAMERS_FILE_PATH, this.gamersArray);

        } catch (IOException e) {
            e.printStackTrace();
            this.gamesArray = new String[0];
            this.gamersArray = new String[0];
        }
    }

    public String[] getGamesArray() {
        return this.gamesArray;
    }

    public String[] getGamersArray() {
        return this.gamersArray;
    }

    private int countLines(String filePath) throws IOException {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(filePath), StandardCharsets.UTF_8))) {

            while (reader.readLine() != null) {
                count++;
            }
        }
        return count;
    }

    private void readLinesToArray(String filePath, String[] targetArray) throws IOException {
        int index = 0;
        String line;

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(filePath), StandardCharsets.UTF_8))) {

            while ((line = reader.readLine()) != null) {
                if (index < targetArray.length) {
                    targetArray[index] = line;
                    index++;
                } else {
                    break;
                }
            }
        }
    }
}