package com.movement;

import com.game.Cell;
import com.game.Game;
import com.helper.PieceColor;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.function.Function;

public class MoveLine extends Move implements MoveType {

    public MoveLine(int @NotNull [] pos, PieceColor color){
        super(pos ,color);
    }


    private void line(int x,int y) {
        char[] chars = new char[] {'x', 'y'};
        char[] operators = new char[] {'-', '+'};
        for(int i = 0;i < 2;i++){
            for(int j = 0;j < 2;j++){
                moveLineHelper(x, y, chars[i], operators[i]);
            }
        }
    }

    private void moveLineHelper(int x, int y, char varC, char operationC){

        Function<Integer,Boolean> cond = operationC == '-' ? i -> i > 0 : i -> i < Game.boardSize;
        int var = varC == 'x' ? operationC == '-' ? x-1 : x + 1 : operationC == '-' ? y-1 : y + 1;
        Function<Integer,Integer> operation = operationC == '-' ? i -> i-- :i -> i++;
        while(cond.apply(var)){

            Integer[] currentPos = new Integer[]{x,y};
            Cell currentCell = Game.board[x][y];
            if(currentCell.isEmpty()){
                getPossibleMoves().put(Game.generateHash(currentPos),true);
                var = operation.apply(var);
            }

            else if(currentCell.getCurrentPiece().getColor() != getColor()){
                getPossibleMoves().put(Game.generateHash(currentPos),true);
                break;
            }
            else{
                return;
            }

        }

    }

    @Override
    public HashMap<Integer,Boolean> move() { line(x,y);  return getPossibleMoves(); }
}
