package com.pieces;

import com.game.Piece;
import com.helper.Helper;
import com.helper.PieceColor;
import com.helper.PieceType;

public class Bishop extends Piece {
    public Bishop(PieceColor color) {
        super(color, PieceType.BISHOP, Helper.createId());
    }

    //TODO move function
    @Override
    public void move() {
    }
}