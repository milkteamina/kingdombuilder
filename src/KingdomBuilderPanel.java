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
    private BufferedImage miners;
    private BufferedImage knights;
    private BufferedImage merchants;
    private BufferedImage cardBack;
    private Deck deck;

    public KingdomBuilderPanel() {
         try{
           background = ImageIO.read(KingdomBuilderPanel.class.getResource("/Image/background.png");
           miners = ImageIO.read(KingdomBuilderPanel.class.getResource("/Image/KB-miners.png");
           knights = ImageIO.read(KingdomBuilderPanel.class.getResource("/Image/KB-knights.png");
           merchants = ImageIO.read(KingdomBuilderPanel.class.getResource("/Image/KB-merchants.png");
           cardBack = ImageIO.read(KingdomBuilderPanel.class.getResource("/Image/KB-Card-Back.png");
        } catch(Exception e){
            System.out.println(e);
        }
    }

    public void paint(Graphics g) {
        g.clearRect(0, 0, getWidth(), getHeight()); //so panel doesn't get fucked up
        g.drawImage(background, 0, 0, null);
    }

    public void drawObjectiveCards(Graphics g) {
        g.drawImage(miners, 50, 50, 100, 150, null);
        g.drawImage(knights, 165, 50, 100, 150, null);
        g.drawImage(merchants, 280, 50, 100, 150, null);
       
    }

    public void drawScoring(Graphics g) {

    }

    public void drawDeck(Graphics g) {
       deck.draw();
       
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
