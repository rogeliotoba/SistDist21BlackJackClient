package sistDist.blackkack.command;

import sistDist.blackjack.Player;

public class StopCardsCommand extends Command
{

    public StopCardsCommand(Player player)
    {
        super("StopCards", player);
    }
    
    public StopCardsCommand()
    {
        super("StopCards");
    }
    
}
