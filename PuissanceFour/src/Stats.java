import java.util.Date;
import java.util.List;

public class Stats {
    Date timeStartGame;
    List<PlayerData> listPlayerData;
    Player winnerPlayer;

    public Stats() {
    }

    public Stats(List<PlayerData> listPlayerData, Date timeStartGame, Player winnerPlayer){
        this.listPlayerData = listPlayerData;
        this.timeStartGame = timeStartGame;
        this.winnerPlayer = winnerPlayer;
    }

    public Date getTimeStartGame() {
        return timeStartGame;
    }

    public void setTimeStartGame(Date timeStartGame) {
        this.timeStartGame = timeStartGame;
    }

    public List<PlayerData> getListPlayerData() {
        return listPlayerData;
    }

    public void setListPlayerData(List<PlayerData> listPlayerData) {
        this.listPlayerData = listPlayerData;
    }

    public Player getWinnerPlayer(){
        return winnerPlayer;
    }
}
