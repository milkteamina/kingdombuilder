import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Harbor implements ExtraAction{

    private static final boolean doesItMove = true;
    private static final String extraActionType = "harbor";

    private int x;
    private int y;
    private boolean isUsed;
    private BufferedImage image;

    public Harbor(int x, int y) {
        try {
            this.x = x;
            this.y = y;
            isUsed = false;
            image = ImageIO.read(Harbor.class.getResource("/Images/KB-harbor.png"));
        }
        catch (Exception e) {
            System.out.println(e);
        }

    }
    public void setAvailableMoves(Board board, Player player, Hex hex){
        //probably not the best way to do this 
       /* for(Hex h: board.getAllHexes()){
             if(h.getSettlement() == null){//looks at all the free hexes
              for(Hex i: h.getNeighbors()){
                if(i.getSettlement() != null){ // starts the 3 settlement chain 
                  for(Hex j: i.getNeighbors()){
                    if(j.getSettlement() != null){ // checks for the second settlement
                        for(Hex k : j.getNeighbors()){
                         if(k.getSettlement() != null){ //checks for a third connected settlement
                            h.highlight();   
                         }
                        }
                    }
                  }
                }
              }
                 
             }  
             
          }*/
         
    }

    public void draw(Graphics g) {

    }

    public boolean isUsed() {
        return isUsed;
    }

    public boolean doesItMove() {
        return doesItMove;
    }

    public String getExtraActionType(){
        return extraActionType;
    }

    public void reset() {
        isUsed = false;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }


}
