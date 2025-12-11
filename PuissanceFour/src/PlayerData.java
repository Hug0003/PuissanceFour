public class PlayerData {
    private String name;
    private int nbToken;

    public PlayerData() {
    }

    public PlayerData(String name, int nbToken) {
        this.name = name;
        this.nbToken = nbToken;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNbToken() {
        return nbToken;
    }

    public void setNbToken(int nbToken) {
        this.nbToken = nbToken;
    }
}
