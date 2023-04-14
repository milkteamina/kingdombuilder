import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class Oasis implements ExtraAction{

    private static final boolean doesItMove = false;
    private static final String extraActionType = "oasis";

    private int x;
    private int y;
    private boolean isUsed;
    private BufferedImage image;

    public Oasis(int x, int y) {
        try {
            this.x = x;
            this.y = y;
            isUsed = false;
            image = ImageIO.read(Harbor.class.getResource("/Images/KB-oasis.png"));
        }
        catch (Exception e) {
            System.out.println("Oasis constructor failed due to IOException");
        }

    }
    public void setAvailableMoves(Board board, Player player){

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


}
