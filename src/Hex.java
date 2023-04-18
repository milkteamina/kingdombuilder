import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Hex {

    private static final int settlementSpacingX = 4;
    private static final int settlementSpacingY = 1;

    /*
    index 0 of these arrays will be the top left corner of the hexagon
    this is done because it will make it easy to draw the settlement
     */
    private int[] pointsX;
    private int[] pointsY;
    private ArrayList<Hex> neighbors;
    private boolean isHighlighted;
    private Settlement settlement;

    public Hex(int[] pointsX, int[] pointsY, ArrayList<Hex> neighbors){

        this.pointsX = new int[6];
        this.pointsY = new int[6];
        //scuffed lol
        this.neighbors = null;

        for(int i = 0; i < 6; i++){
            this.pointsX[i] = pointsX[i];
            this.pointsY[i] = pointsY[i];
        }


        isHighlighted = false;
        settlement = null;
    }

    public int[] getPointsX(){
        return pointsX;
    }

    public int[] getPointsY(){
        return pointsY;
    }

    public void highlight(){
        isHighlighted = true;
    }

    public void unHighlight(){
        isHighlighted = false;
    }

    public boolean isSettled(){
        //just exists?
        return true;
    }

    /*written by chatGPT lol. Dk if it works but it 99% should.
    update: LMAO IT WORKS PERFECTLY
    * */
    public boolean isClicked(int mouseX, int mouseY) {
        int intersections = 0;

        for (int i = 0; i < pointsX.length; i++) {
            double x1 = pointsX[i];
            double y1 = pointsY[i];
            double x2 = pointsX[(i + 1) % pointsX.length];
            double y2 = pointsY[(i + 1) % pointsY.length];

            if (((y1 > mouseY) != (y2 > mouseY))
                    && (mouseX < (x2 - x1) * (mouseY - y1) / (y2 - y1) + x1)) {
                intersections++;
            }
        }

        return (intersections % 2 != 0);
    }

    public ArrayList<Hex> getNeighbors(){
        return neighbors;
    }

    public void setNeighbors(ArrayList<Hex> n){
        neighbors = new ArrayList<>(n);
    }

    public void draw(Graphics g){
        if(isHighlighted){
            g.setColor(Color.RED);
            g.drawPolygon(pointsX, pointsY, 6);
        }
    }

    public int getSettlementSpacingX(){
        return settlementSpacingX;
    }

    public int getSettlementSpacingY(){
        return settlementSpacingY;
    }


    public void placeSettlement(Settlement s){}
    public Settlement getSettlement(){
        return settlement;
    }

    public String getType (){
        return "nothing";
    }

    public boolean isHighlighted(){return isHighlighted;}

}



