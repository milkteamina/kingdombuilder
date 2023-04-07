import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


//just modding Harbor right now.
public class Harbor implements ExtraAction{

    private static final boolean doesItMove = true;
    private static final String extraActionType = "harbor";
    private static final int size = 6;

    private int x;
    private int y;
    private boolean isUsed;
    private BufferedImage image;

    public Harbor(int x, int y) {
        try {
            this.x = x;
            this.y = y;
            isUsed = false;
            image = ImageIO.read(Harbor.class.getResource("/Images/KB-harbor.png"));
        }
        catch (Exception e) {
            System.out.println("Harbor constructor failed due to IOException");
        }

    }
    public void setAvailableMoves(Board board, Player player, Hex hex){

    }

    public void draw(Graphics g) {
        g.drawImage(image, x, y, size, size, null);
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
