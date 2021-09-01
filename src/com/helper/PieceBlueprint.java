package com.helper;

import com.game.Game;
import org.jetbrains.annotations.NotNull;

public class PieceBlueprint {
    private final PieceColor pieceColor;
    private final int[] pos;
    private final PieceType pieceType;
    private final String type;
    private final int x;
    private final int y;

    public PieceBlueprint(PieceType pieceType, PieceColor pieceColor, int @NotNull [] pos) {
        this.pieceType = pieceType;
        this.pieceColor = pieceColor;
        type = Game.pieceTypeToString(pieceType);
        x = pos[0];
        y = pos[1];
        this.pos = pos;
    }

    public String getType() {
        return type;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[] getPos() {
        return pos;
    }

    public PieceType getPieceType(){ return pieceType; }
}
