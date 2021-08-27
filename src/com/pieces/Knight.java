package com.pieces;

import com.game.Piece;
import com.helper.Helper;
import com.helper.PieceColor;
import com.helper.PieceType;

public class Knight extends Piece {

    public Knight(PieceColor color) {
        super(color, PieceType.KNIGHT, Helper.createId());
    }

    //TODO move function
    @Override
    public void move() {
    }
}
