package sistDist.blackjack;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author rogeliotorres
 */

public class MainGui extends JFrame
{

    private Player currentPlayer;
    
    public MainGui()
    {
        super("21");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.decode("#5A9C78"));
        this.setSize(800,800);
        
        GridLayout mainLayout = new GridLayout(1,5);
        this.setLayout(mainLayout);
    }
    
    public void addPlayer(Player player){
    	this.add(player.getPlayerPanel());
        this.revalidate();
    }
    
    public void setPlayerTurn(Player player){
        if(currentPlayer!=null) currentPlayer.getPlayerPanel().quitTurn();
        this.currentPlayer = player;
        this.currentPlayer.getPlayerPanel().setTurn();
    }
    
    public void setCardToPlayer(Player player, String value, String type){
    	System.out.println("MainGui: setCardToPlayer - value:"+value+" - type:"+type);
        player.getPlayerPanel().setNewCard(value, type);
    }
    
    public void changeCardToPlayer(Player player, String value, String type, int position){
    	player.getPlayerPanel().changeCard(value, type, position);
    }
}