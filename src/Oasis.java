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
