import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Paddock implements ExtraAction{

    private int x;
    private int y;
    private boolean isUsed;
    private static final boolean doesItMove = true;
    private BufferedImage image;;

    public void setAvailableMoves(Board board, Player player, Hex hex){

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
