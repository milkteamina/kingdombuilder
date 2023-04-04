import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Settlement {
    private Player owner;
    private BufferedImage image;

    public Settlement(Player player){
        try{
            owner = player;


        }
    }

    public Player getOwner(){
        return owner;
    }

    public void draw(Graphics g, int x, int y){

    }
}
