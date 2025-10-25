import java.io.*;
import java.nio.charset.StandardCharsets;

public final class FileIO {

    private final Game[] gamesArray;
    private final Gamer[] gamersArray;

    public FileIO(String gamesPath, String gamersPath) throws IOException {
        this.gamesArray = loadGames(gamesPath);
        this.gamersArray = loadGamers(gamersPath);
    }

    public  Game[] getGamesArray() {
        return gamesArray;
    }

    public  Gamer[] getGamersArray() {
        return gamersArray;
    }

    private Game[] loadGames(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8))) {
            return br.lines()
                    .skip(1) // skip header
                    .map(line -> line.split(","))
                    .map(parts -> new Game(
                            Integer.parseInt(parts[0].trim()),
                            parts[1].trim(),
                            Integer.parseInt(parts[2].trim())
                    ))
                    .toArray(Game[]::new);
        }
    }

    private Gamer[] loadGamers(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8))) {
            return br.lines()
                    .skip(1) // skip header
                    .map(line -> line.split(","))
                    .map(parts -> new Gamer(
                            Integer.parseInt(parts[0].trim()),
                            parts[1].trim(),
                            parts[2].trim(),
                            parts[3].trim(),
                            Integer.parseInt(parts[4].trim())
                    ))
                    .toArray(Gamer[]::new);
        }
    }
}
