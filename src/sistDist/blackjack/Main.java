package sistDist.blackjack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import sistDist.blackkack.command.RegisterCommand;

/**
 *
 * @author rogeliotorres
 */
public class Main {
	public final static int PORT = 32669;
	public final static String HOST = "148.239.63.21";
	private MainGui gui;
	
	public Main(){
		InitGui initGui = new InitGui(this);
	}
	
	public void init(String username){
        gui = new MainGui();
        gui.setVisible(true);
        
        SocketThread socketThread = new SocketThread(this, HOST, PORT, username, gui);
        socketThread.start();
	}

    public static void main(String[] args) {
    	Main main = new Main();
    	Main main2 = new Main();
    }
}
