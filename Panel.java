import javax.swing.JPanel;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;


public class Panel extends JPanel {
    private BufferedImage img, workers, lords, citizens, discPile;
    public Panel(){
        try{
            img = ImageIO.read(new File("background.jpg"));
            citizens = ImageIO.read(new File("CitizensObjective.png"));
            lords = ImageIO.read(new File("LordsObjective.png"));
        }
        catch(Exception E){
            System.out.println(E);
        }
    }
public void paint(Graphics g)
{   g.drawImage(img, 0, 0, null);
    g.drawImage(citizens, 100, 100, 100, 150, null);
    g.drawImage(lords, 210, 100, 100, 150, null);
    
}
}

