import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Player {

    private static final int extraActionSpacingX = 0;
    private static final int extraActionSpacingY = 0;

    private static final int mandatorySettlementButtonSize = 50;
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

    public void placeSettlement(Hex h){
        if(getSettlementsRemaining() > 0){
            h.placeSettlement(settlements.remove(0));
        }
    }

    public void giveExtraAction(ExtraAction extraAction){
//        ExtraActionHex hex = (ExtraActionHex) h;
        extraActions.add(extraAction);
    }

    public TerrainCard getCard(){
        return card;
    }
    public void setCard(TerrainCard c){
        card = c;
    }

    public void draw(Graphics g){
        //edit this later
        g.setColor(new Color(245, 229, 193));
        g.fillRoundRect(825, 400, 300, 200, 50, 30);
        g.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
        g.setColor(Color.BLACK);
        g.drawString("Player " + getId(), 1000, 575);
        if (id == 0) {
            g.setColor(new Color(242, 122, 10));
        } else if (id == 1) {
            g.setColor(new Color(200, 66, 245));
        } else if (id == 2) {
            g.setColor(Color.BLACK);
        } else if (id == 3) {
            g.setColor(Color.DARK_GRAY);
        }
        g.fillRect(850, 530, 60, 50);
        int[] x = {840, 880, 920};
        int[] y = {540, 500, 540};
        g.fillPolygon(x, y, 3);
        g.setColor(Color.WHITE);
        Font stringFont = new Font("SansSerif", Font.PLAIN, 40);
        g.setFont(stringFont);
        g.drawString(" " + getSettlementsRemaining(), mandatorySettlementsButtonX, mandatorySettlementsButtonY);
        card.draw(g, 1025, 430);
    }

    public ExtraAction extraActionClicked(int mouseX, int mouseY){
        //perhaps we can later figure this out w/basic math instead of with a bunch of methods
        for(int i = 0; i < extraActions.size(); i++){
            if(extraActions.get(i).isClicked(mouseX, mouseY)) return extraActions.get(i);
        }

        return null;

    }

    public boolean mandatorySettlementsClicked(int mouseX, int mouseY){
        return mouseX > mandatorySettlementsButtonX && mouseX < mandatorySettlementsButtonX + mandatorySettlementButtonSize &&
                mouseY > mandatorySettlementsButtonY && mouseY < mandatorySettlementsButtonY + mandatorySettlementButtonSize;
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
