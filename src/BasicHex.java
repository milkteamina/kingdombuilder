import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class BasicHex extends Hex{

    private final String terrainType;
    private Settlement settlement;

    public BasicHex(int[] pointsX, int[] pointsY, ArrayList<Hex> neighbors, String terrainType){
        super(pointsX, pointsY, neighbors);
        this.terrainType = terrainType;
    }

    public void placeSettlement(Settlement s){
        //make sure there are no reference errors
        settlement = s;
    }

    public String getType() {
        return terrainType;
    }

    public boolean isSettled(){
        return settlement != null;
    }

    public void draw(Graphics g){
        super.draw(g);
        if(settlement != null){
            settlement.draw(g, super.getPointsX()[0] + super.getSettlementSpacingX(), super.getPointsY()[0] + super.getSettlementSpacingY());
        }
    }

}
