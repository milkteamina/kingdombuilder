import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
public class Settlement {
    private Player owner;
    private BufferedImage image;
    public Settlement(Player p, BufferedImage i){
        owner = p;
        image = i;
    }
    public Player getOwner(){
        return owner;
    }
    public void draw(Graphics2D graphics, int x, int y){

    }

}
/*Variables
-Player owner
-BufferedImage image

Methods
+Player getOwner()
returns owner
+ void draw(Graphics2D graphics, int x, int y)
draws based on x and y, passed in by hex class
 */
