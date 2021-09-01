package com.game;

import com.gui.ChessBoard;
import com.helper.PieceBlueprint;
import com.helper.PieceColor;
import com.helper.PieceType;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class Main {

    //TODO add sandbox
    //TODO add default game mode
    //TODO add AI
    //TODO add swing
    //TODO add timer
    //TODO add game over
    //TODO choose color
    //TODO add check

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        Game game = new Game();

        game.addPiece(new PieceBlueprint(PieceType.ROOK, PieceColor.BLACK, new int[]{0,0}));
        game.addPiece(new PieceBlueprint(PieceType.KNIGHT, PieceColor.BLACK, new int[]{1,0}));
        game.addPiece(new PieceBlueprint(PieceType.BISHOP, PieceColor.BLACK, new int[]{2,0}));
        game.addPiece(new PieceBlueprint(PieceType.QUEEN, PieceColor.BLACK, new int[]{3,0}));
        game.addPiece(new PieceBlueprint(PieceType.KING, PieceColor.BLACK, new int[]{4,0}));
        game.addPiece(new PieceBlueprint(PieceType.BISHOP, PieceColor.BLACK, new int[]{5,0}));
        game.addPiece(new PieceBlueprint(PieceType.KNIGHT, PieceColor.BLACK, new int[]{6,0}));
        game.addPiece(new PieceBlueprint(PieceType.ROOK, PieceColor.BLACK, new int[]{7,0}));
        game.addPiece(new PieceBlueprint(PieceType.ROOK, PieceColor.WHITE, new int[]{0,7}));
        game.addPiece(new PieceBlueprint(PieceType.KNIGHT, PieceColor.WHITE, new int[]{1,7}));
        game.addPiece(new PieceBlueprint(PieceType.BISHOP, PieceColor.WHITE, new int[]{2,7}));
        game.addPiece(new PieceBlueprint(PieceType.QUEEN, PieceColor.WHITE, new int[]{3,7}));
        game.addPiece(new PieceBlueprint(PieceType.KING, PieceColor.WHITE, new int[]{4,7}));
        game.addPiece(new PieceBlueprint(PieceType.BISHOP, PieceColor.WHITE, new int[]{5,7}));
        game.addPiece(new PieceBlueprint(PieceType.KNIGHT, PieceColor.WHITE, new int[]{6,7}));
        game.addPiece(new PieceBlueprint(PieceType.ROOK, PieceColor.WHITE, new int[]{7,7}));
        for(int i = 0; i < 8; i++){
            game.addPiece(new PieceBlueprint(PieceType.PAWN, PieceColor.BLACK, new int[]{i,1}));
            game.addPiece(new PieceBlueprint(PieceType.PAWN, PieceColor.WHITE, new int[]{i,6}));
        }

        ChessBoard cb = new ChessBoard(game);
        JFrame f = new JFrame("ChessChamp");
        f.add(cb.getGui());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationByPlatform(true);
        f.pack();
        f.setMinimumSize(f.getSize());
        Game.autoKeyListener(f,game);
        f.setVisible(true);
        game.setGameChessBoard(cb);
    }
}
