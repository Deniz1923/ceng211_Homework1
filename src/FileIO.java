import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileIO {

    public static Game[] loadGames(String filename) {
        Game[] tempGames = new Game[100];
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                int basePoint = Integer.parseInt(parts[2].trim());
                tempGames[count++] = new Game(id, name, basePoint);
            }
        } catch (IOException e) {
            System.err.println("Error reading games file: " + e.getMessage());
        }

        Game[] games = new Game[count];
        for (int i = 0; i < count; i++) {
            games[i] = tempGames[i];
        }
        return games;
    }

    public static Gamer[] loadGamers(String filename) {
        Gamer[] tempGamers = new Gamer[200];
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0].trim());
                String nickname = parts[1].trim();
                String name = parts[2].trim();
                String phone = parts[3].trim();
                int experience = Integer.parseInt(parts[4].trim());
                tempGamers[count++] = new Gamer(id, nickname, name, phone, experience);
            }
        } catch (IOException e) {
            System.err.println("Error reading gamers file: " + e.getMessage());
        }

        Gamer[] gamers = new Gamer[count];
        for (int i = 0; i < count; i++) {
            gamers[i] = tempGamers[i];
        }
        return gamers;
    }
}