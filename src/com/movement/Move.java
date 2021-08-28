package com.movement;

import com.game.Game;
import com.helper.PieceColor;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.LinkedList;

public class Move {
    private final PieceColor color;
    private final LinkedList<Integer[]> possibleCollisions = new LinkedList<>();
    private final HashMap<Integer[],Boolean> possibleMoves = new HashMap<>(64);

    public Move(Integer @NotNull [] pos){
        color = Game.board[pos[0]][pos[1]].getCurrentPiece().getColor();
        for(int i = 0; i < Game.boardSize; i++){
            for(int j = 0; j < Game.boardSize; j++){
                possibleMoves.put(new Integer[] {i,j}, false);
            }
        }
    }

    public PieceColor getColor() { return color; }

    public HashMap<Integer[], Boolean> getPossibleMoves() { return possibleMoves; }

    public LinkedList<Integer[]> getPossibleCollisions() { return possibleCollisions; }
}
