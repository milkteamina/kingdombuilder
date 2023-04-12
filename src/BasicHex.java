import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.*;

public class BasicHex extends Hex{

    private String terrainType;
    private Settlement settlement;

    public BasicHex(int[] pointsX, int[] pointsY, ArrayList<Hex> neighbors, String terrainType){
        super(pointsX, pointsY, neighbors);
        this.terrainType = terrainType;
    }

    //make sure there are no reference errors
    public void placeSettlement(Settlement s){
        settlement = s;
    }

    public String getTerrainType() {
        return terrainType;
    }

    public boolean isPlacable(){
        /*used only for checking suitable hexes when placing mandatory settlements because ExtraAction
        hexes have their own methods for setting eligible hexes*/

        return settlement == null;
    }

    public void draw(Graphics g){
        if(settlement != null){
            settlement.draw(g, super.getPointsX()[0] + super.getSettlementSpacingX(), super.getPointsY()[0] + super.getSettlementSpacingY());
        }
    }

}
