package com.pieces;

import com.game.Game;
import com.helper.PieceColor;
import com.helper.PieceType;
import com.movement.MoveType;
import org.jetbrains.annotations.NotNull;

import java.util.Stack;

public abstract class Piece {

    private final PieceColor color;
    private final MoveType[] moveType;
    private final PieceType pieceType;
    private int[] pos;
    private final Stack<Integer[]> lastPos = new Stack<>();

    public Piece(PieceColor color, MoveType[] moveType, int @NotNull [] pos, int[] lastPos, PieceType pieceType){
        this.color = color;
        this.moveType = moveType;
        this.lastPos.push(Game.convertToIntegerArray(lastPos));
        this.pos = pos;
        this.pieceType = pieceType;
    }

    public PieceColor getColor() {
        return color;
    }

    public PieceType getPieceType(){ return pieceType; }

    public MoveType[] getMoveType() { return moveType; }

    public void setPos(int @NotNull [] pos) { this.pos = pos; }

    public Stack<Integer[]> getLastPos() { return lastPos; }

    public int[] getPos(){ return pos; }

    public void addLastPos(Integer[] arr){ lastPos.push(arr); }

}
