 import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class ScoreCards implements ObjectiveCard{
    private static final int SIZEX = 200;
    private static final int SIZEY = 350;
    private int x;
    private int y;
    private BufferedImage minersFace;
    private BufferedImage merchantsFace;
    private BufferedImage knightsFace;
    private int cardSpacingX;
    
    public ScoreCards(int x2, int y2)
    {
        try {
            x = x2;
            y = y2;
            minersFace = ImageIO.read(Deck.class.getResource("/Images/KB-miners.png"));
            knightsFace = ImageIO.read(Deck.class.getResource("/Images/KB-knights.png"));
            merchantsFace = ImageIO.read(Deck.class.getResource("/Images/KB-merchants.png"));
        }catch(Exception e) {
            System.out.println(e);
        }
    }

    public int minerScore(Board board, Player player) {
        int score = 0;
        ArrayList<Hex> allHexes = board.getAllHexes();
        for(Hex x : allHexes)
        {
            if(x.getSettlement().getOwner().getId() == player.getId())
            {
                ArrayList<Hex> neighborHexes = x.getNeighbors();
                for(Hex i : neighborHexes)
                    if(i.getTerrainType().equals("mountain"))
                        score += 1;
            }
        }
        return score;
    }
    
    public int merchantScore(Board board, Player player) {
        int score = 0;
        return score;
    }
    
    public int knightScore(Board board, Player player) {
        int score = 0; 
        ArrayList<Hex> allHexes = board.getAllHexes();
        for(int x = 0; x < 20; x++)
        {
            int tempScore = 0;
            for(int y = 0; x < 20; y++)
            {
                if(allHexes.get((x*20)+y).getSettlement().getOwner().getId() == player.getId())
                    tempScore+=2;
            }
            score = Math.max(tempScore, score);
        }
        return score;
    }

    public void draw(Graphics g) {
        g.drawImage(minersFace, x, y, SIZEX, SIZEY, null);
        g.drawImage(merchantsFace, x+cardSpacingX, y, SIZEX, SIZEY, null);
        g.drawImage(knightsFace, x+(2 * cardSpacingX), y, SIZEX, SIZEY, null);
    }
}
