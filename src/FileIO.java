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

/* AI.io

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

public final class FileIO {
    private final Game[]  gamesArray;
    private final Gamer[] gamersArray;


public FileIO(String gamesCsvPath, String gamersCsvPath) throws IOException {
    int gameCount  = countValidRows(gamesCsvPath, 3);   // id, name, basePoint
    int gamerCount = countValidRows(gamersCsvPath, 5);  // id, nick, name, phone, exp

    this.gamesArray  = new Game[gameCount];
    this.gamersArray = new Gamer[gamerCount];

    readGames(gamesCsvPath,  this.gamesArray);
    readGamers(gamersCsvPath, this.gamersArray);
}

public Game[]  getGamesArray()  { return gamesArray; }
public Gamer[] getGamersArray() { return gamersArray; }

// ---------- internal helpers ----------

private static int countValidRows(String path, int expectedColumns) throws IOException {
    int count = 0;
    try (BufferedReader br = new BufferedReader(
            new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8))) {
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            String[] parts = splitCsv(line);
            // If there is a header row, the first token won't be an int; skip it gracefully.
            if (parts.length < expectedColumns) continue;
            if (!isInteger(parts[0])) continue;

            count++;
        }
    }
    return count;
}

private static void readGames(String path, Game[] target) throws IOException {
    int i = 0;
    try (BufferedReader br = new BufferedReader(
            new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8))) {
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            String[] p = splitCsv(line);
            if (p.length < 3 || !isInteger(p[0])) continue; // skip header/invalid

            int    id     = Integer.parseInt(p[0].trim());
            String name   = p[1].trim();
            int    basePt = Integer.parseInt(p[2].trim());

            target[i++] = new Game(id, name, basePt);  // uses your Game class
        }
    }
    if (i != target.length) throw new IOException("Parsed games count mismatch");
}

private static void readGamers(String path, Gamer[] target) throws IOException {
    int i = 0;
    try (BufferedReader br = new BufferedReader(
            new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8))) {
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            String[] p = splitCsv(line);
            if (p.length < 5 || !isInteger(p[0])) continue; // skip header/invalid

            int    id   = Integer.parseInt(p[0].trim());
            String nick = p[1].trim();
            String name = p[2].trim();
            String tel  = p[3].trim();
            int    exp  = Integer.parseInt(p[4].trim());

            target[i++] = new Gamer(id, nick, name, tel, exp); // uses your Gamer class
        }
    }
    if (i != target.length) throw new IOException("Parsed gamers count mismatch");
}

// Minimal CSV splitter for simple comma-separated values (no quotes with commas needed here).
private static String[] splitCsv(String line) {
    // Trim surrounding quotes if present for each field.
    String[] raw = line.split(",", -1);
    for (int i = 0; i < raw.length; i++) {
        String s = raw[i].trim();
        if (s.length() >= 2 && s.startsWith("\"") && s.endsWith("\"")) {
            s = s.substring(1, s.length() - 1);
        }
        raw[i] = s;
    }
    return raw;
}

private static boolean isInteger(String s) {
    try { Integer.parseInt(s.trim()); return true; }
    catch (NumberFormatException e) { return false; }
}
}

*/