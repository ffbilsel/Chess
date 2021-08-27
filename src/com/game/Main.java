package com.game;

import com.helper.*;

import java.lang.reflect.InvocationTargetException;

public class Main {

    //TODO add sandbox
    //TODO add default game mode
    //TODO add AI
    //TODO add swing
    //TODO add time
    //TODO add check
    //TODO add game over

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        CustomLinkedList<Integer[]> test = new CustomLinkedList<>(new Integer[] {1,2});
        test.add(new Integer[] {3,4});
        test.add(new Integer[] {5,6});

        for (Integer[] pos: test) {
            for(Integer i:pos){
                System.out.println(i);
            }
        }
        System.out.println("-----------");

        CustomLinkedList<Integer[]> test2 = new CustomLinkedList<>(new Integer[] {10,15});
        test2.add(new Integer[] {17,18, 25, 30});
        test.merge(test2);

        for (Integer[] pos: test) {
            for(Integer i:pos){
                System.out.println(i);
            }
        }

        System.out.println("-----------");
        //TODO remove CustomLinkedList and customIterator
        PieceBlueprint pieceBlueprint = new PieceBlueprint(PieceType.PAWN,PieceColor.BLACK,new Integer[] {1,3});
        Game newGame = new Game();
        newGame.addPiece(pieceBlueprint);
        Piece currentPiece = Game.board[1][3].getCurrentPiece();
        System.out.println(Helper.pieceTypeToString(currentPiece.getType()) + currentPiece.getColor() + currentPiece.getId());
        newGame.deletePiece(pieceBlueprint.getPos());
        currentPiece = Game.board[1][3].getCurrentPiece();
        if(currentPiece == null){ System.out.println("Deletion completed"); }
        newGame.addPiece(pieceBlueprint);
        currentPiece = Game.board[1][3].getCurrentPiece();
        System.out.println(Helper.pieceTypeToString(currentPiece.getType()) + currentPiece.getColor() +currentPiece.getId());
        pieceBlueprint = new PieceBlueprint(PieceType.ROOK,PieceColor.BLACK,new Integer[] {1,5});
        newGame.addPiece(pieceBlueprint);
        currentPiece = Game.board[1][5].getCurrentPiece();
        System.out.println(Helper.pieceTypeToString(currentPiece.getType()) + currentPiece.getColor() +currentPiece.getId());
        pieceBlueprint = new PieceBlueprint(PieceType.PAWN,PieceColor.BLACK,new Integer[] {4,3});
        newGame.addPiece(pieceBlueprint);
        currentPiece = Game.board[4][3].getCurrentPiece();
        System.out.println(Helper.pieceTypeToString(currentPiece.getType()) + currentPiece.getColor() +currentPiece.getId());
        System.out.println("46546");
    }
}
