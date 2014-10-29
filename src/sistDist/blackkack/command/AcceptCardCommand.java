package sistDist.blackkack.command;

import sistDist.blackjack.Player;

public class AcceptCardCommand extends Command
{
    public AcceptCardCommand(Player player)
    {
        super("AcceptCard", player);
    }

    public AcceptCardCommand()
    {
        super("AcceptCard");
    }
}