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

    }

    public ExtraAction extraActionClicked(int mouseX, int mouseY){
        //placeholder for testing
        return null;
    }

    public boolean mandatorySettlementsClicked(int mouseX, int mouseY){
        //placeholder for testing
        return false;
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
