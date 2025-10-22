import java.io.File;

public class MatchManagement {
    private int randomGameID;
    private static int MATCH_COUNT = 15;
    private static int ROUND_COUNT = 3;
    private Gamer[] players;
    private Game[] games ;

    public MatchManagement(){
        //getting game and gamers arrays from FileIO commands
        Game[] games = FileIO.getGamesArray();
        Gamer[] players = FileIO.getGamersArray();
    }

    public void manageMatch(){
        for (int i = MATCH_COUNT; i > 0; i--){

        }
    }
    public int chooseGame(){
        //return the game's base point per round

        int random = RandUtil.randInt(10);

        return
    }
    public void getPlayers(){
        Gamer[] players = FileIO.getGamersArray();
    }
    public void getGames(){
        Game[] games = FileIO.getGamesArray();
    }
}
