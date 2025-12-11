public class Player {
    private String name;
    private char symbol;
    private Integer nbToken;


    public Player() {
    }

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
        this.nbToken = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public Integer getNbToken() {
        return nbToken;
    }

    public void setNbToken(Integer nbToken) {
        this.nbToken = nbToken;
    }

    public void incrementNbToken(){
        this.nbToken ++;
    }
}
