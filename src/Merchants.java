import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class Merchants implements ObjectiveCard{
    private static final int SIZEX = 200;
    private static final int SIZEY = 350;
    private int x;
    private int y;
    private BufferedImage cardFace;
    
    public Merchants(int x2, int y2)
    {
        try {
            x = x2;
            y = y2;
            cardFace = ImageIO.read(Deck.class.getResource("/Images/KB-merchants.png"));
        }catch(Exception e) {
            System.out.println(e);
        }
    }

    public void scorePlayer(Board board, Player player) {

    }

    public void draw(Graphics g) {
        g.drawImage(cardFace, x, y, SIZEX, SIZEY, null);
    }
}
