import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

//TODO - 1: Idea: isPlacable() is used only when doing basic settlement stuff

public class Hex {
    public static final int RADIUS = 3;
    private int x;
    private int y;
    private static final int settlementSpacingX = 1;
    private static final int settlementSpacingY = 1;
    private ArrayList<Hex> neighbors;
    private boolean isHighlighted;

    public Hex(int x, int y, ArrayList<Hex> neighbors){
        this.x = x;
        this.y = y;
        this.neighbors = neighbors;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void highlight(){
        isHighlighted = true;
    }

    public void unHighlights(){
        isHighlighted = false;
    }

    public boolean isPlacable(){
        //just exists?
        return false;
    }

    public boolean isClicked(int mouseX, int mouseY){
        return Math.sqrt(Math.pow((x - mouseX), 2) + Math.pow((y - mouseY), 2)) < RADIUS;
    }

    public ArrayList<Hex> getNeighbors(){
        return neighbors;
    }

    public void draw(Graphics g){
        if(isHighlighted){
            g.setColor(Color.RED);
            g.drawArc(x, y, RADIUS*2, RADIUS*2, 0, 360);
        }
    }

    public int getSettlementSpacingX(){
        return settlementSpacingX;
    }

    public int getSettlementSpacingY(){
        return settlementSpacingY;
    }




}
