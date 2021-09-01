package com.movement;

import com.game.Cell;
import com.game.Game;
import com.helper.PieceColor;

import java.util.HashMap;

public class MovePawn extends Move implements MoveType{

    public MovePawn(int[] pos,PieceColor color){
        super(pos, color);
    }

    private void pawn(Integer x, Integer y){
        int i;
        Integer[] currentPos;
        Cell currentCell;
        boolean isFirstMove = false;
        int[] pos = new int[]{ -1,-1};
        if(!Game.log.isEmpty()){
             pos = Game.log.peek().getPos();
        }
        if(getColor() == PieceColor.BLACK){
            i = 1;
            if(y == 1){
                isFirstMove = true;
            }
            if(pos[0] != -1 && y == Game.boardSize - 2){
                if(x - 1 >= 0 && x - 1 == pos[0] ){
                    getPossibleMoves().put(Game.generateHash(new Integer[] {x - 1, Game.boardSize - 1}), true);
                }
                if(x + 1 >= 0 && x + 1 == pos[0] ){
                    getPossibleMoves().put(Game.generateHash(new Integer[] {x + 1, Game.boardSize - 1}), true);
                }
            }
        }
        else {
            i = -1;
            if(y == Game.boardSize - 1){
                isFirstMove = true;
            }
            if(pos[0] != -1 && y == 2){
                if(x - 1 >= 0 && x - 1 == pos[0] ){
                    getPossibleMoves().put(Game.generateHash(new Integer[] {x - 1, 1}), true);
                }
                if(x + 1 >= 0 && x + 1 == pos[0] ){
                    getPossibleMoves().put(Game.generateHash(new Integer[] {x + 1, 1}), true);
                }
            }
        }
        if(isFirstMove){
            if(i > 0) {
                currentPos = new Integer[]{x, y + 2};
                currentCell = Game.board[x][y + 2];
            }
            else{
                currentPos = new Integer[]{x, y - 2};
                currentCell = Game.board[x][y - 2];
            }
            if(currentCell.isEmpty()){
                super.getPossibleMoves().put(Game.generateHash(currentPos),true);
            }
        }
        y += i;
        if(y >= 0 && y < Game.boardSize){
            currentPos = new Integer[]{x, y};
            currentCell = Game.board[x][y];
            if(currentCell.isEmpty()){
                super.getPossibleMoves().put(Game.generateHash(currentPos),true);
            }
            if(x - 1 >= 0){
                currentPos = new Integer[]{x - 1, y};
                currentCell = Game.board[x - 1][y];
                if(currentCell.isEmpty() || currentCell.getCurrentPiece().getColor() != getColor()){
                    getPossibleMoves().put(Game.generateHash(currentPos),true);
                }
            }
            if(x + 1 <= Game.boardSize){
                currentPos = new Integer[]{x + 1, y};
                currentCell = Game.board[x + 1][y];
                if(currentCell.isEmpty() || currentCell.getCurrentPiece().getColor() != getColor()){
                    getPossibleMoves().put(Game.generateHash(currentPos),true);
                }
            }

        }
    }

    @Override
    public HashMap<Integer,Boolean> move() { this.pawn(x,y); return getPossibleMoves(); }
}
