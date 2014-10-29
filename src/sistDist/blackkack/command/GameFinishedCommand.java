package sistDist.blackkack.command;

import sistDist.blackjack.Player;

public class GameFinishedCommand extends Command
{

    public GameFinishedCommand(Player player)
    {
        super("GameFinished", player);
    }
    
    public GameFinishedCommand()
    {
        super("GameFinished");
    }
}
