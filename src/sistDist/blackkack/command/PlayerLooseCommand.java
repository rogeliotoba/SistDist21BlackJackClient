package sistDist.blackkack.command;

import sistDist.blackjack.Player;

public class PlayerLooseCommand extends Command
{

    public PlayerLooseCommand(Player player)
    {
        super("PlayerLoose", player);
    }
    
    public PlayerLooseCommand()
    {
        super("PlayerLoose");
    }
}
