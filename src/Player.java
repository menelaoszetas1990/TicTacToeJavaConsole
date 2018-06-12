public class Player {
    private String playerName;

    // empty constructor
    public Player() {}

    // special constructor to insert the player's name
    public Player( String name) {
        this.playerName = name;
    }

//    // getter and setter methods
//    public void setPlayerName(String playerName) {
//        this.playerName = playerName;
//    }
//
//    public String getPlayerName() {
//        return playerName;
//    }

    @Override
    public String toString() {
        return playerName;
    }
}
