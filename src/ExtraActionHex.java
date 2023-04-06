import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class ExtraActionHex extends Hex {
    private boolean[] adjacentPlayers;
    private ArrayList<ExtraAction> extraActions;
    private String extraActionType; //could be useful

    private static final int extraActionSpacingX = 1;
    private static final int extraActionSpacingY = 1;


    public ExtraActionHex(int x, int y, ArrayList<Hex> neighbors, String extraActionType) {
        super(x, y, neighbors);
        this.extraActionType = extraActionType;
        adjacentPlayers = new boolean[6];
        extraActions = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            adjacentPlayers[i] = false;
        }

        switch (extraActionType) {
            case "harbor" -> {
                extraActions.add(new Harbor(getX() + extraActionSpacingX, getY() + extraActionSpacingY));
                extraActions.add(new Harbor(getX() + extraActionSpacingX, getY() + extraActionSpacingY));
            }
            case "oasis" -> {
                extraActions.add(new Oasis());
                extraActions.add(new Oasis());
            }
            case "paddock" -> {
                extraActions.add(new Paddock());
                extraActions.add(new Paddock());
            }
            case "tavern" -> {
                extraActions.add(new Tavern());
                extraActions.add(new Tavern());
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
        //TODO
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

    public String getExtraActionType(){
        return extraActionType;
    }
}
