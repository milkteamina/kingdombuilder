import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class Tavern implements ExtraAction{

    private static final boolean doesItMove = false;
    private static final String extraActionType = "tavern";

    private int x;
    private int y;
    private boolean isUsed;
    private BufferedImage image;

    public Tavern(int x, int y) {
        try {
            this.x = x;
            this.y = y;
            isUsed = false;
            image = ImageIO.read(Tavern.class.getResource("/Images/KB-tavern.png"));
        }
        catch (Exception e) {
            System.out.println("Tavern constructor failed due to IOException");
        }

    }
    public void setAvailableMoves(Board board, Player player, Hex hex){

    }

    public void draw(Graphics g) {
        g.drawImage(image, x, y, sizeX, sizeY, null);
    }

    public boolean isClicked(int mouseX, int mouseY){
        return mouseX > x && mouseX < x + sizeX && mouseY > y && mouseY < y + sizeY;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public boolean doesItMove() {
        return doesItMove;
    }

    public String getExtraActionType(){
        return extraActionType;
    }

    public void reset() {
        isUsed = false;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }


    public ExtraAction copy() {
        /*because the ExtraAction will be used for setting purposes
         making its coords messed up should do no harm
         */
        return new Tavern(-1, -1);
    }
}
