import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Player {
    private ArrayList<Settlement> settlements;
    private ArrayList<ExtraAction> extraActions;
    private TerrainCard card;
    private int id;
    private int score;
    private int extraActionSpacingX;
    private int extraActionSpacingY;
    private int mandatorySettlementsButtonX;
    private int mandatorySettlementsButtonY;
    private int cardX;
    private int cardY;
    private Enum mandatorySettlementPhase;

    public Player(){

    }

    public int getId(){
        return id;
    }

    public int getScore(){
        return score;
    }

    public void setScore(int score){
        this.score = score;
    }

    public int getSettlementsRemaining(){
        return settlements.size();
    }

    public void draw(Graphics g){
        //fix placement of all stuff (x and y)
        g.setColor(Color.WHITE);
        g.fillRect(100, 500, 300, 200);
        // figure out how to make it the player's color instead of red
        g.setColor(Color.RED);
        // figure out triangle placement (roof of little settlement thing)
        g.fillPolygon(null, null, 3);
        g.fillRect(115, 650, 30, 30);
        g.setColor(Color.BLACK);
        String k = 40-settlements.size() + "";
        g.drawString( k, 120, 655);
        g.drawString("Player" + getId(), 250, 650 );
    }

    public ExtraAction extraActionClicked(int mouseX, int mouseY){

    }

    public boolean mandatorySettlementsClicked(int mouseX, int mouseY){

    }

    public void resetExtraActions(){
        for(int i = 0; i < extraActions.size(); i++){
            extraActions.get(i).reset();
        }
    }

    public Enum getMandatorySettlementPhase(){
        return mandatorySettlementPhase;
    }

    public void setMandatorySettlementPhase(Enum e){
        mandatorySettlementPhase = e;
    }


}
