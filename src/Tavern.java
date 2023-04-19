import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Tavern implements ExtraAction{

    private int x;
    private int y;
    private boolean isUsed;
    private static final boolean doesItMove = false;
    private BufferedImage image;;

    public void setAvailableMoves(Board board, Player player){
                //probably not the best way to do this 
        for(Hex h: board.getAllHexes()){
             if(h.getSettlement() == null){//looks at all the free hexes
              for(Hex i: h.getNeighbors()){
                if(i.getSettlement() != null){ // starts the 3 settlement chain 
                  for(Hex j: i.getNeighbors()){
                    if(j.getSettlement() != null){ // checks for the second settlement
                        for(Hex k : j.getNeighbors()){
                         if(k.getSettlement() != null){ //checks for a third connected settlement
                            if(h.highlight()== false){
                                h.highlight();
                            }
                         }
                        }
                    }
                  }
                }
              }
                 
             }  
             
          }
    }

    @Override
    public void draw(Graphics g) {

    }

    @Override
    public boolean isUsed() {
        return isUsed;
    }

    @Override
    public boolean doesItMove() {
        return doesItMove;
    }

    @Override
    public void reset() {
        isUsed = false;
    }


}
