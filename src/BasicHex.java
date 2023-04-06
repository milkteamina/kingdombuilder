import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class BasicHex extends Hex{

    private String terrainType;
    private Settlement settlement;

    public BasicHex(int x, int y, ArrayList<Hex> neighbors, String terrainType){
        super(x, y, neighbors);
        this.terrainType = terrainType;
    }

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
            settlement.draw(g, super.getX() + super.getSettlementSpacingX(), super.getY() + super.getSettlementSpacingY());
        }
    }
}
