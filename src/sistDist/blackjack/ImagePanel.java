package sistDist.blackjack;
/**
 *
 * @author rogeliotorres
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{

    private BufferedImage[] images;
    private int imageCount = 0;

    public ImagePanel(){
       images  =new BufferedImage[5];
        
       this.setOpaque(false);
    }
    
    public void addImage(String path){
        if(imageCount<5){
            try {
                images[imageCount] = ImageIO.read(new File(path));
                imageCount++;
                this.paintComponent(this.getGraphics());
            } catch (IOException ex) {
            }
        }
    }
    
    public void changeImage(String path, int position){
    	try {
    		images[position] = ImageIO.read(new File(path));
    		this.paintComponent(this.getGraphics());
    	}
    	catch (IOException ex){
    	}
    	catch(IndexOutOfBoundsException ex2){
    		
    	}
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int x=0; x<imageCount; x++){
            g.drawImage(images[x], (this.getWidth()/10), (x*(this.getHeight()/13))+10, (this.getWidth()/10)*8, (this.getHeight()/2), null);
        }
    }

}