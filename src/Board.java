import java.awt.*;
import java.util.ArrayList;
import java.io.*;
import javax.swing.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Board {

    public static final int BOARD_SIZE = 200;
    private File boardAsText;
    private ArrayList<Hex> allHexes;
    private Hex[][] hexes;
    private BufferedImage boardImageQuadrant1;
    private BufferedImage boardImageQuadrant2;
    private BufferedImage boardImageQuadrant3;
    private BufferedImage boardImageQuadrant4;
    private int x;
    private int y;

    //?
    public Board(File board, int x, int y){
        try(){

        }
    }

    public Hex[] getRow(int row){

    }

    public ArrayList<Hex> getAllHexes(){

    }

    /*a little torn about whether we should make the board image 1 image or multiple.
    * Leaning to multiple for now.
    * */

    public void drawBoard(Graphics g){

    }


}
