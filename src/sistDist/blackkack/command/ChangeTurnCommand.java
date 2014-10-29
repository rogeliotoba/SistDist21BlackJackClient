package sistDist.blackkack.command;

import sistDist.blackjack.Player;

public class ChangeTurnCommand extends Command
{
    public ChangeTurnCommand(Player player)
    {
        super("ChangeTurn", player);
    }

    public ChangeTurnCommand()
    {
        super("ChangeTurn");
    }
}