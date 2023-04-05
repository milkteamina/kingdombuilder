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

    public void setAvailableMoves(Board board, Player player, Hex hex){

    }

    public void draw(Graphics g) {

    }

    public boolean isUsed() {
        return isUsed;
    }

    public boolean doesItMove() {
        return doesItMove;
    }

    public void reset() {
        isUsed = false;
    }


}
