import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Oasis implements ExtraAction{

    private int x;
    private int y;
    private boolean isUsed;
    private static final boolean doesItMove = false;
    private BufferedImage image;;

    public void setAvailableMoves(Board board, Player player){
        
            for(Hex h: board.getAllHexes()){
                if(h.getType().equals("desert")  && h.getSettlement() == null){
                    boolean canPlace = false;
                    for(int i = 0; i<h.getNeighbors.size(); i++){
                        if(h.getNeighbors.get(i).getType().equals("desert") && h.getNeighbors.get(i).getSettlement() != null){
                            canPlace = true;
                            break;
                        }
                            
                    }
                    h.highlight();
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
