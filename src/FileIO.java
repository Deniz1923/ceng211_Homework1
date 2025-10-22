import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileIO {

    private Game[] gamesArray;
    private Gamer[] gamersArray;

    public FileIO(String GAMES_FILE_PATH, String GAMERS_FILE_PATH) {
        try {
            int gameLineCount = countLines(GAMES_FILE_PATH);
            this.gamesArray = new Game[gameLineCount];
            readLinesToArray(GAMES_FILE_PATH, this.gamesArray);

            int gamerLineCount = countLines(GAMERS_FILE_PATH);
            this.gamersArray = new Gamer[gamerLineCount];
            readLinesToArray(GAMERS_FILE_PATH, this.gamersArray);

        } catch (IOException e) {
            e.printStackTrace();
            this.gamesArray = new String[0];
            this.gamersArray = new String[0];
        }
    }

    public static Game[] getGamesArray() {
        return this.gamesArray;
    }

    public static Gamer[] getGamersArray() {
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

/*import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class FileIO {

    private Game[] gamesArray;
    private Gamer[] gamersArray;

    public FileIO(String gamesFilePath, String gamersFilePath) {
        try {
            int gameCount = countLines(gamesFilePath);
            gamesArray = new Game[gameCount];
            readGamesFile(gamesFilePath, gamesArray);

            int gamerCount = countLines(gamersFilePath);
            gamersArray = new Gamer[gamerCount];
            readGamersFile(gamersFilePath, gamersArray);

        } catch (IOException e) {
            System.err.println("Error reading files: " + e.getMessage());
            gamesArray = new Game[0];
            gamersArray = new Gamer[0];
        }
    }

    // === Getters ===
    public Game[] getGamesArray() {
        return gamesArray;
    }

    public Gamer[] getGamersArray() {
        return gamersArray;
    }

    // === Private Helper Methods ===
    private int countLines(String filePath) throws IOException {
        int count = 0;
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
            while (reader.readLine() != null) {
                count++;
            }
        } finally {
            if (reader != null) reader.close();
        }
        return count;
    }

    private void readGamesFile(String filePath, Game[] targetArray) throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
            String line;
            int index = 0;

            while ((line = reader.readLine()) != null && index < targetArray.length) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    try {
                        int id = Integer.parseInt(parts[0].trim());
                        String name = parts[1].trim();
                        int basePoint = Integer.parseInt(parts[2].trim());
                        targetArray[index] = new Game(id, name, basePoint);
                        index++;
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid number format in game line: " + line);
                    }
                } else {
                    System.err.println("Invalid game line format: " + line);
                }
            }
        } finally {
            if (reader != null) reader.close();
        }
    }

    private void readGamersFile(String filePath, Gamer[] targetArray) throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
            String line;
            int index = 0;

            while ((line = reader.readLine()) != null && index < targetArray.length) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    try {
                        int id = Integer.parseInt(parts[0].trim());
                        String nickname = parts[1].trim();
                        String name = parts[2].trim();
                        String phone = parts[3].trim();
                        int expYears = Integer.parseInt(parts[4].trim());
                        targetArray[index] = new Gamer(id, nickname, name, phone, expYears);
                        index++;
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid number format in gamer line: " + line);
                    }
                } else {
                    System.err.println("Invalid gamer line format: " + line);
                }
            }
        } finally {
            if (reader != null) reader.close();
        }
    }
}
*/