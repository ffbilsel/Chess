package com.movement;

import com.game.Cell;
import com.game.Game;
import com.helper.PieceColor;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.function.Function;

public class Patterns {

    private final PieceColor color;
    private final int x;
    private final int y;
    private final LinkedList<Integer[]> possibleCollisions = new LinkedList<>();
    private final HashMap<Integer[],Boolean> possibleMoves = new HashMap<>(64);

    public Patterns(Integer @NotNull [] pos){
        this.x = pos[0]; this.y = pos[1];
        color = Game.board[x][y].getCurrentPiece().getColor();
        for(int i = 0; i < Game.boardSize; i++){
            for(int j = 0; j < Game.boardSize; j++){
                possibleMoves.put(new Integer[] {i,j}, false);
            }
        }
    }

    public void moveLine(int x,int y) {
        char[] chars = new char[] {'x', 'y'};
        char[] operators = new char[] {'-', '+'};
        for(int i = 0;i < 2;i++){
            for(int j = 0;j < 2;j++){
                moveLineHelper(x, y, chars[i], operators[i]);
            }
        }
    }

    public void moveDiagonal(int x, int y){

        for(int i = 0;i < 2;i++){
            for(int j = 0;j < 2;j++){
                moveDiagonalHelper(new int[] {x,y}, new char[] {'+', '-'} );
            }
        }
    }

    private void moveLineHelper(int x, int y, char varC, char operationC){

        Function<Integer,Boolean> cond = operationC == '-' ? i -> i > 0 :i -> i < Game.boardSize;
        int var = varC == 'x' ? operationC == '-' ? x-1 : x + 1 : operationC == '-' ? y-1 : y + 1;
        Function<Integer,Integer> operation = operationC == '-' ? i -> i-- :i -> i++;
        while(cond.apply(var)){

            Integer[] currentPos = new Integer[]{x,y};
            Cell currentCell = Game.board[x][y];
            if(currentCell.isEmpty()){
                possibleMoves.put(currentPos,true);
                var = operation.apply(var);
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
                possibleMoves.put(currentPos,true);
                vars[0] = operation1.apply(vars[0]);
                vars[1] = operation2.apply(vars[1]);
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
    private int retVar(int var, int operator){
        return operator == '-' ? var - 1 : var + 1;
    }
}
