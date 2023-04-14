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
        players = new Player[4];
        for(int i = 0; i < 4; i++) players[i] = new Player(i);

        board = new Board();
        deck = new Deck();
        //instantiate objective cards
        mandatorySettlementsInARow = 0;
        movingExtraActionToUse = null;

        newGame();
    }

    public void newGame(){
        for(int i = 0; i < 4; i++){
            players[i].setCard(deck.drawCard());
        }
        startingPlayer = (int) (Math.random() * 4);
        turn = startingPlayer;
        isEnding = false;
        gameOver = false;
        gameState = 1;
    }

    public void playBasedOnState(int mouseX, int mouseY){

    }
}
