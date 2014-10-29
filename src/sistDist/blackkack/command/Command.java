package sistDist.blackkack.command;

import org.json.JSONObject;

import sistDist.blackjack.Player;

public abstract class Command
{
    private String type;
    private Player player;

    public Command(String type)
    {
        this.type = type;
    }

    public Command(String type, Player player)
    {
        this.type = type;
        this.player = player;
    }

    public String getType()
    {
        return type != null ? type : "";
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public Player getPlayer()
    {
        return player != null ? player : new Player();
    }

    public void setPlayer(Player player)
    {
        this.player = player;
    }
    
    public String getMetadata()
    {
        JSONObject obj = new JSONObject();
        obj.put("commandType", getType());
        obj.put("username", getPlayer().getPlayerName());
        return obj.toString();
    }
}
