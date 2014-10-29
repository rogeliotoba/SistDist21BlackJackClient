package sistDist.blackjack;
/**
 *
 * @author rogeliotorres
 */
public class Player {
    private PlayerPanel playerPanel;
    private String playerName;
    private String ip;
    
    public Player(){
    	
    }

    public Player(String name){
        playerPanel = new PlayerPanel(name);
        this.playerName = name;
    }

    public PlayerPanel getPlayerPanel() {
        return playerPanel;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
        playerPanel.setPlayerName(playerName);
    }

    public String getIp(){
    	return this.ip;
    }

    public void setIp(String ip){
    	this.ip=ip;
    }
}
