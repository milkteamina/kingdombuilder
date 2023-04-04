import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class BasicHex extends Hex{

    private String terrainType;
    Settlement settlement;

    public BasicHex(int x, int y, ArrayList<Hex> neighbors, String terrainType){
        super(x, y, neighbors);
        this.terrainType = terrainType;
    }

    public void placeSettlement(Settlement settlement){
        this.settlement = settlement;
    }

    public String getTerrainType() {
        return terrainType;
    }

    public boolean isPlacable(){
        /*used only for checking suitable hexes when placing mandatory settlements because extraaction
        hexes have their own methods for setting eligible hexes*/

        if(settlement != null){
            return false;
        } return true;
    }

    public void draw(Graphics g){
        if(settlement != null){
            settlement.draw(g, getX() + getSettlementSpacingX(), getY() + getSettlementSpacingY());
        }
    }
}
