package com.movement;

import com.game.Cell;
import com.game.Game;
import com.helper.PieceColor;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class MoveKnight extends Move implements MoveType{

    public MoveKnight(int @NotNull [] pos, PieceColor color){
        super(pos, color);
    }

    public void knight() {
        Integer[] currentPos;
        Cell currentCell;
        int tempX, tempY;
        int boardSize = Game.boardSize;
        tempX = x - 1;
        tempY = y - 2;
        test(tempX, tempY, boardSize, 1, 2);
        tempX = x + 1;
        tempY = y - 2;
        if(tempX < boardSize && tempY <= 0){
            currentPos = new Integer[]{tempX, tempY};
            currentCell = Game.board[tempX][tempY];
            test(currentPos, currentCell);
        }
        tempX = x + 1;
        tempY = y + 2;
        if(tempX < boardSize && tempY < boardSize){
            currentPos = new Integer[]{tempX, tempY};
            currentCell = Game.board[tempX][tempY];
            test(currentPos, currentCell);
        }
        tempX = x - 2;
        tempY = y - 1;
        test(tempX, tempY, boardSize, 2, 1);
        tempX = x + 2;
        tempY = y - 1;
        if(tempX < boardSize && tempY >= 0){
            currentPos = new Integer[]{tempX, tempY};
            currentCell = Game.board[tempX][tempY];
            test(currentPos, currentCell);
        }
        tempX = x + 2;
        tempY = y + 1;
        if(tempX < boardSize && tempY < boardSize){
            currentPos = new Integer[]{tempX, tempY};
            currentCell = Game.board[tempX][tempY];
            test(currentPos, currentCell);
        }
    }

    private void test(int tempX, int tempY, int boardSize, int i, int i2) {
        Integer[] currentPos;
        Cell currentCell;
        if(tempX >= 0 && tempY >= 0){
            currentPos = new Integer[]{tempX, tempY};
            currentCell = Game.board[tempX][tempY];
            test(currentPos, currentCell);
        }
        tempX = x - i;
        tempY = y + i2;
        if(tempX >= 0 && tempY <= boardSize){
            currentPos = new Integer[]{tempX, tempY};
            currentCell = Game.board[tempX][tempY];
            test(currentPos, currentCell);
        }
    }

    private void test(Integer[] currentPos, @NotNull Cell currentCell){
        if(currentCell.isEmpty()){
            super.getPossibleMoves().put(Game.generateHash(currentPos),true);
        }
        else if(currentCell.getCurrentPiece().getColor() != getColor()){
            getPossibleMoves().put(Game.generateHash(currentPos),true);
        }
    }

    @Override
    public HashMap<Integer,Boolean> move() { this.knight();  return getPossibleMoves(); }
}
