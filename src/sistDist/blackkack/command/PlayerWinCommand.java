package sistDist.blackkack.command;

import sistDist.blackjack.Player;

/**
*
* @author Armando
*/
public class PlayerWinCommand extends Command
{
   
   public PlayerWinCommand(Player player)
   {
       super("PlayerWin", player);
   }
   
   public PlayerWinCommand()
   {
       super("PlayerWin");
   }
}
