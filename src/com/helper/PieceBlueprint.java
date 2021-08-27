package com.helper;

import org.jetbrains.annotations.NotNull;

public class PieceBlueprint {
    private final PieceColor pieceColor;
    private final Integer[] pos;
    private final String type;
    private final int x;
    private final int y;

    public PieceBlueprint(PieceType pieceType, PieceColor pieceColor, Integer @NotNull [] pos) {
        this.pieceColor = pieceColor;
        type = Helper.pieceTypeToString(pieceType);
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

    public Integer[] getPos() {
        return pos;
    }


}
