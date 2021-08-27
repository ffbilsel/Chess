package com.pieces;

import com.game.Piece;
import com.helper.Helper;
import com.helper.PieceColor;
import com.helper.PieceType;

public class King extends Piece {
    public King(PieceColor color) {
        super(color, PieceType.KING, Helper.createId());
    }

    //TODO move function
    @Override
    public void move() {
    }
}