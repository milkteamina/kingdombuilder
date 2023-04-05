import java.util.ArrayList;

public class ExtraActionHex extends Hex {
    private boolean[] adjacentPlayers;
    private ArrayList<ExtraAction> extraActions;
    //could be useful
    private String extraActionType;


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
                extraActions.add(new Harbor());
                extraActions.add(new Harbor());
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
        if(adjacentPlayers[player.getId()]){
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
