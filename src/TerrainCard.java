import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
public class TerrainCard {
    private String terrainType;
    private BufferedImage cardFace;
    private static final int sizeX = 100;
    private static final int sizeY = 50;

    public TerrainCard(String terrainType){
        this.terrainType = terrainType;
    }
    public void draw(Graphics g, int x, int y){

    }

    public String getTerrainType(){
        return terrainType;
    }

    public static int getSizeX(){
        return sizeX;
    }

    public static int getSizeY(){
        return sizeY;
    }
}
