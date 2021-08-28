package com.movement;

import com.game.Cell;
import com.game.Game;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public class MoveDiagonal extends Move implements MoveType {

    private final int x;
    private final int y;

    public MoveDiagonal(Integer[] pos){
        super(pos);
        x = pos[0];
        y = pos[1];
    }

    private void diagonal(int x, int y){
        int[] numbers = new int[] {x,y};
        char[] chars =  new char[] {'+', '-'};
        for(int i = 0;i < 2;i++){
            for(int j = 0;j < 2;j++){
                moveDiagonalHelper(numbers,chars );
            }
        }
    }

    private void moveDiagonalHelper(int @NotNull [] varsInit, char @NotNull [] operations){

        int[] vars = new int[] { retVar(varsInit[0], operations[0]), retVar(varsInit[1], operations[1])};
        Function<Integer,Boolean> cond1 = operations[0] == '-' ? i -> i > 0 :i -> i < Game.boardSize;
        Function<Integer,Boolean> cond2 = operations[1] == '-' ? i -> i > 0 :i -> i < Game.boardSize;
        Function<Integer,Integer> operation1 = operations[0] == '-' ? i -> i-- :i -> i++;
        Function<Integer,Integer> operation2 = operations[1] == '-' ? i -> i-- :i -> i++;
        while(cond1.apply(vars[0]) && cond2.apply(vars[1])){

            Integer[] currentPos = new Integer[]{x,y};
            Cell currentCell = Game.board[x][y];
            if(currentCell.isEmpty()){
                super.getPossibleMoves().put(currentPos,true);
                vars[0] = operation1.apply(vars[0]);
                vars[1] = operation2.apply(vars[1]);
            }

            else if(currentCell.getCurrentPiece().getColor() != getColor()){
                getPossibleMoves().put(currentPos,true);
                getPossibleCollisions().add(currentPos);
                break;
            }
            else{
                return;
            }

        }

    }
    private int retVar(int var, int operator){
        return operator == '-' ? var - 1 : var + 1;
    }

    @Override
    public void move() { diagonal(x,y); }
}
