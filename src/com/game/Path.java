package com.game;

import com.pieces.Piece;
import org.jetbrains.annotations.NotNull;

public class Path {

    private Piece capturedPiece;
    private final int[] pos;
    private static  int counter = 0;
    public Path(int @NotNull [] pos){ capturedPiece = Game.board[pos[0]][pos[1]].getCurrentPiece(); this.pos = pos; counter++; }

    public int getCounter(){ return counter; }
    public Piece getCapturedPiece() { return capturedPiece; }
    public int[] getPos() { return pos; }
}
