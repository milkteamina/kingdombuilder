import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;



public class Hex {
//    public static final int RADIUS = ?;
    private int x;
    private int y;
    private int settlementSpacingX;
    private int settlementSpacingY;
    private ArrayList<Hex> neighbors;
    private boolean isHighlighted;

    public Hex(){

    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void highlight(){
        //WHAT THE FUCK
    }

    public boolean isPlacable(){
        //just exists?
    }

    public void draw(Graphics g){

    }

    public ArrayList<Hex> getNeighbors(){
        return neighbors;
    }


}
