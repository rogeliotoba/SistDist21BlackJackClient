package sistDist.blackkack.command;

import sistDist.blackjack.Player;

public class NewUserCommand extends Command{

    public NewUserCommand(Player player){
        super("NewUser", player);
    }
    
    public NewUserCommand() {
        super("NewUser");
    }
    
}
