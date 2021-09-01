package com.movement;

import com.game.Game;
import com.helper.PieceColor;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class Move {
    private final PieceColor color;
    private final HashMap<Integer, Boolean> possibleMoves = new HashMap<>(64);
    public int x;
    public int y;

    public Move(int @NotNull [] pos, PieceColor color) {
        x = pos[0];
        y = pos[1];
        this.color = color;
        for (int i = 0; i < Game.boardSize; i++) {
            for (int j = 0; j < Game.boardSize; j++) {
                possibleMoves.put(Game.generateHash(new Integer[]{i, j}), false);
            }
        }
    }

    public PieceColor getColor() {
        return color;
    }

    public HashMap<Integer, Boolean> getPossibleMoves() {
        return possibleMoves;
    }

    public void setPos(int @NotNull [] pos) {
        x = pos[0];
        y = pos[1];
    }
}
