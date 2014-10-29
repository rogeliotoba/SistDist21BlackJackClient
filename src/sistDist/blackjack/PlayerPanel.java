package sistDist.blackjack;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author rogeliotorres
 */
public class PlayerPanel extends JPanel {
    private String playerName;
    private JLabel lblPlayerName;
    ImagePanel imagePanel;
    

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
    
    private String constructPlayerNameFormat(String playerName){
        return "<html><div style=\"color:#ffffff; font-size:1.2em; width:100%; display:block; \">" + playerName + "</div></html>";
    }
}