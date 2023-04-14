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
       
       
           g.setColor(new Color(245, 229, 193));
           g.fillRoundRect(825, 400, 300, 200, 50, 30);
           g.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
           g.setColor(Color.BLACK);
           g.drawString("Player " + getId(), 1000, 575);
           if(player.getId() == 0){
            g.setColor(new Color(242, 122, 10 ));
            } else if(player.getId() == 1){
            g.setColor(new Color(200, 66, 245));
            } else if(player.getId() == 2){
            g.setColor(Color.BLACK);
            } else if(player.getId() == 3){
            g.setColor(Color.DARK_GRAY);
            }
           g.fillRect(850, 530, 60, 50);
           int[] x = {840, 880, 920};
           int[] y = {540, 500, 540};
           g.fillPolygon( x, y, 3);
           g.setColor(Color.WHITE);
           Font stringFont = new Font( "SansSerif", Font.PLAIN, 40);
           g.setFont(stringFont);
           g.drawString(getSettlementsRemaining(), 857, 565);

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
