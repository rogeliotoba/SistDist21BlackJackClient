package sistDist.blackjack;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InitGui extends JFrame{
	JLabel jlabel;
	JTextField txtUsername;
	JButton btnOk;
	Main main;
	InitGui initGui;
	
	public InitGui(Main main){
		super("21");
		initGui = this;
		this.main = main;
		
		this.setLayout(new GridLayout(0,3));
		
		jlabel = new JLabel("username");
		this.add(jlabel);
		
		txtUsername = new JTextField();
		txtUsername.setSize(200, 100);
		this.add(txtUsername);
		
		btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(txtUsername.getText().trim().length()>0){
					main.init(txtUsername.getText());
					initGui.setVisible(false);
					//initGui.dispose();
				}
			}
		});
		this.add(btnOk);
		
		this.setVisible(true);
		
		this.pack();
	}

}
