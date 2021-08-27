package com.game;

import org.jetbrains.annotations.NotNull;

public class Path {

    private final Piece capturedPiece;
    private final Integer[] pos;

    public Path(Integer @NotNull [] pos){ capturedPiece = Game.board[pos[0]][pos[1]].getCurrentPiece(); this.pos = pos; }

    public Piece getCapturedPiece() { return capturedPiece; }

    public Integer[] getPos() { return pos; }

}
