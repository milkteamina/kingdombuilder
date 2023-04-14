import java.sql.Array;

public class Gamestate {

    private Player[] players;
    private Board board;
    private Deck deck;
    private ObjectiveCard[] objectiveCards;
    private int startingPlayer;
    private int turn;
    private int gameState;
    private String message;
    private boolean isEnding;
    private boolean gameOver;
    private int mandatorySettlementsInARow;
    private ExtraAction movingExtraActionToUse;

    public Gamestate(){

    }

    public void newGame(){

    }

    public void playBasedOnState(int mouseX, int mouseY){

    }
}
