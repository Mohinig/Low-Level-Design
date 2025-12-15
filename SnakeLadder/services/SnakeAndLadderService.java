package SnakeLadder.services;

import SnakeLadder.models.Ladder;
import SnakeLadder.models.Player;
import SnakeLadder.models.Snake;
import SnakeLadder.models.SnakeAndLadderBoard;

import java.util.*;

public class SnakeAndLadderService {
    private SnakeAndLadderBoard snakeAndLadderBoard;
    private int initialPlayers;
    private Queue<Player> players;

    private boolean isGameCompleted;

    private int noOfDices;
    private boolean shouldGameContinueTillLastPlayer;
    private boolean shouldAllowMultipleDiceRollOnSix;
    private static final int DEFAULT_BOARD_SIZE=100;
    private static final int DEFAULT_NO_OF_DICES=1;

    public SnakeAndLadderService(int boardSize){
        this.snakeAndLadderBoard=new SnakeAndLadderBoard(boardSize);
        this.players=new LinkedList<Player>();
        this.noOfDices=SnakeAndLadderService.DEFAULT_NO_OF_DICES;
    }
    public SnakeAndLadderService(){
        this(SnakeAndLadderService.DEFAULT_BOARD_SIZE);
    }

   //setters for making game extensible
    public void setNoOfDices(int noOfDices) {
        this.noOfDices = noOfDices;
    }

    public void setShouldGameContinueTillLastPlayer(boolean shouldGameContinueTillLastPlayer) {
        this.shouldGameContinueTillLastPlayer = shouldGameContinueTillLastPlayer;
    }

    public void setShouldAllowMultipleDiceRollOnSix(boolean shouldAllowMultipleDiceRollOnSix) {
        this.shouldAllowMultipleDiceRollOnSix = shouldAllowMultipleDiceRollOnSix;
    }

    //initialize board
    public void setPlayers(List<Player> players){
        this.players=new LinkedList<Player>();
        this.initialPlayers=players.size();
        Map<String,Integer> playersPieces=new HashMap<String,Integer>();
        for(Player player:players){
            this.players.add(player);
            playersPieces.put(player.getId(),0);
        }
        snakeAndLadderBoard.setPlayerPiece(playersPieces);
    }
    public void setSnake(List<Snake> snakes){
        snakeAndLadderBoard.setSnakes(snakes);
    }
    public void setLadder(List<Ladder> ladders){
        snakeAndLadderBoard.setLadders(ladders);
    }

    //core logic

    private int getTotalValueAfterDiceRoll(){
        return DiceService.roll();
    }
    private boolean isGameCompleted(){
        int currrentPlayers=players.size();
        return currrentPlayers<initialPlayers;
    }
    private void movePlayers(Player player,int positions){
        int oldPosition=snakeAndLadderBoard.getPlayerPiece().get(player.getId());
        int newPosition=oldPosition+positions;
        int boardSize=snakeAndLadderBoard.getSize();
        if(newPosition>boardSize){
            newPosition=oldPosition;
        }else{
            newPosition=getNewPositionAfterGoingThroughSnakesAndLadder(newPosition);
        }
        snakeAndLadderBoard.getPlayerPiece().put(player.getId(),newPosition);
        System.out.println(player.getName()+" rolled a "+positions+" and move from "+oldPosition+" to "+newPosition);
    }
    private int getNewPositionAfterGoingThroughSnakesAndLadder(int newPosition){
        int previousPosition=newPosition;
        while(newPosition!=previousPosition){
            for(Snake snake:snakeAndLadderBoard.getSnakes()){
                if(snake.getStart()==newPosition) {
                    newPosition = snake.getEnd();
                }
            }
            for(Ladder ladder:snakeAndLadderBoard.getLadders()){
                if(ladder.getStart()==newPosition){
                    newPosition=ladder.getEnd();
                }
            }
            previousPosition=newPosition;
        }
        return newPosition;
    }
    private boolean hasPlayerWon(Player player){
        int playerPosition=snakeAndLadderBoard.getPlayerPiece().get(player.getId());
        int winningPosition=snakeAndLadderBoard.getSize();
        return playerPosition==winningPosition;
    }
    public void startGame(){
        while(!isGameCompleted()){
            int totalDiceValue=getTotalValueAfterDiceRoll();//each player rolls dice
            Player currentPlayer=players.poll();
            movePlayers(currentPlayer,totalDiceValue);
            if(hasPlayerWon(currentPlayer)){
                System.out.println(currentPlayer.getName()+"wins game");
                snakeAndLadderBoard.getPlayerPiece().remove(currentPlayer.getId());
            }
            else{
                players.add(currentPlayer);
            }
        }
    }
}
