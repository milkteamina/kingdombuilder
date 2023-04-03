import java.util.ArrayList;

public class Hex {
   public static final int RADIUS;
   private int x;
   private int y;
   private int settlementSpacingX;
   private int settlementSpacingY;
   ArrayList<Hex> neighbors;
   private boolean isHighlighted;

   public int getX(){
    return x;
   }
   public int getY(){
    return y;
   }
   public void highlight(){
    isHighlighted = true;
   }
   public void unhighlight(){
    isHighlighted = false;
   }
   public boolean isClicked(int mouseX, int mouseY){
    return false;
   }
   public boolean isPlaceable(){
    return false;
   }
   public void draw(Graphics2D graphics){

   }
   public ArrayList<Hex> getNeighbors(){
    return neighbors;
   }
    
}
