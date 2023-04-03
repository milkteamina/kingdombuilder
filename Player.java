public class Player{
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

    public int getId(){
        return id;
    }
    public int getScore(){
        return score;
    }
    public int setScore(int i){
        score = i;
    }
    public int getSettlementsRemaining(){
        return settlements.size();
    }
    public void draw(Graphics2D graphics){

    }
    public ExtraAction extraActionClicked(int mouseX, int mouseY){

    }
    public boolean mandatorySettlementsClicked(int mouseX, int mouseY){

    }
    public void resetExtraActions(){
        ExtraAction.isUsed = false;
    }
    public Enum getMandatorySettlementPhase(){
        return mandatorySettlementPhase;
    }
    public void setMandatorySettlementPhase(Enum e){
        mandatorySettlementPhase = e;
    }
}
