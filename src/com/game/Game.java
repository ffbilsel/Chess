package com.game;


import com.helper.Helper;
import com.helper.PieceBlueprint;
import com.helper.PieceColor;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;
import java.util.Stack;

public class Game {

    private final Stack<Path> log = new Stack<>();
    public static Cell[][] board = new Cell[8][8];
    public static final int boardSize = 8;

    public void addPiece(@NotNull PieceBlueprint pieceBlueprint) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Cell targetCell = board[pieceBlueprint.getX()][pieceBlueprint.getY()];
        if(targetCell == null){
            board[pieceBlueprint.getX()][pieceBlueprint.getY()] = new Cell();
            targetCell = board[pieceBlueprint.getX()][pieceBlueprint.getY()];
        }
        if(targetCell.isEmpty()){
            String className = "com.pieces." + pieceBlueprint.getType();
            targetCell.setCurrentPiece((Piece) Class.forName(className).getConstructor(PieceColor.class).newInstance(pieceBlueprint.getPieceColor()));
        }
    }

    public void deletePiece(Integer @NotNull [] pos){
        Cell targetCell = board[pos[0]][pos[1]];
        if(!targetCell.isEmpty()){
            Helper.pushId(targetCell.getCurrentPiece().getId());
            targetCell.setCurrentPiece(null);
            targetCell.setEmpty();
        }
    }

    //TODO redo Function
    public void redo(){

    }

    //TODO isCheck function
    public boolean isCheck(){

        return false;
    }

    //TODO move function
    public void secondCellIsClicked(){

    }

    //TODO firstCellIsClicked function -> findPossibleMoves function
    public void firstCellIsClicked(){
        findPossibleMoves();

    }

    private void findPossibleMoves(){

    }
}
