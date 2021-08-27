package com.movement;

import com.game.Cell;
import com.game.Game;
import com.helper.PieceColor;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.LinkedList;

//TODO Ask how to shorten
public class Patterns {

    private final PieceColor color;
    private final int x;
    private final int y;
    private final LinkedList<Integer[]> possibleCollisions = new LinkedList<>();
    private final HashMap<Integer[],Boolean> possibleMoves = new HashMap<>(64);

    public Patterns(Integer @NotNull [] pos){
        this.x = pos[0]; this.y = pos[1];
        color = Game.board[x][y].getCurrentPiece().getColor();
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                possibleMoves.put(new Integer[] {i,j}, false);
            }
        }
    }

    public void moveLine() {

        this.moveHorizontalUpwards(possibleMoves,x,y-1);
        this.moveHorizontalDownwards(possibleMoves,x,y+1);

    }

    private void moveHorizontalUpwards(HashMap<Integer[],Boolean> possibleMoves,int x, int y){

        while(y >= 0){

            Integer[] currentPos = new Integer[]{x,y};
            Cell currentCell = Game.board[x][y];
            if(currentCell.isEmpty()){
                possibleMoves.put(currentPos,true);
                y--;
            }

            else if(currentCell.getCurrentPiece().getColor() != color){
                possibleMoves.put(currentPos,true);
                possibleCollisions.add(currentPos);
                break;
            }
            else{
                return;
            }

        }

    }

    private void moveHorizontalDownwards(HashMap<Integer[],Boolean> possibleMoves,int x, int y){

        while(y < Game.boardSize){

            Integer[] currentPos = new Integer[]{x,y};
            Cell currentCell = Game.board[x][y];
            if(currentCell.isEmpty()){
                possibleMoves.put(currentPos,true);
                y++;
            }

            else if(currentCell.getCurrentPiece().getColor() != color){
                possibleMoves.put(currentPos,true);
                possibleCollisions.add(currentPos);
                break;
            }

            else{
                return;
            }

        }

    }

}
