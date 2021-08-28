package com.movement;

import com.game.Cell;
import com.game.Game;

public class MoveKing extends Move implements MoveType{

    private final int x;
    private final int y;

    public MoveKing(Integer[] pos){
        super(pos);
        x = pos[0];
        y = pos[1];
    }

    private void king(){
        Integer[] currentPos = new Integer[]{x,y};
        Cell currentCell = Game.board[x][y];
        if(currentCell.isEmpty()){
            super.getPossibleMoves().put(currentPos,true);
        }
        else if(currentCell.getCurrentPiece().getColor() != getColor()){
            getPossibleMoves().put(currentPos,true);
            getPossibleCollisions().add(currentPos);
        }
    }

    @Override
    public void move() { this.king(); }
}
