package sistDist.blackkack.command;

import sistDist.blackjack.Player;

public class RegisterCommand extends Command
{

    public RegisterCommand(Player player)
    {
        super("Register", player);
    }
    
    public RegisterCommand()
    {
        super("Register");
    }
    
}
