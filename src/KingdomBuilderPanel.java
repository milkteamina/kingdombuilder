import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import javax.swing.*;

public class KingdomBuilderPanel extends JPanel implements MouseListener{

    private Gamestate g;
    private BufferedImage background;
    private int objectiveCardSpacing;

    //testing variables
    private Board b;
    private boolean hasConstructed;

    public KingdomBuilderPanel() {
         try{
           background = ImageIO.read(KingdomBuilderPanel.class.getResource("/Images/background.png"));
           b = new Board();
           hasConstructed = true;
           System.out.println("constructed");
        } catch(Exception e){
            System.out.println(e);
        }
    }

    public void paint(Graphics g) {
        if(hasConstructed){
            g.clearRect(0, 0, getWidth(), getHeight()); //so panel doesn't get fucked up
            g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
            b.drawBoard(g);

            System.out.println(b.debugString());
        }
    }

    public void drawObjectiveCards(Graphics g) {

    }

    public void drawScoring(Graphics g) {

    }

    public void drawDeck(Graphics g) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        g.playBasedOnState(e.getX(), e.getY());
        repaint();

    }

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e){}

    public void mouseExited(MouseEvent e) {}

}
