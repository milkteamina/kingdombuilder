import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Board {

    //DO NOT MODIFY THESE CONSTANTS PLEASEEEEEEEEEEEEEEEEEeee
    public static final int BOARD_QUADRANT_SIZE_X = 305;
    public static final int BOARD_QUADRANT_SIZE_Y = 290;
    private static final int boardX = 10;
    private static final int boardY = 800 / 2 - 290 + 50;
    private static final int boardAdjustX = 14;
    private static final int boardAdjustY = 9;

    private static final int hexagonShiftX = 29;
    private static final int offSetMarginX = hexagonShiftX / 10;
    private static final int hexagonShiftOffBoardY = 9;
    private static final int hexagonShiftY = 28;
    /*
    index 0 of these arrays will be the top left corner of the hexagon
    check these values for accuracy later
     */
    private static final int[] startPointsX =
            {boardX, boardX + hexagonShiftX / 2, boardX + hexagonShiftX, boardX + hexagonShiftX, boardX + hexagonShiftX / 2, boardX};
    private static final int[] startPointsY =
            {boardY + hexagonShiftOffBoardY, boardY, boardY + hexagonShiftOffBoardY, boardY + hexagonShiftY, boardY + hexagonShiftOffBoardY + hexagonShiftY, boardY + hexagonShiftY};

    private ArrayList<Hex> allHexes;
    public Hex[][] hexes;
    private BufferedImage boardImageQuadrant1;
    private BufferedImage boardImageQuadrant2;
    private BufferedImage boardImageQuadrant3;
    private BufferedImage boardImageQuadrant4;
    private ArrayList<BufferedImage> images;


    /*
    Q1: Has oasis
    Q2: Has harbor
    Q3: Has paddock
    Q4: Has tavern
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

            File quad1 = new File("src/Boards/quad1.txt");
            File quad2 = new File("src/Boards/quad2.txt");
            File quad3 = new File("src/Boards/quad3.txt");
            File quad4 = new File("src/Boards/quad4.txt");
            Scanner sc1 = new Scanner(quad1);
            Scanner sc2 = new Scanner(quad2);
            Scanner sc3 = new Scanner(quad3);
            Scanner sc4 = new Scanner(quad4);

            ArrayList<Integer> quads = new ArrayList();
                quads.add(1); quads.add(2); quads.add(3); quads.add(4); 
            ArrayList<String> quadrants = new ArrayList(); 
            for(int m = 0; m < 4; m++) {
            int rand = (int)(Math.random()*(4-m)); 

            if(quads.get(rand) == 1) {while(sc1.hasNext()) quadrants.add(sc1.next()); images.add(boardImageQuadrant1);}
            if(quads.get(rand) == 2) {while(sc2.hasNext()) quadrants.add(sc2.next()); images.add(boardImageQuadrant2);}
            if(quads.get(rand) == 3) {while(sc3.hasNext()) quadrants.add(sc3.next()); images.add(boardImageQuadrant3);} 
            if(quads.get(rand) == 4) {while(sc4.hasNext()) quadrants.add(sc4.next()); images.add(boardImageQuadrant4);}
            quads.remove(rand);}

            allHexes = new ArrayList<>();
            hexes = new Hex[20][40];

            boardImageQuadrant1 = ImageIO.read(Board.class.getResource("/Images/KingdomBuilderBoard_Quadrant1.png"));
            boardImageQuadrant2 = ImageIO.read(Board.class.getResource("/Images/KingdomBuilderBoard_Quadrant2.png"));
            boardImageQuadrant3 = ImageIO.read(Board.class.getResource("/Images/KingdomBuilderBoard_Quadrant3.png"));
            boardImageQuadrant4 = ImageIO.read(Board.class.getResource("/Images/KingdomBuilderBoard_Quadrant4.png"));

            int[] tempPointsX = new int[6];
            int[] tempPointsY = new int[6];
            int position = 0;

            for(int i = 0; i < 20; i++){
                for(int j = 0; j < 40; j += 2){

                    if(i % 2 == 1 && j == 0) j += 1;

                    for (int k = 0; k < 6; k++){
                        tempPointsX[k] = startPointsX[k] + offSetMarginX * (i % 2) + hexagonShiftX * j / 2;
                        tempPointsY[k] = startPointsY[k] + i * hexagonShiftY;
                    }

                    switch (quadrants.get(position)) {
                        case "0" -> hexes[i][j] = new BasicHex(tempPointsX, tempPointsY, null, "desert");
                        case "1" -> hexes[i][j] = new BasicHex(tempPointsX, tempPointsY, null, "water");
                        case "2" -> hexes[i][j] = new BasicHex(tempPointsX, tempPointsY, null, "mountain");
                        case "3" -> hexes[i][j] = new BasicHex(tempPointsX, tempPointsY, null, "flower");
                        case "4" -> hexes[i][j] = new BasicHex(tempPointsX, tempPointsY, null, "meadow");
                        case "5" -> hexes[i][j] = new BasicHex(tempPointsX, tempPointsY, null, "forest");
                        case "6" -> hexes[i][j] = new BasicHex(tempPointsX, tempPointsY, null, "canyon");
                        case "7" -> hexes[i][j] = new ExtraActionHex(tempPointsX, tempPointsY, null, "oasis");
                        case "8" -> hexes[i][j] = new BasicHex(tempPointsX, tempPointsY, null, "city");
                        case "9" -> hexes[i][j] = new ExtraActionHex(tempPointsX, tempPointsY, null, "paddock");
                        case "10" -> hexes[i][j] = new ExtraActionHex(tempPointsX, tempPointsY, null, "tavern");
                        case "11" -> hexes[i][j] = new ExtraActionHex(tempPointsX, tempPointsY, null, "harbor");
                    }

                }
            }

            /*
            now that the array is filled, we can (attempt to) create the graph based on the array
            fill the Hex's ArrayList in the same images as its points are stored (top left start then go clockwise)
            {
            {1, 0, 2, 0, 3, 0, 4},
            {0, 5, 0, 6, 0, 7, 0},
            {7, 0, 8, 0, 9, 0, 10}
            }
            */

            ArrayList<Hex> tempNeighbors;

            for(int i = 0; i < 20; i++){
                for(int j = 0; j < 40; j += 2){

                    if(i % 2 == 1 && j == 0) j += 1;

                    tempNeighbors = new ArrayList<>();

                    if(i - 1 < hexes.length && i - 1 >= 0 &&
                            j - 1 < hexes[i].length && j - 1 >= 0){
                        tempNeighbors.add(hexes[i - 1][j - 1]);
//                        System.out.println("yes");
                    } else{
                        //don't know if we should add null or add a hex that says "nothing"
                      tempNeighbors.add(null);
//                        System.out.println("no");
                    }
                    if(i - 1 < hexes.length && i - 1 >= 0 &&
                            j + 1 < hexes[i].length && j + 1 >= 0){
                        tempNeighbors.add(hexes[i - 1][j + 1]);
//                        System.out.println("yes");
                    } else{
                        tempNeighbors.add(null);
//                        System.out.println("no");
                    }
                    if(i < hexes.length && i >= 0 &&
                            j + 2 < hexes[i].length && j + 2 >= 0){
                        tempNeighbors.add(hexes[i][j + 2]);
//                        System.out.println("yes");
                    } else{
                        tempNeighbors.add(null);
//                        System.out.println("no");
                    }
                    if(i + 1 < hexes.length && i + 1 >= 0 &&
                            j + 1 < hexes[i].length && j + 1 >= 0){
                        tempNeighbors.add(hexes[i + 1][j + 1]);
//                        System.out.println("yes");
                    } else{
                        tempNeighbors.add(null);
//                        System.out.println("no");
                    }
                    if(i + 1 < hexes.length && i + 1 >= 0 &&
                            j - 1 < hexes[i].length && j - 1 >= 0){
                        tempNeighbors.add(hexes[i + 1][j - 1]);
//                        System.out.println("yes");
                    } else{
                        tempNeighbors.add(null);
//                        System.out.println("no");
                    }
                    if(i < hexes.length && i >= 0 &&
                            j - 2 < hexes[i].length && j - 2 >= 0){
                        tempNeighbors.add(hexes[i][j - 2]);
//                        System.out.println("yes");
                    } else{
                        tempNeighbors.add(null);
//                        System.out.println("no");
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
        g.drawImage(images.get(2), boardX, boardY, BOARD_QUADRANT_SIZE_X, BOARD_QUADRANT_SIZE_Y, null);
        g.drawImage(images.get(1), boardX + BOARD_QUADRANT_SIZE_X - boardAdjustX, boardY, BOARD_QUADRANT_SIZE_X, BOARD_QUADRANT_SIZE_Y, null);
        g.drawImage(images.get(3), boardX, boardY + BOARD_QUADRANT_SIZE_Y - boardAdjustY, BOARD_QUADRANT_SIZE_X, BOARD_QUADRANT_SIZE_Y, null);
        g.drawImage(images.get(4), boardX + BOARD_QUADRANT_SIZE_X - boardAdjustX, boardY + BOARD_QUADRANT_SIZE_Y - boardAdjustY, BOARD_QUADRANT_SIZE_X, BOARD_QUADRANT_SIZE_Y, null);


        for(int i = 0; i < allHexes.size(); i++){
            allHexes.get(i).draw(g);
        }
    }

    /*
    When setting available moves just use highlight/unhighlight. isSettled is just a tool
    thus, highlighted boolean serves as a tool in many contexts
     */

    public void clickerTester(int x, int y){
        for(int i = 0; i < allHexes.size(); i++){
            if(allHexes.get(i).isClicked(x, y)){
                allHexes.get(i).highlight();
            }
        }

    }

    public void SetMandatorySettlementHexes(Player p) {
        //check logic
        TerrainCard c = p.getCard();
        boolean settleAnywhere = true;
        for (Hex x : allHexes) {
            if (!x.isSettled() && x.getType().equals(c.getTerrainType())) {
                ArrayList<Hex> neighbors = x.getNeighbors();
                for (Hex y : neighbors) {
                    if (y.getSettlement().getOwner().getId() == p.getId()) {
                        x.highlight();
                        settleAnywhere = false;
                    }
                }
            }
            if (settleAnywhere) {
                for (Hex z : allHexes) {
                    if (!z.isSettled() && z.getType().equals(c.getTerrainType()))
                        z.highlight();
                }
            }
        }
    }
}
