import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
public class TerrainCard {
    private String terrainType;
    private BufferedImage cardFace;
    public void draw(Graphics2D graphics, int x, int y){

    }
    public String getTerrain(){
        return terrainType;
    }
}
/*-String terrainType 
-BufferedImage cardFace 

Methods
+ void draw(Graphics2D graphics, int x, int y)
draws cardFace
+ String getTerrain()
returns terrainType
 */
