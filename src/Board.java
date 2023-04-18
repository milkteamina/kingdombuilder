import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Board {

    public static final int BOARD_SIZE = 200;
    private ArrayList<Hex> allHexes;
    private Hex[][] hexes;
    private BufferedImage boardImage;
    private int x;
    private int y;

    //?
    public Board(){

    }

    public Hex[] getRow(int row){

    }

    public ArrayList<Hex> getAllHexes(){

    }

    public void drawBoard(Graphics g){

    }

    public void SetMandatorySettlementHexes(Player p)
    {
        TerrainCard c = p.getCard();
        boolean settleAnywhere = true;
        for(Hex x : allHexes)
        {
            if(!x.isSettled() && x.getType().equals(c.getTerrainType()))
            {
                Arraylist<Hex> neighbors = x.getNeighbors();
                for(Hex y : neighbors)
                    if(y.getSettlement().getOwner().getId() == p.getId())
                        x.highlight();
            }
        }
        if(settleAnywhere)
        {
            for(Hex z : allHexes) {
                if(!z.isSettled() && z.getType().equals(c.getTerrainType()))
                    z.highlight();
            }
        }
    }

}
