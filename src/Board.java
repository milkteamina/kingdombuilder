import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import javax.swing.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Board {

    public static final int BOARD_QUADRANT_SIZE = 100;
    private static final int boardX = 10;
    private static final int boardY = 10;

    private static final int hexagonShiftX = 6;
    private static final int offSetMarginX = hexagonShiftX / 2;
    private static final int hexagonShiftY = 4;
    /*
    index 0 of these arrays will be the top left corner of the hexagon
    check these values for accuracy later
     */
    private static final int[] startPointsX =
            {boardX, boardX + hexagonShiftX / 2, boardX + hexagonShiftX, boardX + hexagonShiftX, boardX + hexagonShiftX / 2, boardX};
    private static final int[] startPointsY =
            {boardY + 1, boardY, boardY + 1, boardY + hexagonShiftY, boardY + 1 + hexagonShiftY, boardY + hexagonShiftY};

    private File boardAsText;
    private ArrayList<Hex> allHexes;
    private Hex[][] hexes;
    private BufferedImage boardImageQuadrant1;
    private BufferedImage boardImageQuadrant2;
    private BufferedImage boardImageQuadrant3;
    private BufferedImage boardImageQuadrant4;


    /*
    Q1: Oasis
    Q2: Harbor
    Q3: Paddock
    Q4: Tavern
    0 = desert
    1 = water
    2 = mountain
    3 = flower
    4 = grass
    5 = forest
    6 = canyon
    7 = oasis
    8 = city
    9 = paddock
    10 = tavern
    11 = harbor
     */

    public Board(){

        try{
            boardAsText = new File("/Boards/defaultBoard.txt");
            Scanner sc = new Scanner(boardAsText);
            allHexes = new ArrayList<Hex>();
            hexes = new Hex[20][40];

            boardImageQuadrant1 = ImageIO.read(Board.class.getResource("/Images/KingdomBuilderBoard_Quadrant1.png"));
            boardImageQuadrant2 = ImageIO.read(Board.class.getResource("/Images/KingdomBuilderBoard_Quadrant2.png"));
            boardImageQuadrant3 = ImageIO.read(Board.class.getResource("/Images/KingdomBuilderBoard_Quadrant3.png"));
            boardImageQuadrant4 = ImageIO.read(Board.class.getResource("/Images/KingdomBuilderBoard_Quadrant4.png"));

            int[] tempPointsX = new int[6];
            int[] tempPointsY = new int[6];

            for(int i = 0; i < 20; i++){
                for(int j = 0; j < 40; j += 2){

                    if(i % 2 == 0 && j == 0) j += 1;

                    for (int k = 0; k < 6; k++){
                        tempPointsX[i] = startPointsX[i] + offSetMarginX * (i % 2) + hexagonShiftX * j / 2;
                        tempPointsY[i] = startPointsY[i] + i * hexagonShiftY;
                    }

                    switch (sc.next()){
                        //so it looks like assigning coordinates will absolutely suck. nice.
                        case "0":
                            hexes[i][j] = new BasicHex(tempPointsX, tempPointsY, null,  "desert");
                        case "1":
                            hexes[i][j] = new BasicHex(tempPointsX, tempPointsY, null, "water");
                        case "2":
                            hexes[i][j] = new BasicHex(tempPointsX, tempPointsY, null, "mountain");
                        case "3":
                            hexes[i][j] = new BasicHex(tempPointsX, tempPointsY, null, "flowers");
                        case "4":
                            hexes[i][j] = new BasicHex(tempPointsX, tempPointsY, null, "meadow");
                        case "5":
                            hexes[i][j] = new BasicHex(tempPointsX, tempPointsY, null, "forest");
                        case "6":
                            hexes[i][j] = new BasicHex(tempPointsX, tempPointsY, null, "canyon");
                        case "7":
                            hexes[i][j] = new ExtraActionHex(tempPointsX, tempPointsY, null, "oasis");
                        case "8":
                            hexes[i][j] = new BasicHex(tempPointsX, tempPointsY, null, "city");
                        case "9":
                            hexes[i][j] = new ExtraActionHex(tempPointsX, tempPointsY, null, "paddock");
                        case "10":
                            hexes[i][j] = new ExtraActionHex(tempPointsX, tempPointsY, null, "tavern");
                        case "11":
                            hexes[i][j] = new ExtraActionHex(tempPointsX, tempPointsY, null, "harbor");
                    }

                }
            }

            /*
            now that the array is filled, we can (attempt to) create the graph based on the array
            fill the Hex's ArrayList in the same order as its points are stored (top left start then go clockwise)
            {
            {1, 0, 2, 0, 3, 0, 4},
            {0, 5, 0, 6, 0, 7, 0},
            {7, 0, 8, 0, 9, 0, 10}
            }
            */

            ArrayList<Hex> tempNeighbors;

            for(int i = 0; i < 20; i++){
                for(int j = 0; j < 40; j += 2){
                    tempNeighbors = new ArrayList<Hex>();

                    if(i - 1 < hexes.length && i - 1 > 0 &&
                            j - 1 < hexes[i].length && j - 1 > 0){
                        tempNeighbors.add(hexes[i - 1][j - 1]);
                    } else{
                        //don't know if we should add null or add a hex that says "nothing"
                      tempNeighbors.add(null);
                    }
                    if(i - 1 < hexes.length && i - 1 > 0 &&
                            j + 1 < hexes[i].length && j + 1 > 0){
                        tempNeighbors.add(hexes[i - 1][j + 1]);
                    } else{
                        tempNeighbors.add(null);
                    }
                    if(i < hexes.length && i > 0 &&
                            j + 2 < hexes[i].length && j + 2 > 0){
                        tempNeighbors.add(hexes[i][j + 2]);
                    } else{
                        tempNeighbors.add(null);
                    }
                    if(i + 1 < hexes.length && i + 1 > 0 &&
                            j + 1 < hexes[i].length && j + 1 > 0){
                        tempNeighbors.add(hexes[i + 1][j + 1]);
                    } else{
                        tempNeighbors.add(null);
                    }
                    if(i + 1 < hexes.length && i + 1 > 0 &&
                            j - 1 < hexes[i].length && j - 1 > 0){
                        tempNeighbors.add(hexes[i + 1][j - 1]);
                    } else{
                        tempNeighbors.add(null);
                    }
                    if(i < hexes.length && i > 0 &&
                            j - 2 < hexes[i].length && j - 2 > 0){
                        tempNeighbors.add(hexes[i][j - 2]);
                    } else{
                        tempNeighbors.add(null);
                    }

                    hexes[i][j].setNeighbors(tempNeighbors);
                    allHexes.add(hexes[i][j]);
                }
            }

        } catch(Exception e){
            System.out.println(e);
        }
    }

    public Hex[] getRow(int row){
        return hexes[row];
    }

    public ArrayList<Hex> getAllHexes(){
        return allHexes;
    }

    /*a little torn about whether we should make the board image 1 image or multiple.
    * Leaning to multiple for now.
    * */

    public void drawBoard(Graphics g){
        //draw image of board
        g.drawImage(boardImageQuadrant2, boardX, boardY, BOARD_QUADRANT_SIZE, BOARD_QUADRANT_SIZE, null);
        g.drawImage(boardImageQuadrant1, boardX + BOARD_QUADRANT_SIZE, boardY, BOARD_QUADRANT_SIZE, BOARD_QUADRANT_SIZE, null);
        g.drawImage(boardImageQuadrant3, boardX, boardY + BOARD_QUADRANT_SIZE, BOARD_QUADRANT_SIZE, BOARD_QUADRANT_SIZE, null);
        g.drawImage(boardImageQuadrant4, boardX + BOARD_QUADRANT_SIZE, boardY + BOARD_QUADRANT_SIZE, BOARD_QUADRANT_SIZE, BOARD_QUADRANT_SIZE, null);

        //draw highlighted hexes
        for(int i = 0; i < allHexes.size(); i++){
            allHexes.get(0).draw(g);
        }


    }


}
