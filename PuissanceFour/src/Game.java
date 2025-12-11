import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Game {
    private ArrayList<ArrayList<Player>> board;
    public static final int COLUMNS = 7;
    public static final int ROWS = 6;

    public Game(){
        board = new ArrayList<>(COLUMNS);
        for (int i = 0; i < COLUMNS; i++) {
            board.add(new ArrayList<>());
        }
    }

    public boolean playMove(int col, Player player) {
        if (col < 0 || col >= COLUMNS) {
            System.out.println("Invalid column number.");
            return false;
        }
        ArrayList<Player> column = board.get(col);
        if (column.size() < ROWS) {
            column.add(player);
            return true;
        } else {
            System.out.println("Column is full.");
            return false;
        }
    }

    public void nbTokenPlay(Player player){
        player.incrementNbToken();
    }

    public void saveGameStats(Player p1, Player p2, Player winner) {
        ObjectMapper objectMapper = new ObjectMapper();
        
        List<PlayerData> playerDataList = new ArrayList<>();
        playerDataList.add(new PlayerData(p1.getName(), p1.getNbToken()));
        playerDataList.add(new PlayerData(p2.getName(), p2.getNbToken()));

        Stats stats = new Stats(playerDataList, new Date(), winner);

        File file = new File("data.json");
        ArrayList<Stats> statsList = new ArrayList<>();

        if (file.exists() && file.length() > 0) {
            try {
                statsList = objectMapper.readValue(file, new TypeReference<ArrayList<Stats>>() {});
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        statsList.add(stats);

        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, statsList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showBoard(){
        System.out.println("-----------------------------");
        for (int r = ROWS - 1; r >= 0; r--) {
            System.out.print("| ");
            for (int c = 0; c < COLUMNS; c++) {
                ArrayList<Player> column = board.get(c);
                if (r < column.size()) {
                    System.out.print(column.get(r).getSymbol() + " | ");
                } else {
                    System.out.print("  | ");
                }
            }
            System.out.println();
        }
        System.out.println("-----------------------------");
        System.out.println("  1   2   3   4   5   6   7");
    }

    public boolean checkWin() {
        // Horizontal
        for (int c = 0; c < COLUMNS - 3; c++) {
            for (int r = 0; r < ROWS; r++) {
                if (checkFour(c, r, 1, 0)) return true;
            }
        }
        // Vertical
        for (int c = 0; c < COLUMNS; c++) {
            for (int r = 0; r < ROWS - 3; r++) {
                if (checkFour(c, r, 0, 1)) return true;
            }
        }
        // Diagonal /
        for (int c = 0; c < COLUMNS - 3; c++) {
            for (int r = 0; r < ROWS - 3; r++) {
                if (checkFour(c, r, 1, 1)) return true;
            }
        }
        // Diagonal \
        for (int c = 0; c < COLUMNS - 3; c++) {
            for (int r = 3; r < ROWS; r++) {
                if (checkFour(c, r, 1, -1)) return true;
            }
        }
        return false;
    }

    private boolean checkFour(int c, int r, int dc, int dr) {
        Player p = getPlayerAt(c, r);
        if (p == null) return false;
        for (int i = 1; i < 4; i++) {
            if (getPlayerAt(c + i * dc, r + i * dr) != p) return false;
        }
        return true;
    }

    private Player getPlayerAt(int c, int r) {
        if (c < 0 || c >= COLUMNS) return null;
        ArrayList<Player> column = board.get(c);
        if (r < 0 || r >= column.size()) return null;
        return column.get(r);
    }

    public boolean isFull() {
        for (ArrayList<Player> column : board) {
            if (column.size() < ROWS) return false;
        }
        return true;
    }
}
