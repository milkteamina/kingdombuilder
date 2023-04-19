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

        newGame();
    }

    public void newGame(){
//        board.reset():
//        deck.reset();
        for(int i = 0; i < 4; i++){
            players[i].setCard(deck.drawCard());
        }
        startingPlayer = (int) (Math.random() * 4);
        turn = startingPlayer;
        isEnding = false;
        gameOver = false;
        gameState = 1;
        //set message before each state occurs
        message = "Click on either an extra-action or the mandatory settlements";
    }

    public void playBasedOnState(int mouseX, int mouseY) {

        switch(gameState){

            case 1 -> {
                if(players[turn].extraActionClicked(mouseX, mouseY) != null &&
                players[turn].extraActionClicked(mouseX, mouseY).doesItMove())
                {
                    //players[turn].extraActionClicked(mouseX, mouseY).doExtraAction(this, ?, ?);
                    movingExtraActionToUse = players[turn].extraActionClicked(mouseX, mouseY).copy();
                    gameState = 2;
                    message = "Click which settlement you would like to move";
                } else if(players[turn].extraActionClicked(mouseX, mouseY) != null &&
                        !players[turn].extraActionClicked(mouseX, mouseY).doesItMove())
                {
                    players[turn].extraActionClicked(mouseX, mouseY).setAvailableMoves(board, players[turn], null);
                    message = "Click the highlighted hex you would like to settle";
                    gameState = 3;
                }
                else if(players[turn].mandatorySettlementsClicked(mouseX, mouseY) &&
                        players[turn].getMandatorySettlementPhase().equals(MandatorySettlementPhase.hasNotUsed))
                {
                    players[turn].setMandatorySettlementPhase(MandatorySettlementPhase.isUsing);
                    //board.setMandatorySettlementHexes(Player p);
                    message = "Click the highlighted hex you would like to settle";
                    gameState = 3;
                }

            }

            case 2 ->{
                for(int i = 0; i < board.getAllHexes().size(); i++){
                    if(board.getAllHexes().get(i).isClicked(mouseX, mouseY) &&
                            board.getAllHexes().get(i).getSettlement().getOwner().getId() == turn){

                        if(movingExtraActionToUse.getExtraActionType().equals("harbor"))
                        {
                            movingExtraActionToUse.setAvailableMoves(board, players[turn], board.getAllHexes().get(i));
                            message = "CLick the highlighted hex you would like to settle";
                            gameState = 3;
                        }
                        else if(movingExtraActionToUse.getExtraActionType().equals("paddock"))
                        {
                            //checking available moves for paddock may move into a method
                            for(int j = 0; j < 6; j++){
                                switch(board.getAllHexes().get(i).getNeighbors().get(j).getNeighbors().get(j).getType()){
                                    case "desert", "flower", "meadow", "forest", "canyon" ->{
                                        movingExtraActionToUse.setAvailableMoves(board, players[turn], board.getAllHexes().get(i));
                                        message = "CLick the highlighted hex you would like to settle";
                                        gameState = 3;
                                    }
                                    default -> {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            case 3 ->{
                for(int i = 0; i < board.getAllHexes().size(); i++){
                    if(board.getAllHexes().get(i).isClicked(mouseX, mouseY) &&
                            board.getAllHexes().get(i).isHighlighted()){

                    }
                }
            }
        }
    }
}
