//TODO- check why this error is erroring

public class BasicHex extends Hex{

    private String terrainType;
    Settlement settlement;

    public BasicHex(String terrainType){
        super();
        this.terrainType = terrainType;
    }

    public void placeSettlement(Settlement settlement){
        this.settlement = settlement;
    }

    public String getTerrainType(){
        return terrainType;
    }
}
