import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Player {

    private static final int extraActionSpacingX = 0;
    private static final int extraActionSpacingY = 0;
    private static final int mandatorySettlementsButtonX = 0;
    private static final int mandatorySettlementsButtonY = 0;
    private static final int cardX = 0;
    private static final int cardY = 0;
    private final int id;
    private ArrayList<Settlement> settlements;
    private ArrayList<ExtraAction> extraActions;
    private TerrainCard card;
    private int score;
    private MandatorySettlementPhase mandatorySettlementPhase;

    public Player(int id){
        this.id = id;
        settlements = new ArrayList<>();
        
        for(int i = 0; i < 40; i++){
            settlements.add(new Settlement(this));
        }
        
        extraActions = new ArrayList<>();
        int score = 0;
        mandatorySettlementPhase = MandatorySettlementPhase.hasNotUsed;
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
        //perhaps we can figure this out w/basic math instead of with a bunch of methods
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

    public MandatorySettlementPhase getMandatorySettlementPhase(){
        return mandatorySettlementPhase;
    }

    public void setMandatorySettlementPhase(MandatorySettlementPhase p){
        mandatorySettlementPhase = p;
    }


}
