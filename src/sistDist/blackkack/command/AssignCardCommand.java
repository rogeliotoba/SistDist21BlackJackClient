package sistDist.blackkack.command;

import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONObject;

import sistDist.blackjack.Card;
import sistDist.blackjack.Player;

public class AssignCardCommand extends Command
{
    private Card card;
    
    public AssignCardCommand(Player player, Card card)
    {
        super("AssignCard", player);
        this.card = card;
    }

    public AssignCardCommand()
    {
        super("AssignCard");
    }

    public Card getCard()
    {
        return card != null ? card : new Card();
    }

    public void setCard(Card card)
    {
        this.card = card;
    }
    
    @Override
    public String getMetadata()
    {
        Map obj = new LinkedHashMap();
        obj.put("commandType", getType());
        obj.put("username", getPlayer().getPlayerName());
        obj.put("cardValue", getCard().getValue());
        obj.put("cardType", getCard().getType());
        return JSONObject.valueToString(obj);
    }
}