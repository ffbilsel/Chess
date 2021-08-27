package com.pieces;

import com.game.Piece;
import com.helper.Helper;
import com.helper.PieceColor;
import com.helper.PieceType;

public class Queen extends Piece {
    public Queen(PieceColor color) {
        super(color, PieceType.QUEEN, Helper.createId());
    }

    //TODO move function
    @Override
    public void move() {
    }
}