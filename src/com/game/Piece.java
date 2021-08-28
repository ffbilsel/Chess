package com.game;

import com.helper.PieceColor;
import com.helper.PieceType;
import com.movement.MoveType;

public abstract class Piece {

    private final PieceColor color;
    private final PieceType type;
    private final int id;
    private final MoveType[] moveType;
    private int x;
    private int y;

    public Piece(PieceColor color, PieceType type, int id, MoveType[] moveType, int x, int y){
        this.type = type;
        this.color = color;
        this.id = id;
        this.moveType = moveType;
        this.x = x;
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public PieceColor getColor() {
        return color;
    }

    public PieceType getType() { return type; }

    public MoveType[] getMoveType() { return moveType; }

    public int getX() { return x; }

    public int getY() { return y; }

    public void setX(int x) { this.x = x; }

    public void setY(int y) { this.y = y; }
}
