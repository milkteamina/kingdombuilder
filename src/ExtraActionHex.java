import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class ExtraActionHex extends Hex {
    private boolean[] adjacentPlayers;
    private ArrayList<ExtraAction> extraActions;
    private String extraActionType;
    private static final int extraActionSpacingX = 2;
    private static final int extraActionSpacingY = 9;


    public ExtraActionHex(int[] pointsX, int[] pointsY, ArrayList<Hex> neighbors, String extraActionType) {
        super(pointsX, pointsY, neighbors);
        this.extraActionType = extraActionType;
        adjacentPlayers = new boolean[6];
        extraActions = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            adjacentPlayers[i] = false;
        }

        switch (extraActionType) {
            case "harbor" -> {
                extraActions.add(new Harbor(getPointsX()[0] - extraActionSpacingX, getPointsY()[0] - extraActionSpacingY));
                extraActions.add(new Harbor(getPointsX()[0] - extraActionSpacingX, getPointsY()[0] - extraActionSpacingY));
            }
            case "oasis" -> {
                extraActions.add(new Oasis(getPointsX()[0] - extraActionSpacingX, getPointsY()[0] - extraActionSpacingY));
                extraActions.add(new Oasis(getPointsX()[0] - extraActionSpacingX, getPointsY()[0] - extraActionSpacingY));
            }
            case "paddock" -> {
                extraActions.add(new Paddock(getPointsX()[0] - extraActionSpacingX, getPointsY()[0] - extraActionSpacingY));
                extraActions.add(new Paddock(getPointsX()[0] - extraActionSpacingX, getPointsY()[0] - extraActionSpacingY));
            }
            case "tavern" -> {
                extraActions.add(new Tavern(getPointsX()[0] - extraActionSpacingX, getPointsY()[0] - extraActionSpacingY));
                extraActions.add(new Tavern(getPointsX()[0] - extraActionSpacingX, getPointsY()[0] - extraActionSpacingY));
            }
        }
    }

    public void draw(Graphics g){
        super.draw(g);
        for(int i = 0; i < extraActions.size(); i++){
            extraActions.get(i).draw(g);
        }
    }
    public boolean isDepleted() {
        return extraActions.size() == 0;
    }

    public void giveExtraAction(Player player) {

    }

    public boolean hasGivenToPlayer(Player player) {
        return adjacentPlayers[player.getId()];
    }

    public boolean hasMovedAway(Player player) {
        //scuffed af
        if(hasGivenToPlayer(player)){
            for(Hex h : super.getNeighbors()){
                if(h.getSettlement() != null && h.getSettlement().getOwner().getId() == player.getId()){
                    return false;
                }
            }
        }
        return true;
    }

    public String getType(){
        return extraActionType;
    }
}
