package sistDist.blackjack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;

import sistDist.blackkack.command.*;

public class SocketThread extends Thread {
	private List<Player> players = new ArrayList<>();
	private PrintWriter out;
	private BufferedReader in;
	private Socket socket;
	String HOST;
	int PORT;
	String username;
	MainGui gui;
	
	public SocketThread(Main main, String HOST, int PORT, String username, MainGui gui){
		this.HOST = HOST;
		this.PORT = PORT;
		this.username = username;
		this.gui = gui;
		
        Player crupier = new Player("Dealer");
        Player player = new Player(username);
        player.getPlayerPanel().addButtons(this, player);
        
        players.add(crupier);
        players.add(player);
        
        gui.addPlayer(crupier);
        gui.addPlayer(player);
        
    	//Create the socket
    	try{
        	socket = new Socket(HOST, PORT);
        	out = new PrintWriter(socket.getOutputStream(),
                        true);
            in = new BufferedReader(new InputStreamReader(
                       socket.getInputStream()));
        } catch (UnknownHostException e) {
            System.out.println("Unknown host: kq6py");
            System.exit(1);
        } catch  (IOException e) {
            System.out.println("No I/O");
            System.exit(1);
        }
    	
        //Register to game
        out.println(new RegisterCommand(player).getMetadata());
	}
	
	public void sendCommand(String command){
		out.println(command);
	}
	
    public void run() {
        //Wait for orders
        while(true){
        	String stringCommand;
			try {
				stringCommand = in.readLine();
				if(stringCommand!=null){
					System.out.println(stringCommand);
					String commandType = CommandInterpreter.getAttribute(stringCommand, "commandType");
					switch(commandType){
						case "AcceptCard":
							AcceptCardCommand acceptCardCommand = (AcceptCardCommand) CommandInterpreter.getCommand(stringCommand);
							break;
						
						case "AssignCard":
							AssignCardCommand assignCardCommand = new AssignCardCommand();

							Card card = new Card();
							card.setType(CommandInterpreter.getAttribute(stringCommand, "cardType"));
							card.setValue(CommandInterpreter.getAttribute(stringCommand, "cardValue"));
							
							assignCardCommand.setCard(card);
							
							String playerUsername = CommandInterpreter.getAttribute(stringCommand, "username");

							//get the player
							for(Player p:players){
								if(p.getPlayerName().equalsIgnoreCase(playerUsername)){
									gui.setCardToPlayer(p, card.getValue().toLowerCase(), card.getType().toLowerCase());
								}
							}
							break;
							
						case "ChangeTurn":
							String username = CommandInterpreter.getAttribute(stringCommand, "username");
							for(Player player:players){
								if(player.getPlayerName().equalsIgnoreCase(username)){
									gui.setPlayerTurn(player);
								}
							}
							break;

						case "NewUser":
							String newUserUsername = CommandInterpreter.getAttribute(stringCommand, "username");
							Player newPlayer = new Player(newUserUsername);
							players.add(newPlayer);
							gui.addPlayer(newPlayer);
							break;
							
						case "PlayerLoose":
							String looserUsername = CommandInterpreter.getAttribute(stringCommand, "username");
							for(Player player:players){
								if(player.getPlayerName().equalsIgnoreCase(looserUsername)){
									player.getPlayerPanel().setPlayerName(looserUsername+" - Pierde");
								}
							}
							break;
							
						case "PlayerWin":
							String winerUsername = CommandInterpreter.getAttribute(stringCommand, "username");
							for(Player player:players){
								if(player.getPlayerName().equalsIgnoreCase(winerUsername)){
									player.getPlayerPanel().setPlayerName(winerUsername+" - Gana");
								}
							}
							break;
					}
				}
				else{
					this.stop();
				}
		
			} catch (IOException e) {
				//Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
}
