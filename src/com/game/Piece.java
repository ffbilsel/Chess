package com.game;

import com.helper.PieceColor;
import com.helper.PieceType;

public abstract class Piece {

    private final PieceColor color;
    private final PieceType type;
    public abstract void move();
    private final int id;

    public Piece(PieceColor color, PieceType type, int id){ this.type = type; this.color = color; this.id = id; }

    public int getId() {
        return id;
    }

    public PieceColor getColor() {
        return color;
    }

    public PieceType getType() { return type; }

}
