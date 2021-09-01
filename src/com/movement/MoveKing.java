package com.movement;

import com.game.Cell;
import com.game.Game;
import com.helper.PieceColor;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class MoveKing extends Move implements MoveType{


    public MoveKing(int @NotNull [] pos, PieceColor color){
        super(pos, color);
    }

    private void king(){
        Integer[] currentPos;
        Cell currentCell;
        for(int i = x - 1; i < x + 1; i++){
            for(int j = y - 1; j < y + 1; j++){
                if(i < 0 || i > Game.boardSize || j < 0 || j > Game.boardSize || i == x || j == y){
                    continue;
                }
                currentPos = new Integer[]{i,j};
                currentCell = Game.board[i][j];
                if(currentCell.isEmpty()){
                    super.getPossibleMoves().put(Game.generateHash(currentPos),true);
                }
                else if(currentCell.getCurrentPiece().getColor() != getColor()){
                    getPossibleMoves().put(Game.generateHash(currentPos),true);
                }
            }
        }
    }

    @Override
    public HashMap<Integer,Boolean> move() { this.king();  return getPossibleMoves(); }
}
