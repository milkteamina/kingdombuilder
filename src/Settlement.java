import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Settlement {

    private Player owner;
    private BufferedImage image;
    private static final int imageSizeX = 20;
    private static final int imageSizeY = 20;

    public Settlement(Player player){
        try{
            owner = player;

            if(player.getId() == 0){
                image = ImageIO.read(Settlement.class.getResource("/Images/KB-Player1Settlement.png"));
            } else if(player.getId() == 1){
                image = ImageIO.read(Settlement.class.getResource("/Images/KB-Player2Settlement.png"));
            } else if(player.getId() == 2){
                image = ImageIO.read(Settlement.class.getResource("/Images/KB-Player3Settlement.png"));
            } else if(player.getId() == 3){
                image = ImageIO.read(Settlement.class.getResource("/Images/KB-Player4Settlement.png"));
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public Player getOwner(){
        return owner;
    }

    public void draw(Graphics g, int x, int y){
        g.drawImage(image, x, y, imageSizeX, imageSizeY, null);
    }
}
