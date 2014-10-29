package sistDist.blackjack;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import sistDist.blackkack.command.AcceptCardCommand;
import sistDist.blackkack.command.StopCardsCommand;

/**
 *
 * @author rogeliotorres
 */
public class PlayerPanel extends JPanel {
    private String playerName;
    private JLabel lblPlayerName;
    ImagePanel imagePanel;
    SocketThread socketThread;
    

    public PlayerPanel(String playerName){
        this.setOpaque(false);
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setBorder(BorderFactory.createLineBorder(Color.decode("#F7DF7B")));

        this.playerName = playerName;
        lblPlayerName = new JLabel(constructPlayerNameFormat(playerName), SwingConstants.CENTER);
        lblPlayerName.setBackground(Color.RED);
        this.add(lblPlayerName);
        
        imagePanel = new ImagePanel();
        this.add(imagePanel);
    }
    
    public void setPlayerName(String playerName){
        this.playerName = playerName;
        lblPlayerName.setText(constructPlayerNameFormat(playerName));
    }
    
    public void setNewCard(String value, String type){
        imagePanel.addImage("images/Playing_card_"+type+"_"+value+".png");
    }
    
    public void setTurn(){
        this.lblPlayerName.setText("<html><div style=\"color:#ffffff; background:red; font-size:1.2em; width:100%;\">"+this.playerName+"</div></html>");
    }
    
    public void quitTurn(){
        lblPlayerName.setText(constructPlayerNameFormat(this.playerName));
    }
    
    public void changeCard(String value, String type, int position){
    	imagePanel.changeImage("images/Playing_card_"+type+"_"+value+".png", position);
    }
    
    public void addButtons(SocketThread socketThread, Player player){
    	JButton btnPlus = new JButton("+");
    	btnPlus.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				AcceptCardCommand acceptCardCommand = new AcceptCardCommand();
				acceptCardCommand.setPlayer(player);
				socketThread.sendCommand(acceptCardCommand.getMetadata());
			}
    	});
    	JButton btnStop = new JButton("O");
    	btnStop.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				StopCardsCommand stopCardsCommand =  new StopCardsCommand();
				stopCardsCommand.setPlayer(player);
				socketThread.sendCommand(stopCardsCommand.getMetadata());
			}
    	});
    	this.add(btnPlus);
    	this.add(btnStop);
    }
    
    private String constructPlayerNameFormat(String playerName){
        return "<html><div style=\"color:#ffffff; font-size:1.2em; width:100%; display:block; \">" + playerName + "</div></html>";
    }
}